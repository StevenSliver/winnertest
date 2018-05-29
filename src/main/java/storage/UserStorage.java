package storage;

import model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Steven Sliver on 2018/5/29.
 */
public interface UserStorage {
    /**
     * 插入用户
     * @param userName
     * @param phone
     */
    void addUser(@Param("name") String userName, @Param("phone") String phone);

    /**
     * 查询用户列表
     * @param phone
     * @return
     */
    List<User> queryUserByPhone(@Param("phone") String phone);

}
