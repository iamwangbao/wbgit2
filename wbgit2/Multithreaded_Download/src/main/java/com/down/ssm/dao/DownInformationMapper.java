package com.down.ssm.dao;

import com.down.ssm.domain.DownInformation;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public interface DownInformationMapper {
    int deleteByPrimaryKey(Integer down_id);

    int insert(DownInformation record);

    DownInformation selectByPrimaryKey(Integer down_id);

    List<DownInformation> selectAll();

    int updateByPrimaryKey(DownInformation record);



}