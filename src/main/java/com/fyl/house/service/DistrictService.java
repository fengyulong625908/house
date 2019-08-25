package com.fyl.house.service;

import com.fyl.house.entity.District;
import com.fyl.house.utils.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DistrictService {
    /**
     *查询所以区域并分页
     * @return区域实体集合
     */
    PageInfo<District> selectAll(Page page);

    /**
     *
     * @param district
     * @return 新增成功的条数
     */
    int addDistrict(District district);

    /**
     *
     * @param id 主键
     * @return 根据主键查询出的数据
     */
    District selectDistrictOne(Integer id);

    /**
     *
     * @param district 修改的对象
     * @return 修改的条数
     */
    int updateDistrict(District district);

    /**
     *
     * @param ids 执行删除的id数组
     * @return 删除成功的条数
     */
    int deleteDistrict(Integer [] ids);

    /**
     *查询所以区域
     * @return区域实体集合
     */
    List<District> selectAllDistrict();
}
