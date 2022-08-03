package ru.cft.hireofgoods.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.cft.hireofgoods.repository.HireRepository;
import ru.cft.hireofgoods.repository.model.HireEntity;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class HireRepositoryImpl implements HireRepository {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<HireEntity> rowMapper;

    @Autowired
    public HireRepositoryImpl(JdbcTemplate jdbcTemplate, RowMapper<HireEntity> rowMapper){
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public List<HireEntity> selectAll() {
        return jdbcTemplate.query("Select * from hire;", rowMapper);
    }

    @Override
    public void insertItem(String itemName, Long traderId, BigDecimal cost) {
        String sql = "insert into hire (item_name, trader_id, state, cost) values (?, ?, 0, ?);";
        this.jdbcTemplate.update(sql, itemName, traderId, cost);
    }

    @Override
    public List<HireEntity> selectAllFreeOffers(){
        String sql = "Select * from hire where state = '0';";
        return jdbcTemplate.query(sql, rowMapper);
    }


}
