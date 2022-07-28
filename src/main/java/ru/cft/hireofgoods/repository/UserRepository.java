package ru.cft.hireofgoods.repository;

import ru.cft.hireofgoods.repository.model.UserEntity;

import java.util.List;

public interface UserRepository {
    public List<UserEntity> selectAll();
    public List<String> selectAllUsersEmail();
}
