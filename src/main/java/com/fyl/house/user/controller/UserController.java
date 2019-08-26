package com.fyl.house.user.controller;

import com.fyl.house.entity.Users;
import com.fyl.house.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping("/page")
public class UserController {
    @Autowired
    private UsersService usersService;

    /**
     *
     * @param user 新增的用户对象
     * @return 新增成功或者失败
     */
    @RequestMapping("/addUser")

    public String selectAll(Users user){
       int i=usersService.addUser(user);
       if (i>=1){
            return "login";
       }
       return "regs";
    }

    @RequestMapping("/isUserNameExists")
    @ResponseBody
    public int isUserNameExists(String name) {
        System.out.println(name);
        HashMap<String, Object> map = new HashMap<>();
        return usersService.isUserNameExists(name);
    }

    @RequestMapping("/login")
    @ResponseBody
    public int login(String userName, String password, HttpSession session) {
        Users users = usersService.login(userName, password);
        if (users!=null) {
            session.setAttribute("users", users);
           return 1;
        }else {
            return 0;
        }
    }

    @RequestMapping("/login2")
    @ResponseBody
    public int login(HttpSession session,String inputCode) {

      if (session.getAttribute("users")!=null){
         String code = (String) session.getAttribute("code");
         if (inputCode.equals(code)){
             return 1;
         }else {
             return 0;
         }
      }else {
          return 0;
      }
    }
}
