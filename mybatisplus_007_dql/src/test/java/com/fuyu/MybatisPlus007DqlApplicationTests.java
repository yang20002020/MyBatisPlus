package com.fuyu;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fuyu.dao.UserDao;
import com.fuyu.domain.User;
import com.fuyu.query.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;


@SpringBootTest
class MybatisPlus007DqlApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void test(){
        List<User> users = userDao.selectList(null);
        System.out.println(users);
    }

    @Test
    void test7(){
        //模拟页面传递过来的查询数据
        UserQuery uq = new UserQuery();
        uq.setAge(10);
        uq.setAge2(30);

        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.gt(User::getAge,uq.getAge());//大于10岁
        lqw.lt(User::getAge,uq.getAge2());//小于30岁
        List userlist = userDao.selectList(lqw);
        System.out.println(userlist);

    }

    @Test
    void test8(){
        //模拟页面传递过来的查询数据
        UserQuery uq = new UserQuery();
       // uq.setAge(10);
        uq.setAge2(30);

        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        if(null!=uq.getAge()){
            lqw.gt(User::getAge,uq.getAge());//大于10岁
        }
        lqw.lt(User::getAge,uq.getAge2());//小于30岁
        List userlist = userDao.selectList(lqw);
        System.out.println(userlist);

    }
    //test8 可以进一步优化为test9
    @Test
    void test9(){
        //模拟页面传递过来的查询数据
        UserQuery uq = new UserQuery();
        // uq.setAge(10);
        uq.setAge2(30);

        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        //先判断第一个参数是否为true，如果为true连接当前条件
        lqw.gt(null!= uq.getAge(),User::getAge,uq.getAge());//如果age 存在，设置大于10岁
        lqw.lt(null!=uq.getAge2(),User::getAge,uq.getAge2());//如果age2 存在，则设置小于30岁
        List userlist = userDao.selectList(lqw);
        System.out.println(userlist);

    }



}
