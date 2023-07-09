package com.fuyu;

import com.fuyu.dao.UserDao;
import com.fuyu.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlus016DqlApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void test() {
        List<User> users = userDao.selectList(null);
        System.out.println(users);
    }

    @Test
    void testSave() {
        User user = new User();
        user.setName("程序员黑马");
        user.setPassword("itheima");
        user.setAge(12);
        user.setTel("4006184000");
        userDao.insert(user);
    }

    //测试逻辑删除
    @Test
    void testDelete() {
        userDao.deleteById(2l);
    }

}
