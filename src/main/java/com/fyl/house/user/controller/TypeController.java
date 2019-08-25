package com.fyl.house.user.controller;

import com.fyl.house.entity.Type;
import com.fyl.house.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller(value = "TypeController2")
@RequestMapping("/page")
public class TypeController {
    @Autowired
    private TypeService service;
    /**
     *
     * @param
     * @return
     */
    @RequestMapping("/selectTypeAll")
    @ResponseBody
    public List<Type> selectAll(){

        List<Type> types = service.selectTypeALL();
        return types;

    }

}
