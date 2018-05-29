package service;

import dao.IUserServiceDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import storage.UserStorage;

import java.util.List;

/**
 * Created by Steven Sliver on 2018/5/29.
 */
@Service
public class UserService implements IUserServiceDao {

    @Autowired
    private UserStorage userStorage;

    public void addUser(User user) {
        userStorage.addUser(user.getName(), user.getPhone());
    }

    public List<User> getUserByPhone(String phone) {
        return userStorage.queryUserByPhone(phone);
    }
}
