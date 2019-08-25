package com.fyl.house.service.impl;

import com.fyl.house.entity.Street;
import com.fyl.house.entity.StreetExample;
import com.fyl.house.mapper.StreetMapper;
import com.fyl.house.service.StreetService;
import com.fyl.house.utils.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {
    
    @Autowired
    private StreetMapper streetMapper;
    @Override
    public PageInfo<Street> selectAll(Page page ,Integer did) {
        //1.开启分页
        PageHelper.startPage(page.getPage(),page.getRows());
        //2.查询所有
        //封装条件实体类
        StreetExample StreetExample=new StreetExample();
        StreetExample.createCriteria().andDistrictIdEqualTo(did);
        List<Street> list=streetMapper.selectByExample(StreetExample);
        //3.获取分页相关的属性
        PageInfo<Street> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    /**
     *
     * @param street 新增的街道对象
     * @return
     */
    @Override
    public int addStreet(Street street) {
     return    streetMapper.insertSelective(street);
    }

    /**
     *
     * @param street 修改的街道对象
     * @return
     */

    @Override
    public int updateStreet(Street street) {
        return streetMapper.updateByPrimaryKeySelective(street);
    }

    /**
     *
     * @param id 执行删除的id
     * @return
     */
    @Override
    public int deleteStreet(Integer id) {
      return   streetMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Street> selectStreetByDid(Integer id) {
        StreetExample example=new StreetExample();
        example.createCriteria().andDistrictIdEqualTo(id);
      return streetMapper.selectByExample(example);
    }
}
