package com.fyl.house.controller;

import com.fyl.house.entity.District;
import com.fyl.house.service.DistrictService;
import com.fyl.house.utils.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/admin")
public class DistrictController {
    @Autowired
    private DistrictService service;

    /**
     *
     * @param page 分页的参数
     * @return 总页数和 每页的数据数
     */
    @RequestMapping("/selectDistrictAll")
    @ResponseBody
    public HashMap<String,Object> selectAll(Page page){

        PageInfo<District> list = service.selectAll(page);
        HashMap<String,Object> map=new HashMap<>();
        map.put("total",list.getTotal());
        map.put("rows",list.getList());
        return map;
    }

    /**
     *
     * @param district 新增的对象
     * @return 新增成功的条数
     */
    @RequestMapping("/addDistrict")
    @ResponseBody
    public int addDistrict(District district){
        int i=-1;
        try {
          i = service.addDistrict(district);

            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     *
     * @param id 查询单条的主键
     * @return 查询的结果
     */
    @RequestMapping("/selectDistrictOne")
    @ResponseBody
    public District selectDistrictOne(Integer id){
       return   service.selectDistrictOne(id);
    }

    @RequestMapping("/updateDistrict")
    @ResponseBody
    public int updateDistrict(District district){
        int i=0;
        try {
         i= service.updateDistrict(district);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @RequestMapping("/deleteDistrict")
    @ResponseBody
    public int deleteDistrict(Integer ids[]){
        int i=0;

        try {
          i= service.deleteDistrict(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

}
