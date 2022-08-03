package ru.cft.hireofgoods.service;

import ru.cft.hireofgoods.repository.model.HireEntity;

import java.math.BigDecimal;
import java.util.List;

public interface HireService {
    public List<HireEntity> getAllHire();
    public void createItem(String itemName, Long traderId, BigDecimal cost);
    public List<HireEntity> getAllFreeOffers();
}
