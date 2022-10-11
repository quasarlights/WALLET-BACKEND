package com.example.wallet.services;

import com.example.wallet.interfaces.IUserService;
import com.example.wallet.models.User;
import com.example.wallet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;


    public ArrayList<User> getAllItem(){
        return (ArrayList<User>) userRepository.findAll();
    }

    public User save(User user){
        return userRepository.save(user);
    }




    @Override
    public ArrayList<User> getUser() {
        ArrayList<User> userArrayList= (ArrayList<User>) userRepository.findAll();
        return userArrayList;
    }

    @Override
    public void saveUser(User user) {
userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public User findUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }
}
