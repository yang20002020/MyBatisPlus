package com.fuyu;
import com.fuyu.dao.UserDao;
import com.fuyu.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class MybatisPlus013DqlApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void test(){
        List<User> users = userDao.selectList(null);
        System.out.println(users);
    }

    @Test
    void testSave(){
        User user = new User();
        user.setName("程序员黑马");
        user.setPassword("itheima");
        user.setAge(12);
        user.setTel("4006184000");
        userDao.insert(user);
    }

    @Test
    void testDelete(){
        userDao.deleteById(1677100937112014850L);
    }

    //更新
    @Test
    void testUpdate(){
        User user = new User();
        user.setId(1l);
        user.setName("fuyu程序员");
        userDao.updateById(user);
    }


}
