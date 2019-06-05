package net.wanho.test;


import net.wanho.mapper.UserMapper;
import net.wanho.pojo.User;
import net.wanho.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import org.junit.Before;
import org.junit.Test;


import java.util.List;

public class Test01 {
    private SqlSession sqlSession;
    private UserMapper userMapper;
    @Before
    public void before(){
        sqlSession = MybatisUtil.getSession();
         userMapper = sqlSession.getMapper(UserMapper.class);
    }
//    @Test
//    public void testAddUser(){
//        User user = new User("ddd", "ddd");
////        sqlSession.update("net.wanho.mapper.UserMapper.addUser",user);
////        sqlSession.commit();
////        sqlSession.close();
//        SqlSession session = MybatisUtil.getSession();
//        sqlSession.update("net.wanho.mapper.UserMapper.addUser",user);
//        sqlSession.commit();
//        MybatisUtil.closeSession();
//    }
    @Test
    public void getAllUser(){
        List<User> users = sqlSession.selectList("net.wanho.mapper.UserMapper.getAllUser");
        System.out.println(users);
        sqlSession.commit();
        MybatisUtil.closeSession();
    }

    @Test
    public void getUserByid(){
//        User user1 = sqlSession.selectOne("net.wanho.mapper.UserMapper.getUserByid", "aaa");
//        System.out.println(user1);
//        sqlSession.commit();
//        MybatisUtil.closeSession();
        User u = userMapper.getUserByid("11");
        System.out.println(u);
        sqlSession.commit();
    }
    @Test
    public void getUserByname(){
        User u = userMapper.getUserByname("aaa");
        System.out.println(u);
        sqlSession.commit();
    }
    @Test
    public void getUserBypwd(){
        User u = userMapper.getUserBypwd("aaa");
        System.out.println(u);
        sqlSession.commit();
    }
    @Test
    public void addUserReturnKey(){
        User user = new User("dd","dd",null);
        userMapper.addUserReturnKey(user);
        System.out.println(user.getId());
        sqlSession.commit();
        MybatisUtil.closeSession();
    }

    @Test
    public void update(){
        User user = new User("dd","dd",null);
        userMapper.update(user,10);

        sqlSession.commit();
        MybatisUtil.closeSession();
    }

    @Test
    public void update2(){

        userMapper.update2("ww","ww",10);

        sqlSession.commit();
        MybatisUtil.closeSession();
    }
    @Test
    public void update3(){

        userMapper.update3("ff","ww",10);

        sqlSession.commit();
        MybatisUtil.closeSession();
    }
}
