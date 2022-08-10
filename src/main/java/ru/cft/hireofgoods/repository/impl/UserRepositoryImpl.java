package ru.cft.hireofgoods.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.cft.hireofgoods.repository.UserRepository;
import ru.cft.hireofgoods.repository.model.UserEntity;

import java.math.BigDecimal;
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

    @Override//
    public List<String> selectAllUsersEmail(){
        return jdbcTemplate.query("Select email from users;",(rs, rowNum) -> rs.getString("email"));
    }

    @Override
    public void insertUser(String firstName, String lastName, String middleName, String login, String email) {
        String sql = "insert into users(first_name, last_name, middle_name, login, email, balance) values (?, ?, ?, ?, ?, 0)";
        this.jdbcTemplate.update(sql, firstName, lastName, middleName, email, login);
    }

    @Override
    public UserEntity getUserById(long id){
        String sql = "select * from users where id = ?";
        return this.jdbcTemplate.query(sql, preparedStatement -> preparedStatement.setLong(1, id), rowMapper).get(0);
    }

    @Override
    public void addMoneyToUserById(long id, BigDecimal money){
        String sql = "update users set balance = ((select balance from users where id = ?) + ?) where id = ?;";
        this.jdbcTemplate.update(sql, preparedStatement -> {
            preparedStatement.setLong(1, id);
            preparedStatement.setBigDecimal(2, money);
            preparedStatement.setLong(3, id);
        });
    }

    @Override
    public void takeMoneyFromUserById(long id, BigDecimal money){
        String sql = "update users set balance = ((select balance from users where id = ?) - ?) where id = ?;";
        this.jdbcTemplate.update(sql, preparedStatement -> {
            preparedStatement.setLong(1, id);
            preparedStatement.setBigDecimal(2, money);
            preparedStatement.setLong(3, id);
        });
    }

    @Override//ff
    public boolean userIdExists(long userId) {
        String sql = "select * from users where id = ?;";
        return this.jdbcTemplate.query(sql, preparedStatement -> preparedStatement.setLong(1, userId), rowMapper).size() > 0;
    }
}

