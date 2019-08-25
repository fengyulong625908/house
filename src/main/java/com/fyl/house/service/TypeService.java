package com.fyl.house.service;

import com.fyl.house.entity.Type;
import com.fyl.house.utils.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TypeService {

    /**
     *查询所以房型并分
     * @return 区域实体集合
     */
    PageInfo<Type> selectAll(Page page);

    /**
     *
     * @param type
     * @return 新增成功的条数
     */
    int addType(Type type);

    /**
     *
     * @param id 主键
     * @return 根据主键查询出的数据
     */
    Type selectTypeOne(Integer id);

    /**
     *
     * @param type 修改的对象
     * @return 修改的条数
     */
    int updateType(Type type);

    /**
     *
     * @param ids 执行删除的id数组
     * @return 删除成功的条数
     */
    int deleteTypes(Integer [] ids);


    /**
     *查询所以房型并分
     * @return 区域实体集合
     */
    List<Type> selectTypeALL();

}
