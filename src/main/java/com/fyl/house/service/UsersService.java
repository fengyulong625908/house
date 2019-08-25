package com.fyl.house.service;

import com.fyl.house.entity.Users;
import com.fyl.house.utils.UserCondition;
import com.github.pagehelper.PageInfo;

public interface UsersService {

    /**
     *查询所有的用户
     * @return 用户实体集合
     */
    PageInfo<Users> selectAll(UserCondition userCondition);

    /**
     *
     * @param user 注册用户信息
     * @return 注册成功或者失败
     */
    int addUser(Users user);

    /**
     *
     * @param name 判断数据库是否有重复的名字
     * @return 相同名字的条数
     */
    int isUserNameExists (String name);

    /**
     *
     * @param userName 用户名
     * @param password 密码
     * @return  根据用户名密码查询到的用户
     */
    Users login(String userName,String password);




}
