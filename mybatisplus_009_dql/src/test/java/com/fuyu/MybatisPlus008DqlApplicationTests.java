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


    @Test
    void test15(){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        //等同于=
        lqw.eq(User::getName,"jerry").eq(User::getPassword,"jerry123");
        User loginUser = userDao.selectOne(lqw);
        System.out.println(loginUser);//User(id=2, name=jerry, password=jerry123, age=4, tel=18777777)
    }

    //范围查询
    @Test
    void test16(){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        //范围查询 lt le gt eq between
        lqw.between(User::getAge,10,30);//年龄大于10 小于30
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);
    }
    //模糊匹配
    @Test
    void test17(){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        //模糊匹配 like
        lqw.like(User::getName,"J"); //查找名称含有J的数据
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);
        //[User(id=2, name=jerry, password=jerry123, age=4, tel=18777777), User(id=3, name=jock, password=123456, age=41, tel=1988888888)]
    }

    //模糊匹配
    @Test
    void test18(){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        //模糊匹配 likeLeft  左边% %J
        lqw.likeLeft(User::getName,"J"); //查找名称含有J的数据
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);//打印 空

    }

    //模糊匹配
    @Test
    void test19(){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        //模糊匹配 likeRight  右边% J%
        lqw.likeRight(User::getName,"J"); //查找名称含有J的数据
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);
        //[User(id=2, name=jerry, password=jerry123, age=4, tel=18777777), User(id=3, name=jock, password=123456, age=41, tel=1988888888)]

    }




}
