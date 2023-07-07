package com.fuyu;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fuyu.dao.UserDao;
import com.fuyu.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class Mybatisplus004selectpageApplicationTests {

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
    @Test
    void testGetByPage(){
        //第一个参数代表第几页，第二个参数代表该页有几条
        IPage page = new Page(1,2);
        userDao.selectPage(page,null);
        System.out.println("当前页码数:"+page.getCurrent());
        System.out.println("每页显示数："+page.getSize());
        System.out.println("一共多少页："+page.getPages());
        System.out.println("一共多少条数据:"+page.getTotal());
        System.out.println("数据:"+page.getRecords());

    }

}
