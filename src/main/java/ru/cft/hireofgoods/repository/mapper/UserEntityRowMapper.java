package ru.cft.hireofgoods.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.cft.hireofgoods.repository.model.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserEntityRowMapper implements RowMapper<UserEntity> {
    @Override
    public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserEntity result = new UserEntity();

        result.setId(rs.getLong("id"));
        result.setFirstName(rs.getString("first_name"));
        result.setMiddleName(rs.getString("middle_name"));
        result.setLastName(rs.getString("last_name"));
        result.setLogin(rs.getString("login"));
        result.setEmail(rs.getString("email"));
        result.setUserBalance(rs.getBigDecimal("balance"));
        return result;
    }
}
