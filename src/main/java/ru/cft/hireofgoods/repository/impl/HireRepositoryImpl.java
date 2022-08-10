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

    @Autowired//
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
        this.jdbcTemplate.update(sql, preparedStatement -> {
            preparedStatement.setString(1,itemName);
            preparedStatement.setLong(1, traderId);
            preparedStatement.setBigDecimal(1,cost);
        });
    }

    @Override
    public boolean itemExists(long itemId){
        String sql = "select * from hire where id = ?;";
        return this.jdbcTemplate.query(sql,preparedStatement ->
                preparedStatement.setLong(1, itemId), rowMapper).size() > 0;
    }

    @Override
    public boolean itemStateIsFree(long itemId){//
        String sql = "select * from hire where state = 1 and item_id = ?;";
        return this.jdbcTemplate.query(sql, preparedStatement ->
                preparedStatement.setLong(1, itemId), rowMapper).size() > 0;
    }

    @Override
    public HireEntity getHireById(long itemId){
        String sql = "select * from hire where id = ?";
        return this.jdbcTemplate.query(sql, preparedStatement ->
                preparedStatement.setLong(1, itemId), rowMapper).get(0);
    }


    @Override
    public List<HireEntity> selectAllFreeOffers(){
        String sql = "Select * from hire where state = '0';";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void hireItem(long itemId, long consumerId){
        String sql = "update hire set consumer_Id = ?, state = 2 where id = ?";
        this.jdbcTemplate.update(sql, consumerId, itemId);
    }

    @Override //??
    public boolean consumerIdEqualsTraderIdByItemId(long itemId, long consumerId){
        String sql = "select * from hire where id = ? and trader_id = ?;";
        return this.jdbcTemplate.query(sql,preparedStatement ->{
                    preparedStatement.setLong(1, itemId);
                    preparedStatement.setLong(2, consumerId);
                    }, rowMapper).size() > 0;
    }

    @Override
    public void updateReturnItem(long itemId) {
        String sql = "update hire set state = 1, consumer_id = null, hire_date = null, return_date = null where id = ?;";
        this.jdbcTemplate.update(sql, itemId);
    }

    @Override
    public List<HireEntity> selectAllUsersOffers(long consumerId) {
        String sql = "select * from hire where consumer_id = ?;";
        return this.jdbcTemplate.query(sql, preparedStatement -> preparedStatement.setLong(1, consumerId), rowMapper);
    }
}
