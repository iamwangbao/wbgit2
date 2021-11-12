package com.down.ssm.service.impl;

import com.down.ssm.dao.DownInformationMapper;
import com.down.ssm.domain.DownInformation;
import com.down.ssm.service.CRUDmapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@Scope("prototype")
public class CRUDmapperImpl implements CRUDmapper {
    @Override
    public void selectAll() {

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

    @Override
    public void insertone(DownInformation downpojo) {

        ApplicationContext act =
                new ClassPathXmlApplicationContext("Beans.xml");

        DownInformationMapper downDao =
                (DownInformationMapper) act.getBean("downInformationDao");

        downDao.insert(downpojo);

    }

    @Override
    public void deleteone(Integer downid) {

        ApplicationContext act =
                new ClassPathXmlApplicationContext("Beans.xml");

        DownInformationMapper downDao =
                (DownInformationMapper) act.getBean("downInformationDao");

        downDao.deleteByPrimaryKey(downid);

    }

    @Override
    public void selectone(Integer downid) {

        ApplicationContext act =
                new ClassPathXmlApplicationContext("Beans.xml");

        DownInformationMapper downDao =
                (DownInformationMapper) act.getBean("downInformationDao");

        DownInformation down = downDao.selectByPrimaryKey(downid);
        System.out.println(down);

    }

    @Override
    public int selectLastone() {

        ApplicationContext act =
                new ClassPathXmlApplicationContext("Beans.xml");

        DownInformationMapper downDao =
                (DownInformationMapper) act.getBean("downInformationDao");

        DownInformation down = downDao.selectLastOne();
//        System.out.println(down);
        return down.getDown_id();
    }

    @Override
    public void updataone(DownInformation downpojo) {

        ApplicationContext act =
                new ClassPathXmlApplicationContext("Beans.xml");

        DownInformationMapper downDao =
                (DownInformationMapper) act.getBean("downInformationDao");

        downDao.updateByPrimaryKey(downpojo);

    }
}
