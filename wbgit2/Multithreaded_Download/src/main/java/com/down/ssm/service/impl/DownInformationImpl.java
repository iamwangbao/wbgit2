package com.down.ssm.service.impl;

import com.down.ssm.dao.DownInformationMapper;
import com.down.ssm.domain.DownInformation;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

//@Repository
public class DownInformationImpl extends SqlSessionDaoSupport implements DownInformationMapper {

//删除一行数据
    @Override
    public int deleteByPrimaryKey(Integer down_id) {
        int insertYN;

        if(this.getSqlSession().selectOne("com.down.ssm.dao"
                + ".DownInformationMapper.selectByPrimaryKey",down_id) != null)
        {
            System.out.println("信息存在，进行删除");
        }
        else
        {
            System.out.println("信息不存在，无法删除");
            return 0;
        }


        if(down_id!= null)
        {
            insertYN = this.getSqlSession().delete("com.down.ssm.dao"
                    + ".DownInformationMapper.deleteByPrimaryKey",down_id);
            if(insertYN >= 0)
            {
                System.out.println("删除成功");
                return 1;
            }
            else
            {
                System.out.println("删除失败");
                return 0;
            }

        }
        System.out.println("删除失败");
        return 0;
    }
//插入一行数据
    @Override
    public int insert(DownInformation record) {
        int insertYN;
        if(record != null)
        {
           if(this.getSqlSession().selectOne("com.down.ssm.dao"
                    + ".DownInformationMapper.selectByPrimaryKey",record.getDown_id())!=null)
           {
               System.out.println("该id已经存在，无法插入");
               return 0;
           }

           insertYN = this.getSqlSession().insert("com.down.ssm.dao"
                    + ".DownInformationMapper.insert",record);
           if(insertYN >= 0)
           {
               System.out.println("插入成功");
               return 1;
           }
           else
           {
               System.out.println("插入失败");
               return 0;
           }

        }
        System.out.println("插入失败");
        return 0;
    }
//查询一行数据
    @Override
    public DownInformation selectByPrimaryKey(Integer down_id) {
        return this.getSqlSession().selectOne("com.down.ssm.dao"
                + ".DownInformationMapper.selectByPrimaryKey",down_id);
    }

    //查询表中所有数据
    @Override
    public List<DownInformation> selectAll() {

        return this.getSqlSession().selectList("com.down.ssm.dao"
                + ".DownInformationMapper.selectAll");
    }

    //更新一行数据
    @Override
    public int updateByPrimaryKey(DownInformation record) {
        int insertYN;

        if(this.getSqlSession().selectOne("com.down.ssm.dao"
                + ".DownInformationMapper.selectByPrimaryKey",record.getDown_id()) != null)
        {
            System.out.println("信息存在，进行修改");

                insertYN = this.getSqlSession().update("com.down.ssm.dao"
                        + ".DownInformationMapper.updateByPrimaryKey",record);
                if(insertYN >= 0)
                {
                    System.out.println("修改成功");
                    return 1;
                }
                else
                {
                    System.out.println("修改失败");
                    return 0;
                }


        }
        else
        {
            System.out.println("信息不存在，无法修改");
            return 0;
        }

    }


}
