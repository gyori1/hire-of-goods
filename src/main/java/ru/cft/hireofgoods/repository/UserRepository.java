package ru.cft.hireofgoods.repository;

import ru.cft.hireofgoods.repository.model.UserEntity;

import java.util.List;

public interface UserRepository {
    public List<UserEntity> selectAll();
    public List<String> selectAllUsersEmail();
    public void insertUser(String firstName,
                           String lastName,
                           String middleName,
                           String email,
                           String login);
}
