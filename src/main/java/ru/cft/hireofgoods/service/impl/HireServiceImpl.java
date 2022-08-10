package ru.cft.hireofgoods.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.hireofgoods.repository.HireRepository;
import ru.cft.hireofgoods.repository.UserRepository;
import ru.cft.hireofgoods.repository.model.HireEntity;
import ru.cft.hireofgoods.service.HireService;

import java.math.BigDecimal;
import java.util.List;

@Service
public class HireServiceImpl implements HireService {
    public final HireRepository hireRepository;
    public final UserRepository userRepository;

    @Autowired
    public HireServiceImpl(HireRepository hireRepository, UserRepository userRepository) {
        this.hireRepository = hireRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<HireEntity> getAllHire() {
        return this.hireRepository.selectAll();
    }

    @Override
    public void createItem(String itemName, Long traderId, BigDecimal cost) {
        if(!userRepository.userIdExists(traderId)){
            System.out.println("USER DOES NOT EXISTS");
        } else if (cost.floatValue() <= 0) {
            System.out.println("PRODUCT PRICE CAN NOT BE LESS THAN 0 OR BE EQUAL TO ZERO");
        }
        this.hireRepository.insertItem(itemName, traderId, cost);
    }

    @Override
    public List<HireEntity> getAllFreeOffers(){
        return this.hireRepository.selectAllFreeOffers();
    }

    @Override
    public void hireItem(long itemId, long consumerId) {
        if(!userRepository.userIdExists(consumerId)){
            System.out.println("USER DOES NOT EXISTS");
        } else if (!(hireRepository.itemStateIsFree(itemId) && hireRepository.itemExists(itemId))){
            System.out.println("PRODUCT IS HIRED TO SBD OR ITEM DOESN'T EXISTS");
        } else if (hireRepository.consumerIdEqualsTraderIdByItemId(itemId, consumerId)) {
            System.out.println("CONSUMER_ID EQUALS TRADER_ID");
        } else {
            this.hireRepository.hireItem(itemId, consumerId);
        }//TODO
    }

    @Override
    public void returnItem(long itemId) {
        if(!userRepository.userIdExists(itemId)) {
            System.out.println("PRODUCT DOES NOT EXISTS");
        }
        else {
            HireEntity hireEntity = hireRepository.getHireById(itemId);
            long traderId = hireEntity.getTraderId();
            long consumerId = hireEntity.getConsumerId();
            BigDecimal money = hireEntity.getCost(); //
            userRepository.takeMoneyFromUserById(consumerId, money);
            userRepository.addMoneyToUserById(traderId, money);
            this.hireRepository.updateReturnItem(itemId);
        }
    }

    @Override
    public List<HireEntity> returnAllUsersHires(long consumerId) {
        if(!userRepository.userIdExists(consumerId)){
            System.out.println("USER DOES NOT EXISTS");
            return null; //TODO
        } else {
            return hireRepository.selectAllUsersOffers(consumerId);
        }
    }

}
