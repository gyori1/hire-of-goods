package ru.cft.hireofgoods.service;

import ru.cft.hireofgoods.repository.model.HireEntity;

import java.math.BigDecimal;
import java.util.List;

public interface HireService {
    public List<HireEntity> getAllHire();
    public void createItem(String itemName, Long traderId, BigDecimal cost);
    public List<HireEntity> getAllFreeOffers();
    public void hireItem(long itemId, long consumerId);
    public void returnItem(long itemId);
    public List<HireEntity> returnAllUsersHires(long consumerId);
}
