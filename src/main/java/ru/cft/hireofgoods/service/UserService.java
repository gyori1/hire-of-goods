package ru.cft.hireofgoods.service;

import ru.cft.hireofgoods.repository.model.UserEntity;

import java.util.List;

public interface UserService {
    public List<UserEntity> getAllUser();
    public List<String> getAllUsersEmail();
}
