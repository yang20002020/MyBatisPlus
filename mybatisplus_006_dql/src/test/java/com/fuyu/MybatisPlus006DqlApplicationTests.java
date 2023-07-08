package com.fuyu;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fuyu.dao.UserDao;
import com.fuyu.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.management.Query;
import java.util.List;


@SpringBootTest
class MybatisPlus006DqlApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void test(){
        List<User> users = userDao.selectList(null);
        System.out.println(users);
    }

    //按条件查询
    @Test
    void test1(){
        QueryWrapper qw = new QueryWrapper();
        qw.lt("age",18);//小于18岁
        List userlist = userDao.selectList(qw);
        System.out.println(userlist);

    }
   //方式二：  lambda 格式按条件查询
    @Test
    void test2(){
        QueryWrapper<User> qw = new QueryWrapper<User>();
        qw.lambda().lt(User::getAge,10);//小于10岁
        List userlist = userDao.selectList(qw);
        System.out.println(userlist);
    }
    //方式三：  lambda 格式按条件查询  比较常用的方式
    @Test
    void test3(){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.lt(User::getAge,10);//小于10岁
        List userlist = userDao.selectList(lqw);
        System.out.println(userlist);
    }
    //方式四：  lambda 格式按条件查询  比较常用的方式
    @Test
    void test4(){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.gt(User::getAge,10);//大于10岁
        lqw.lt(User::getAge,40);//小于40岁
        List userlist = userDao.selectList(lqw);
        System.out.println(userlist);
    }
    //方式五：  lambda 格式按条件查询  比较常用的方式
    @Test
    void test5(){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.gt(User::getAge,10).lt(User::getAge,40);//大于10岁小于40岁
        List userlist = userDao.selectList(lqw);
        System.out.println(userlist);
    }
    //方式六：  lambda 格式按条件查询  比较常用的方式
    @Test
    void test6(){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.lt(User::getAge,10).or().gt(User::getAge,40);//小于10岁或者大于40岁
        List userlist = userDao.selectList(lqw);
        System.out.println(userlist);
    }


}
