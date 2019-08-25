package com.fyl.house.mapper;

import com.fyl.house.entity.House;
import com.fyl.house.entity.HouseExample;
import com.fyl.house.utils.HouseCondition;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    //查询用户发布的出租房
    List<House> getHouseByUser(Integer userid);

    House getHouseByID(String id);

    /**
     * 查询房子是否已审核
     * @param houseCondition
     * @return
     */
    List<House>getHouseByIsPass(HouseCondition houseCondition);

    /**
     *
     * @param houseCondition 搜索条件
     * @return
     */
    List<House>getHouseAllByIsPass(HouseCondition houseCondition);
}