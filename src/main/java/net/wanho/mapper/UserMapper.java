package net.wanho.mapper;

import net.wanho.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    List<User> getAllUser();

    User getUserByid(String username);

    void addUser(User user);

    User getUserByname(String username);

    User getUserBypwd(String pwd);

    void addUserReturnKey(User user);

    void update(@Param("u") User user, @Param("id") Integer id);

    void update2(@Param("name") String username, @Param("pwd") String password, @Param("id") Integer id);

    @Update("UPDATE user1 SET username=#{name}, password=#{pwd} WHERE id=#{id}")
    void update3(@Param("name") String username, @Param("pwd") String password, @Param("id") Integer id);
}
