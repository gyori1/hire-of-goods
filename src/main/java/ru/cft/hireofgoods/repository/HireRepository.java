package ru.cft.hireofgoods.repository;

import ru.cft.hireofgoods.repository.model.HireEntity;
import ru.cft.hireofgoods.repository.model.UserEntity;

import java.math.BigDecimal;
import java.util.List;

public interface HireRepository {
    public List<HireEntity> selectAll();
    public List<HireEntity> selectAllFreeOffers();
    public void insertItem (String name, Long traderId, BigDecimal cost);
}
