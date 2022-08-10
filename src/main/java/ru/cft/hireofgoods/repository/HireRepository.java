package ru.cft.hireofgoods.repository;

import ru.cft.hireofgoods.repository.model.HireEntity;
import ru.cft.hireofgoods.repository.model.UserEntity;

import java.math.BigDecimal;
import java.util.List;

public interface HireRepository {
    public List<HireEntity> selectAll();

    public boolean itemExists(long itemId);

    boolean itemStateIsFree(long itemId);

    public HireEntity getHireById(long itemId);

    public List<HireEntity> selectAllFreeOffers();
    public void insertItem (String name, Long traderId, BigDecimal cost);

    public void hireItem(long itemId, long consumerId);
    public boolean consumerIdEqualsTraderIdByItemId(long consumerId, long itemId);
    public void updateReturnItem(long itemId);
    public List<HireEntity> selectAllUsersOffers(long consumerId);
}
