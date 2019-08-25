package com.fyl.house.user.controller;

import com.fyl.house.entity.Street;
import com.fyl.house.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller(value = "StreetController")
@RequestMapping("/page")
public class StreetController {
    @Autowired
    private StreetService service;

    /**
     *
     * @param did 分页的参数
     * @return 总页数和 每页的数据数
     */
    @RequestMapping("/selectStreetAllByDid")
    @ResponseBody
    public List<Street> selectAll(Integer did){

        List<Street> streets = service.selectStreetByDid(did);
        System.out.println(streets.size());
        return streets;
    }


}
