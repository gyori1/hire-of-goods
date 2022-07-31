package ru.cft.hireofgoods.repository.model;

import java.math.BigDecimal;

public class HireEntity {
    private Long hireId;

    private Long traderId;

    private Long consumerId;

    private Long itemId;

    private Integer state;

    private BigDecimal cost;

    private Long hiringDate;

    private Long returnDate;

    public HireEntity(){}

    public HireEntity(Long hireId, Long traderId, Long consumerId, int state, BigDecimal cost, Long hiringDate, Long returnDate, Long itemId) {
        this.hireId = hireId;
        this.traderId = traderId;
        this.consumerId = consumerId;
        this.state = state;
        this.cost = cost;
        this.hiringDate = hiringDate;
        this.returnDate = returnDate;
        this.itemId = itemId;
    }

    public long getHireId() {
        return hireId;
    }

    public void setHireId(long hireId) {
        this.hireId = hireId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
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

    public BigDecimal getCoast() {
        return cost;
    }

    public void setCoast(BigDecimal coast) {
        this.cost = coast;
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
