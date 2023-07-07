package com.fuyu;
import com.fuyu.dao.UserDao;
import com.fuyu.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class Mybatisplus002CrudApplicationTests {

    @Autowired
    private UserDao userDao;

    //新增操作 insert
    @Test
    void testSave(){
        User user = new User();
        user.setName("fuyu程序员");
        user.setPassword("fuyu2017");
        user.setAge("12");
        user.setTel("400618800");
        userDao.insert(user);

    }
    //删除
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
    //查询
    @Test
    void testGetById(){
        User user = userDao.selectById(2l);
        System.out.println(user);
    }


    @Test
    void testGetAll() {
        List<User> users = userDao.selectList(null);

        System.out.println(users);
    }

}
