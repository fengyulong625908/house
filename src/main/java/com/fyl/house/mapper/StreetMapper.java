package com.fyl.house.mapper;

import com.fyl.house.entity.Street;
import com.fyl.house.entity.StreetExample;
import java.util.List;

public interface StreetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Street record);

    int insertSelective(Street record);

    List<Street> selectByExample(StreetExample example);

    Street selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);

    /**
     *
     * @param DistrictId 区域id
     * @return 受影响的行数
     */
    int deleteStreetByDistrictId(Integer DistrictId);

    /**
     *
     * @param DistrictIds 区域id的数组
     * @return 受影响的行数
     */
    int deleteMoreStreetByDistrictId(Integer[] DistrictIds);
}