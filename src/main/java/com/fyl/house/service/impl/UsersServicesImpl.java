package com.fyl.house.service.impl;

import com.fyl.house.entity.Users;
import com.fyl.house.entity.UsersExample;
import com.fyl.house.mapper.UsersMapper;
import com.fyl.house.service.UsersService;
import com.fyl.house.utils.MD5Utils;
import com.fyl.house.utils.UserCondition;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersServicesImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public PageInfo<Users> selectAll(UserCondition userCondition) {

        //1.开启分页
        PageHelper.startPage(userCondition.getPage(), userCondition.getRows());

        //2查询所有非管理员的用户0不是，1是
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria().andIsadminEqualTo(new Integer("0"));
        //搜索姓名条件
        if (userCondition.getName()!=null){
            criteria.andNameLike("%"+ userCondition.getName()+"%");
        }
        //搜索电话条件
        if (userCondition.getName()!=null){
            criteria.andTelephoneLike("%"+ userCondition.getTelephone()+"%");
        }
        List<Users> list=usersMapper.selectByExample(usersExample);
        PageInfo<Users> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int addUser(Users user) {
        user.setIsadmin(new Integer("0"));
        user.setPassword(MD5Utils.md5Encrypt(user.getPassword()));
     return    usersMapper.insertSelective(user);
    }

    @Override
    public int isUserNameExists(String name) {
     return    usersMapper.isUserNameExists(name);
    }

    @Override
    public Users login(String userName, String password) {
       UsersExample example=new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(userName);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        List<Users> users = usersMapper.selectByExample(example);
        if (users.size()==0){
            return null;
        }else {
         return    users.get(0);
        }
    }
}
