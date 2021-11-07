package com.down.ssm.dao;

import com.down.ssm.domain.DownInformation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


@RunWith(JUnit4.class)

public class UserDaoTest {
    

    @Autowired
    DownInformationMapper downInformation;

//获取全部用户信息
    @Test
    public void selectAllTest() {

        ApplicationContext act =
                new ClassPathXmlApplicationContext("Beans.xml");

        DownInformationMapper downDao =
                (DownInformationMapper) act.getBean("downInformationDao");

        List<DownInformation> down = downDao.selectAll();

        if (down != null) {
            for (DownInformation tuser : down) {

                System.out.println(tuser);
            }

        }


    }

    @Test
    //插入一组信息
    public void insertTest()
    {
        ApplicationContext act =
                new ClassPathXmlApplicationContext("Beans.xml");

        DownInformationMapper downDao =
                (DownInformationMapper) act.getBean("downInformationDao");

        DownInformation downpojo = new DownInformation();
        Date date = new Date();

        downpojo.setDown_id(5);
        downpojo.setDown_url("https://127.0.0.1");
        downpojo.setDown_filename("呜呜呜.exe");
        downpojo.setDown_savapath("D://1");
        downpojo.setDown_strattime(date);
        downpojo.setDown_endtime(date);
        downpojo.setDown_size("12221");
        downpojo.setDown_YNsuccess(1);

         downDao.insert(downpojo);
    }

    //删除一组信息
    @Test
    public void deleteByPrimaryKeyTest()
    {
        ApplicationContext act =
                new ClassPathXmlApplicationContext("Beans.xml");

        DownInformationMapper downDao =
                (DownInformationMapper) act.getBean("downInformationDao");

        downDao.deleteByPrimaryKey(5);
    }


    //查询一组信息
    @Test
    public void selectoneTest()
    {
        ApplicationContext act =
                new ClassPathXmlApplicationContext("Beans.xml");

        DownInformationMapper downDao =
                (DownInformationMapper) act.getBean("downInformationDao");

       DownInformation down = downDao.selectByPrimaryKey(1);
       System.out.println(down);

    }

    //修改一组信息
    @Test
    public void updataoneTest()
    {
        ApplicationContext act =
                new ClassPathXmlApplicationContext("Beans.xml");

        DownInformationMapper downDao =
                (DownInformationMapper) act.getBean("downInformationDao");

        DownInformation downpojo = new DownInformation();
        Date date = new Date();

        downpojo.setDown_id(5);
        downpojo.setDown_url("https://127.0.0.1:8080");
        downpojo.setDown_filename("呜呜呜1.exe");
        downpojo.setDown_savapath("D://2");
        downpojo.setDown_strattime(date);
        downpojo.setDown_endtime(date);
        downpojo.setDown_size("55555555");
        downpojo.setDown_YNsuccess(0);

        downDao.updateByPrimaryKey(downpojo);
    }


    @Test
    //获取全部用户信息
    public void queryAll() {


        try {
            String source = "mybatis-config22.xml";
            InputStream is = Resources.getResourceAsStream(source);
            //2 创建一个工厂，完成对配置文件的读取
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            //3 创建sqlSession，开启工厂
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //  SqlSession sqlSession = MybatisUtil.createSqlSession();
            //第一种方法  通过全限定名获取信息
            //  List<User> n=sqlSession.selectList("cn.cn.jdbc.dao.TuserTest.queryAll");
            //第二种方法  通过接口返回信息引入映射文件中
            List<DownInformation> n = sqlSession.getMapper(DownInformationMapper.class).selectAll();


            if (n != null) {
                for (DownInformation tuser : n) {

                    System.out.println(tuser);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
