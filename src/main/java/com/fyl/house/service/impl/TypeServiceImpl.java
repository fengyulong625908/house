package com.fyl.house.service.impl;

import com.fyl.house.entity.Type;
import com.fyl.house.entity.TypeExample;
import com.fyl.house.mapper.TypeMapper;
import com.fyl.house.service.TypeService;
import com.fyl.house.utils.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    @Override
    public PageInfo<Type> selectAll(Page page) {
        //1.开启分页
        PageHelper.startPage(page.getPage(),page.getRows());
        //2.查询所有
        //封装条件实体类
        TypeExample typeExample=new TypeExample();
        List<Type> list=typeMapper.selectByExample(typeExample);
        //3.获取分页相关的属性
        PageInfo<Type> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    /**
     *
     * @param type 新增的对象
     * @return 影响的行数
     */
    @Override
    public int addType(Type type) {
        int i=-1;
        try {
           i= typeMapper.insertSelective(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     *
     * @param id 主键
     * @return 根据主键查询的结果
     */
    @Override
    public Type selectTypeOne(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    /**
     *
     * @param type 修改的对象
     * @return 影响的行数
     */
    @Override
    public int updateType(Type type) {
      return   typeMapper.updateByPrimaryKeySelective(type);
    }

    /**
     *
     * @param ids 执行删除的id数组
     * @return
     */

    @Override
    public int deleteTypes(Integer[] ids) {
        return typeMapper.deleteMoreType(ids);
    }

    @Override
    public List<Type> selectTypeALL() {
        return typeMapper.selectByExample(new TypeExample());
    }

}
