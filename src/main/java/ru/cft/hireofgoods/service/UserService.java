package ru.cft.hireofgoods.service;

import ru.cft.hireofgoods.repository.model.UserEntity;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {
    public List<UserEntity> getAllUser();

    public List<String> getAllUsersEmail();

    public void createUser(String firstName, String lastName, String middleName, String login, String email);

    public void addMoneyToUser(long id, BigDecimal money);

    public void takeMoneyFromUser(long id, BigDecimal money);
}
