package com.example.practicaltask.dao;

import java.util.ArrayList;
import java.util.Optional;

import com.example.practicaltask.entity.User;
import com.example.practicaltask.repository.UserRepository;
import com.example.practicaltask.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.practicaltask.util.exception.UserNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Dao service which interects with user repository
 */
@Service
public class UserDao {
    @Autowired
    private UserRepository userRepository;

    /**
     * Displays all the registered users
     */
    public ArrayList<User> getAllUsers(){
        return new ArrayList<User>(userRepository.findAll());
    }

    public User getUserById(long id) throws Exception{
        User user = null;
        if (userRepository.existsById(id)){
            user = userRepository.getById(id);
        } else {
            throw new UserNotFoundException();
        }
        return user;
    }

    /**
     * 
     */
    public int getUserMoneyAmount(long id) throws Exception{
        User user = this.getUserById(id);
        return user.getMoneyAmount();
    }

    /**
     * Saves new user to user repository
     */
    public void createUser(User user){
        userRepository.save(user);
    }

    /**
     * Deletes user from user repository
     */
    public void deleteUser(long id) throws Exception{
        User user = this.getUserById(id);
        userRepository.delete(user);
    }

    public void setUserMoneyAmount(long id, int moneyAmount) throws Exception{
        User user = this.getUserById(id);
        user.setMoneyAmount(moneyAmount);
        userRepository.save(user);
    }
}
