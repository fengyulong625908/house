package com.fyl.house.controller;

import com.fyl.house.entity.House;
import com.fyl.house.service.HouseService;
import com.fyl.house.utils.HouseCondition;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller(value = "House2")
@RequestMapping("/admin")
public class HouseController {
    @Autowired
    private HouseService houseService;

    /**
     * 带条件查询未审核的房子
     * @param houseCondition
     * @return 总页数和 每页的数据数
     */
    @RequestMapping("/getHouseByNoPass")
    @ResponseBody
    public HashMap<String,Object> getHouseByNoPass(HouseCondition houseCondition) {
        PageInfo<House> pageInfo = houseService.getHouseByNoPass(houseCondition, 0);
        HashMap <String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    /**
     * 带条件查询已审核的房子
     * @param houseCondition
     * @return
     */
    @RequestMapping("/getHouseByPass")
    @ResponseBody
    public HashMap<String,Object> getHouseByPass(HouseCondition houseCondition) {
        PageInfo<House> pageInfo = houseService.getHouseByNoPass(houseCondition, 1);
        HashMap <String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @RequestMapping("/PassHouse")
    @ResponseBody
    public HashMap<String,Object> PassHouse(String id) {
        int i = houseService.PassHouse(id, 1);
        HashMap <String,Object> map=new HashMap<>();
        map.put("mgs",i);
        return map;
    }

    @RequestMapping("/nOPassHouse")
    @ResponseBody
    public HashMap<String,Object> nOPassHouse(String id) {
        int i = houseService.PassHouse(id, 0);
        HashMap <String,Object> map=new HashMap<>();
        map.put("mgs",i);
        return map;
    }
}
