package com.fyl.house.controller;

import com.fyl.house.entity.Users;
import com.fyl.house.service.UsersService;
import com.fyl.house.utils.UserCondition;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/admin")
public class UsersController {
    @Autowired
    private UsersService usersService;

    /**
     *
     * @param userCondition 搜索的条件和分页的参数
     * @return 总页数和 每页的数据数
     */
    @RequestMapping("/selectUserstAll")
    @ResponseBody
    public HashMap<String,Object> selectAll(UserCondition userCondition){
        PageInfo<Users> list = usersService.selectAll(userCondition);
        HashMap<String,Object> map=new HashMap<>();
        map.put("total",list.getTotal());
        map.put("rows",list.getList());
        return map;
    }


}
