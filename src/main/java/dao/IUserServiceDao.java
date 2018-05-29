package dao;

import model.User;

import java.util.List;

/**
 * Created by Steven Sliver on 2018/5/29.
 */
public interface IUserServiceDao {
    void addUser(User user);

    List<User> getUserByPhone(String phone);
}
