package com.fyl.house.service;

import com.fyl.house.entity.House;
import com.fyl.house.utils.HouseCondition;
import com.fyl.house.utils.Page;
import com.github.pagehelper.PageInfo;

public interface HouseService {
    /**
     *  发布新的租房信息
     * @param house 新增的信息
     * @return
     */
    int addHouse(House house);

    /**
     * 展示用户发布的房子信息
     * @param userId
     * @param page
     * @return
     */
    PageInfo<House> getHouseByUser(Integer userId, Page page);

    /**
     * 查询用户发布单条房间信息
     * @param id
     * @return
     */
    House getHouseByID(String id);

    /**
     * 修改出租房信息
     * @param house
     * @return
     */
    int updateHouse(House house);

    /**
     * 逻辑删除
     * @param id 删除的id
     * @param isDel 改为1为逻辑删除
     * @return
     */
    int upDataHouseIsDel(String id, Integer isDel);

    /**
     * 查询未审核的房子
     * @param houseCondition 分页的条件
     * @param isPass 0表示未审核，1表示已审核
     * @return
     */
    PageInfo<House> getHouseByNoPass(HouseCondition houseCondition,Integer isPass);

    /**
     * 房间审核
     * @param id 房间的id
     * @param isPass 1为已审核 ，0为未审核
     * @return
     */
    int PassHouse(String id,Integer isPass);

    /**
     * 带条件搜索房子
     * @param houseCondition 搜索的条件
     * @return
     */
    PageInfo<House> getHouseByCondition(HouseCondition houseCondition);

}
