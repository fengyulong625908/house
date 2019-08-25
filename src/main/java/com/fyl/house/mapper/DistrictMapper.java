package com.fyl.house.mapper;

import com.fyl.house.entity.District;
import com.fyl.house.entity.DistrictExample;
import java.util.List;

public interface DistrictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(District record);

    int insertSelective(District record);

    List<District> selectByExample(DistrictExample example);

    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);

    /**
     *
     * @param ids 删除输出据的id数组
     * @return 受影响的行数
     */
    int deleteMoreDistrict(Integer[] ids);
}