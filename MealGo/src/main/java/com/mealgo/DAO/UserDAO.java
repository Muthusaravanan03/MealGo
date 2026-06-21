package com.mealgo.DAO;

import java.util.List;
import com.mealgo.Model.User;

public interface UserDAO {

    public int addUser(User user);

    public User getUser(int userId);

    public void updateUser(User user);

    public void deleteUser(int userId);

    List<User> getAllUsers();

    public User login(String input, String password);
}