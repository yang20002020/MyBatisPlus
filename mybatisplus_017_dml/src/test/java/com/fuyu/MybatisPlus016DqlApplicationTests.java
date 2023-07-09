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


    //测试乐观锁 方法一
    @Test
    void testUpdate(){
        User user = new User();
        user.setId(3l);
        user.setName("jock666");
        user.setVersion(1);
        userDao.updateById(user);

    }
    //测试乐观锁  方法二
    @Test
    void testUpdate1(){
        
        //1. 先通过要修改的数据id将当前数据查询出来 确保获得的数据有version值
        User user = userDao.selectById(3l);
        //2. 将要修改的属性逐一设置进去
        user.setName("jock66688");
        userDao.updateById(user);

    }

    //模拟秒杀抢单
    @Test
    void testUpdate2(){

        //用户1 version=3
        User user1 = userDao.selectById(3l);
        //用户2 version=3
        User user2 = userDao.selectById(3l);

        user1.setName("jock8881");
        userDao.updateById(user1); //version=》》4

        user1.setName("jock8882");
        userDao.updateById(user2); // where version=3 已经不成立

    }


  

}
