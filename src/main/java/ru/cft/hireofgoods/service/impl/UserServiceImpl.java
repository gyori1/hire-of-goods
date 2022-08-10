package ru.cft.hireofgoods.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.hireofgoods.repository.UserRepository;
import ru.cft.hireofgoods.repository.model.UserEntity;
import ru.cft.hireofgoods.service.UserService;

import java.math.BigDecimal;
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

    @Override //
    public List<String> getAllUsersEmail(){
        return userRepository.selectAllUsersEmail();
    }

    @Override
    public void createUser(String firstName, String lastName, String middleName, String login, String email) {
        this.userRepository.insertUser(firstName, lastName, middleName, login, email);
    }

    @Override
    public void addMoneyToUser(long id, BigDecimal money) {
        if(!userRepository.userIdExists(id)){
            System.out.println("USER DOES NOT EXISTS");
        }else {
            this.userRepository.addMoneyToUserById(id, money);
        }
    }

    @Override
    public void takeMoneyFromUser(long id, BigDecimal money){
        if(!userRepository.userIdExists(id)){
            System.out.println("USER DOES NOT EXISTS");
        }else {
            this.userRepository.takeMoneyFromUserById(id, money);
        }
    }

}
