package ru.cft.hireofgoods.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.hireofgoods.repository.UserRepository;
import ru.cft.hireofgoods.repository.model.UserEntity;
import ru.cft.hireofgoods.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.selectAll();
    }

    @Override
    public List<String> getAllUsersEmail(){
        return userRepository.selectAllUsersEmail();
    }
}
