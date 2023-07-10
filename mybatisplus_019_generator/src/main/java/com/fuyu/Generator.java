package com.fuyu;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;

public class Generator {

    public static void main(String[] args) {
        AutoGenerator autoGenerator = new AutoGenerator();
        DataSourceConfig dataSource=new DataSourceConfig();
        dataSource.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybatisplus_db?serverTimezoneUTC");
        dataSource.setUsername("root");
        dataSource.setPassword("fendou2017");
        autoGenerator.setDataSource(dataSource);
        autoGenerator.execute();
    }
}
