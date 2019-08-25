package com.fyl.house.service.impl;

import com.fyl.house.entity.District;
import com.fyl.house.entity.DistrictExample;
import com.fyl.house.mapper.DistrictMapper;
import com.fyl.house.mapper.StreetMapper;
import com.fyl.house.service.DistrictService;
import com.fyl.house.utils.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;

    @Autowired
    private StreetMapper streetMapper;
    @Override
    public PageInfo<District> selectAll(Page page) {
        //1.开启分页
        PageHelper.startPage(page.getPage(),page.getRows());
        //2.查询所有
        //封装条件实体类
        DistrictExample districtExample=new DistrictExample();
        List<District> list=districtMapper.selectByExample(districtExample);
        //3.获取分页相关的属性
        PageInfo<District> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int addDistrict(District district) {
     return    districtMapper.insertSelective(district);
    }

    @Override
    public District selectDistrictOne(Integer id) {
        return districtMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateDistrict(District district) {
        return districtMapper.updateByPrimaryKeySelective(district);
    }

    @Override
    @Transactional
    public int deleteDistrict(Integer[] ids) {
                streetMapper.deleteMoreStreetByDistrictId(ids);
      return   districtMapper.deleteMoreDistrict(ids);


    }

    @Override
    public List<District> selectAllDistrict() {
        return districtMapper.selectByExample(new DistrictExample());
    }
}
