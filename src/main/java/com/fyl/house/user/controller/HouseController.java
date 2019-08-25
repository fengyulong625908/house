package com.fyl.house.user.controller;

import com.fyl.house.entity.House;
import com.fyl.house.entity.Users;
import com.fyl.house.service.HouseService;
import com.fyl.house.utils.HouseCondition;
import com.fyl.house.utils.Page;
import com.fyl.house.utils.UploadFiles;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
@RequestMapping("/page")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @RequestMapping("/addHouse")
    public String  addHouse(@RequestParam(value="pfile",required = false)CommonsMultipartFile pfile, House house, HttpSession session, Model model){
        //一个CommonsMultipartFile类的对象就代表一个表单文件域，一张图片
        //获取上传文件的信息
       /* System.out.println("文件名"+pfile.getOriginalFilename());
        System.out.println("文件大小:"+pfile.getSize());
        System.out.println("文件类型:"+pfile.getContentType());*/
        try {
            //第一步上传图片
            String path="e:\\imgs\\";  //存放文件的位置
            //生成唯一文件名
            String oldName=pfile.getOriginalFilename();
            String expname=oldName.substring(oldName.lastIndexOf("."));
            String filename=System.currentTimeMillis()+expname;
            File file=new File(path+filename);
            pfile.transferTo(file);  //上传，保存
            //第二步保存信息到数据库
            //设置主键
            house.setId(System.currentTimeMillis()+"");
            //设置发布出租房的用户
            Users users=(Users) session.getAttribute("users");
            house.setUserId(users.getId());
            //设置图片
            house.setPath(filename);
            houseService.addHouse(house);
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("info","上传文件失败..");
        }
        return "redirect:/page/getHouseByUser";
    }
    @RequestMapping("/getHouseByUser")
    public String getHouseByUser(Page page,Model model,HttpSession session){
        Users users=(Users) session.getAttribute("users");
        PageInfo<House> pageInfo = houseService.getHouseByUser(users.getId(), page);
        model.addAttribute("pageInfo",pageInfo);
        return "guanli";
    }


    @RequestMapping("/getHouseById")
    public String getHouseById(String id ,Model model){

        House house = houseService.getHouseByID(id);
        model.addAttribute("house",house);
        return "showHouse";
    }


    @RequestMapping("/updateHouse")
    public String updateHouse( String deletePfile, House house,@RequestParam("pfile") CommonsMultipartFile pfile) {
        try {

            String oldName = pfile.getOriginalFilename();

            if (oldName.equals("")) {
                int i = houseService.updateHouse(house);
                System.out.println(i);
                return "redirect:/page/getHouseByUser";
            } else {
                //生成唯一文件名
                File file = UploadFiles.UploadFile(pfile.getOriginalFilename());
                pfile.transferTo(file);  //上传，保存
                //第二步保存信息到数据库
                //设置图片
                house.setPath(file.getName());
                String path = UploadFiles.getPath();
                int i = houseService.updateHouse(house);
                File dfile=new File(path+deletePfile);
                dfile.delete();
                return "redirect:/page/getHouseByUser";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/page/getHouseByUser";
        }

    }

    @RequestMapping("/upDataHouseIsDel")
    public String upDataHouseIsDel(String id ){
        houseService.upDataHouseIsDel(id,1);
        return "redirect:/page/getHouseByUser";
    }


    @RequestMapping("/getHouseByCondition")
    public String getHouseByCondition(HouseCondition houseCondition ,Model model){
        PageInfo<House> pageInfo = houseService.getHouseByCondition(houseCondition);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("houseCondition",houseCondition);
        return "list";
    }
    @RequestMapping("/getHouse")
    public String getHouse(String id ,Model model){
        House house = houseService.getHouseByID(id);
        model.addAttribute("house",house);
        return "details";
    }

}
