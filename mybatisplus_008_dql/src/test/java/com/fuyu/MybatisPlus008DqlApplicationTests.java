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
import java.util.Map;


@SpringBootTest
class MybatisPlus008DqlApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void test(){
        List<User> users = userDao.selectList(null);
        System.out.println(users);
    }


    //查询投影
    @Test
    void test10(){
        //查询投影
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        List userlist = userDao.selectList(lqw);
        System.out.println(userlist);
    }
    //查询投影
    @Test
    void test11(){
        //查询投影
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.select(User::getId,User::getName); //只显示id和name
        List<User> userlist = userDao.selectList(lqw);
        System.out.println(userlist);
    }
    //查询投影
    @Test
    void test12(){
        //查询投影
        QueryWrapper<User> lqw = new QueryWrapper<User>();
        lqw.select("id","name","age"); //只显示id、name和age
        List<User> userlist = userDao.selectList(lqw);
        System.out.println(userlist);
    }

    //查询投影
    @Test
    void test13(){
        //查询投影
        QueryWrapper<User> lqw = new QueryWrapper<User>();
        lqw.select("count(*)"); //统计 个数
        List<Map<String, Object>> maps = userDao.selectMaps(lqw);
        System.out.println(maps); //[{count(*)=5}]
    }

    //查询投影
    @Test
    void test14(){
        //查询投影
        QueryWrapper<User> lqw = new QueryWrapper<User>();
        lqw.select("count(*) as count"); //统计 个数
        List<Map<String, Object>> maps = userDao.selectMaps(lqw);
        System.out.println(maps); //[{count=5}]
    }

    //查询投影
    @Test
    void test15(){
        //查询投影
        QueryWrapper<User> lqw = new QueryWrapper<User>();
        lqw.select("count(*) as count,tel"); //统计 个数
        lqw.groupBy("tel");//以电话号码分类
        List<Map<String, Object>> maps = userDao.selectMaps(lqw);
        //[{count=1, tel=1866666666}, {count=1, tel=18777777}, {count=1, tel=1988888888}, {count=1, tel=1920000000}, {count=1, tel=400618800}]
        System.out.println(maps);
    }



}
