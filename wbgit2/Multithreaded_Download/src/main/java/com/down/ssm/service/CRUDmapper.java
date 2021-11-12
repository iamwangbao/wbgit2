package com.down.ssm.service;

import com.down.ssm.domain.DownInformation;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
public interface CRUDmapper {

        //获取全部用户信息
        public void selectAll();

        //插入一组信息
        public void insertone(DownInformation downpojo);

        //删除一组信息
        public void deleteone(Integer downid);

        //查询一组信息
        public void selectone(Integer downid);

        //查询最后一组信息
        public int selectLastone();


        //修改一组信息
        public void updataone(DownInformation downpojo);

}
