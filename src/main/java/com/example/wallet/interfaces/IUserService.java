package com.example.wallet.interfaces;

import com.example.wallet.models.User;
import java.util.ArrayList;

public interface IUserService {

    public ArrayList<User> getUser();
    public void saveUser(User user);
    public void deleteUser(Long id);
    public User findUser(Long id);

}
