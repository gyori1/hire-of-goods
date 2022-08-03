package ru.cft.hireofgoods.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.cft.hireofgoods.repository.UserRepository;
import ru.cft.hireofgoods.repository.model.UserEntity;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private JdbcTemplate jdbcTemplate;
    private RowMapper<UserEntity> rowMapper;

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate, RowMapper<UserEntity> rowMapper){
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public List<UserEntity> selectAll() {
        return jdbcTemplate.query("Select * from users;", rowMapper);
    }

    @Override
    public List<String> selectAllUsersEmail(){
        return jdbcTemplate.query("Select email from users;",(rs, rowNum) -> rs.getString("email"));
    }

    @Override
    public void insertUser(String firstName, String lastName, String middleName, String login, String email) {
        String sql = "insert into users(first_name, last_name, middle_name, login, email, balance) values (?, ?, ?, ?, ?, 0)";
        this.jdbcTemplate.update(sql, firstName, lastName, middleName, email, login);
    }


}

