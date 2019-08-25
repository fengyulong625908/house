package com.fyl.house.controller;

import com.fyl.house.entity.Type;
import com.fyl.house.service.TypeService;
import com.fyl.house.utils.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    private TypeService service;
    /**
     *
     * @param page 分页的参数
     * @return 总页数和 每页的数据数
     */
    @RequestMapping("/selectTypeAll")
    @ResponseBody
    public HashMap<String,Object> selectAll(Page page){

        PageInfo<Type> list = service.selectAll(page);
        HashMap<String,Object> map=new HashMap<>();
        map.put("total",list.getTotal());
        map.put("rows",list.getList());
        return map;
    }


    @RequestMapping("/addType")
    @ResponseBody
    public int addType(Type type){
       return service.addType(type);
    }

    @RequestMapping("/selectOneType")
    @ResponseBody
    public Type selectOneType(Integer id){
        return service.selectTypeOne(id);
    }


    @RequestMapping("/updateType")
    @ResponseBody
    public int updateType(Type type){
        return service.updateType(type);
    }


    @RequestMapping("/deleteTypes")
    @ResponseBody
    public int deleteTypes(Integer [] ids){
        return service.deleteTypes(ids);
    }
}
