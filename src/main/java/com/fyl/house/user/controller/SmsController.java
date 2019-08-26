package com.fyl.house.user.controller;

import com.fyl.house.entity.Users;
import com.fyl.house.service.UsersService;
import com.fyl.house.sms.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/page")
public class SmsController {
    @Autowired
    private UsersService usersService;

    /**
     *
     * @param tel 用户手机号
     * @return 验证码发送成功或者失败
     */
    @RequestMapping("/getCode")
    @ResponseBody
    public Map<String,Object> sendCode(String tel,HttpSession session){
        Map <String,Object> map= new HashMap<>();
        int i=0;
        Users users = usersService.login(tel);
        if (users!=null){
            session.setAttribute("users",users);
        String random = Math.random()+"";
        String code=random.substring(2,6);
        String mgs="您的验证码是:"+code;
        i = SmsUtil.sendMsg(tel, mgs);
        session.setAttribute("code",code);
        session.setMaxInactiveInterval(60);
        map.put("mgs",i);
        return map;
        } else {
            map.put("mgs",i);
            return map;
        }
    }
}
