package com.example.shoppingmall.dao.Impl;

import com.example.shoppingmall.dao.UserDAO;
import com.example.shoppingmall.data.entity.User;
import com.example.shoppingmall.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDAOImpl implements UserDAO {

    private UserRepository userRepository;

    @Autowired
    public UserDAOImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
