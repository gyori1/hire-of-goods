package ru.cft.hireofgoods.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.hireofgoods.repository.HireRepository;
import ru.cft.hireofgoods.repository.model.HireEntity;
import ru.cft.hireofgoods.service.HireService;

import java.math.BigDecimal;
import java.util.List;

@Service
public class HireServiceImpl implements HireService {
    public final HireRepository hireRepository;

    @Autowired
    public HireServiceImpl(HireRepository hireRepository) {
        this.hireRepository = hireRepository;
    }

    @Override
    public List<HireEntity> getAllHire() {
        return this.hireRepository.selectAll();
    }

    @Override
    public void createItem(String itemName, Long traderId, BigDecimal cost) {
        this.hireRepository.insertItem(itemName, traderId, cost);
    }

    @Override
    public List<HireEntity> getAllFreeOffers(){
        return this.hireRepository.selectAllFreeOffers();
    }

}
