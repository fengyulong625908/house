package com.fyl.house.controller;

import com.fyl.house.entity.Street;
import com.fyl.house.service.StreetService;
import com.fyl.house.utils.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class StreetController {
    @Autowired
    private StreetService service;

    /**
     *
     * @param page 分页的参数
     * @return 总页数和 每页的数据数
     */
    @RequestMapping("/selectStreetAllByDid")
    @ResponseBody
    public HashMap<String,Object> selectAll(Page page,Integer did){

        PageInfo<Street> list = service.selectAll(page ,did);
        HashMap<String,Object> map=new HashMap<>();
        map.put("total",list.getTotal());
        map.put("rows",list.getList());
        return map;
    }

    /**
     *
     * @param Street 新增的对象
     * @return 新增成功的条数
     */
    @RequestMapping("/addStreet")
    @ResponseBody
    public int addStreet(Street Street){
        int i=-1;
        try {
          i = service.addStreet(Street);

            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }



    @RequestMapping("/updateStreet")
    @ResponseBody
    public int updateStreet(Street Street){
        int i=0;
        try {
         i= service.updateStreet(Street);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @RequestMapping("/deleteStreet")
    @ResponseBody
    public int deleteStreet(Integer id){
        int i=0;

        try {
          i= service.deleteStreet(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }


    @RequestMapping("/selectStreetAllByDid2")
    @ResponseBody
    public List<Street> selectAll2(Integer did){

        List<Street> streets = service.selectStreetByDid(did);
        return streets;
    }
}
