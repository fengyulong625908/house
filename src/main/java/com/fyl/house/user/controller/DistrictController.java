package com.fyl.house.user.controller;

import com.fyl.house.entity.District;
import com.fyl.house.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller(value = "DistrictController")
@RequestMapping("/page")
public class DistrictController {
    @Autowired
    private DistrictService service;

    /**
     *
     * @param
     * @return 总页数和 每页的数据数
     */
    @RequestMapping("/selectDistrictAll")
    @ResponseBody
    public List<District> selectAll(){

        List<District> list = service.selectAllDistrict();

        System.out.println(list.size());

        return list;

    }

}
