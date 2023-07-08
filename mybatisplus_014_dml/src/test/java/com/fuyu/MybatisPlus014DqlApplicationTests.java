package com.fuyu;

import com.fuyu.dao.UserDao;
import com.fuyu.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MybatisPlus014DqlApplicationTests {

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

    @Test
    void testDelete() {

        List<Long> list = new ArrayList<>();
        list.add(1677100937112014851L);
        list.add(1677788438424203265L);
        list.add(1677795664337670146L);
        list.add(1677799472220463106L);
        userDao.deleteBatchIds(list);

    }

    @Test
    void select(){
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);
        userDao.selectBatchIds(list);
    }


}
