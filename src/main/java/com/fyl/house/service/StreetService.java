package com.fyl.house.service;

import com.fyl.house.entity.Street;
import com.fyl.house.utils.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface StreetService {
    /**
     *查询所以区域并分
     * @return区域实体集合
     */
    PageInfo<Street> selectAll(Page page,Integer did);

    /**
     *
     * @param street
     * @return 新增成功的条数
     */
    int addStreet(Street street);

    /**
     *
     * @param street 修改的对象
     * @return 修改的条数
     */
    int updateStreet(Street street);

    /**
     *
     * @param id 执行删除的id数组
     * @return 删除成功的条数
     */
    int deleteStreet(Integer id);



    /**
     *
     * @param id  查询的条件
     * @return 查询的对象集合
     */
    List<Street> selectStreetByDid(Integer id);


}
