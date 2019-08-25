package com.fyl.house.service.impl;

import com.fyl.house.entity.House;
import com.fyl.house.mapper.HouseMapper;
import com.fyl.house.service.HouseService;
import com.fyl.house.utils.HouseCondition;
import com.fyl.house.utils.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;
    @Override
    public int addHouse(House house) {
      return   houseMapper.insertSelective(house);
    }

    @Override
    public PageInfo<House> getHouseByUser(Integer userId, Page page) {
        PageHelper.startPage(page.getPage(),page.getRows());
        List<House> houseByUser = houseMapper.getHouseByUser(userId);
        return new PageInfo<House>(houseByUser);
    }

    @Override
    public House getHouseByID(String id) {
      return houseMapper.getHouseByID(id);
    }

    @Override
    public int updateHouse(House house) {
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    /**
     *
     * @param id 删除的id
     * @param isDel 改为1为逻辑删除
     * @return
     */
    @Override
    public int upDataHouseIsDel(String id, Integer isDel) {
        House house=new House();
        house.setId(id);
        house.setIsdel(isDel);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    /**
     *
     * @param houseCondition 分页的条件
     * @param isPass 0表示未审核，1表示已审核
     * @return
     */
    @Override
    public PageInfo<House> getHouseByNoPass(HouseCondition houseCondition, Integer isPass) {
        PageHelper.startPage(houseCondition.getPage(),houseCondition.getRows());
        houseCondition.setIsPass(isPass);
        List<House> houses = houseMapper.getHouseByIsPass(houseCondition);
        return new PageInfo<House>(houses);
    }

    /**
     *
     * @param id 房间的id
     * @param isPass 1为已审核 ，0为未审核
     * @return
     */
    @Override
    public int PassHouse(String id, Integer isPass) {
        House house=new House();
        house.setId(id);
        house.setIspass(isPass);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    /**
     *
     * @param houseCondition 搜索的条件
     * @return
     */
    @Override
    public PageInfo<House> getHouseByCondition(HouseCondition houseCondition) {
        PageHelper.startPage(houseCondition.getPage(),houseCondition.getRows());
        List<House> houses = houseMapper.getHouseAllByIsPass(houseCondition);
        return new PageInfo<House>(houses);
    }


}
