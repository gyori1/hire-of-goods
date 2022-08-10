package ru.cft.hireofgoods.repository;

import ru.cft.hireofgoods.repository.model.UserEntity;

import java.math.BigDecimal;
import java.util.List;

public interface UserRepository {
    public List<UserEntity> selectAll();
    public List<String> selectAllUsersEmail();
    public void insertUser(String firstName,
                           String lastName,
                           String middleName,
                           String email,
                           String login);

    UserEntity getUserById(long id);

    public void addMoneyToUserById(long id, BigDecimal money);
    public void takeMoneyFromUserById(long id, BigDecimal money);
    public boolean userIdExists(long userId);
}
