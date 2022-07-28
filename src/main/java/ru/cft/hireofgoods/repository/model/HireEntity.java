package ru.cft.hireofgoods.repository.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/*
   JavaBean object that represents the Hire
   Hire includes its id, lessorsId and renterId.

*/



public class HireEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hire_id")
    private long hireId;

    @Column(name = "lessor_id", nullable = false)
    private long lessorId;

    @Column(name = "rentor_id", nullable = false)
    private long renterId;

    //TODO product id realization

    @Column(name = "coast", nullable = false)
    private BigDecimal coast;


    @Column(name = "hire_date", nullable = false)
    private BigDecimal hiringDate;

    @Column(name = "return_date", nullable = false)
    private BigDecimal returnDate;


    public HireEntity(){}


    public HireEntity(long hireId, long lessorId, long rentorId, BigDecimal coast, BigDecimal hiringDate, BigDecimal returnDate) {
        this.hireId = hireId;
        this.lessorId = lessorId;
        this.renterId = rentorId;
        this.coast = coast;
        this.hiringDate = hiringDate;
        this.returnDate = returnDate;
    }


    public long getHireId() {
        return hireId;
    }

    public void setHireId(long hireId) {
        this.hireId = hireId;
    }


    public long getLessorId() {
        return lessorId;
    }

    public void setLessorId(long lessorId) {
        this.lessorId = lessorId;
    }


    public long getRenterId() {
        return renterId;
    }

    public void setRenterId(long renterId) {
        this.renterId = renterId;
    }


    public BigDecimal getCoast() {
        return coast;
    }

    public void setCoast(BigDecimal coast) {
        this.coast = coast;
    }


    public BigDecimal getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(BigDecimal hiringDate) {
        this.hiringDate = hiringDate;
    }


    public BigDecimal getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(BigDecimal returnDate) {
        this.returnDate = returnDate;
    }

}
