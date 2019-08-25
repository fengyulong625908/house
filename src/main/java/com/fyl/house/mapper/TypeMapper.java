package com.fyl.house.mapper;

import com.fyl.house.entity.Type;
import com.fyl.house.entity.TypeExample;
import java.util.List;

public interface TypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Type record);

    int insertSelective(Type record);

    List<Type> selectByExample(TypeExample example);

    Type selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    /**
     *
     * @param ids 删除输出据的id数组
     * @return 受影响的行数
     */
    int deleteMoreType(Integer[] ids);
}