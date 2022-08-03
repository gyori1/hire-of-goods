package ru.cft.hireofgoods.repository.model;

import java.math.BigDecimal;

public class HireEntity {
    private Long id;

    private String itemName;

    private Long traderId;

    private Long consumerId;

    private Integer state;

    private BigDecimal cost;

    private Long hiringDate;

    private Long returnDate;

    public HireEntity(){}

    public HireEntity(Long hireId, Long traderId, Long consumerId, int state, BigDecimal cost, Long hiringDate, Long returnDate, String itemName) {
        this.id = hireId;
        this.traderId = traderId;
        this.consumerId = consumerId;
        this.state = state;
        this.cost = cost;
        this.hiringDate = hiringDate;
        this.returnDate = returnDate;
        this.itemName = itemName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public long getTraderId() {
        return traderId;
    }

    public void setTraderId(long traderId) {
        this.traderId = traderId;
    }

    public long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(long consumerId) {
        this.consumerId = consumerId;
    }

    public Long getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(Long hiringDate) {
        this.hiringDate = hiringDate;
    }

    public Long getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Long returnDate) {
        this.returnDate = returnDate;
    }

    public int getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
