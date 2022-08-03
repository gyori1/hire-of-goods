package ru.cft.hireofgoods.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.cft.hireofgoods.repository.model.HireEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class HireEntityRowMapper implements RowMapper<HireEntity> {

    @Override
    public HireEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        HireEntity result = new HireEntity();

        result.setId(rs.getLong("id"));
        result.setItemName(rs.getString("item_name"));
        result.setTraderId(rs.getLong("trader_id"));
        result.setConsumerId(rs.getLong("consumer_id"));
        result.setState(rs.getInt("state"));
        result.setCost(rs.getBigDecimal("cost"));
        result.setHiringDate(rs.getLong("hire_date"));
        result.setReturnDate(rs.getLong("return_date"));
        return result;
    }
}
