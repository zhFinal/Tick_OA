package com.qianfeng.controller;

import com.qianfeng.common.CommonInfo;
import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.User;
import com.qianfeng.service.UserService;
import com.qianfeng.utils.JsonUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//1645
//fetch
//123
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @RequestMapping("/login.do")
    @ResponseBody
    public JsonBean login(String name, String password, boolean rememberMe, HttpSession session){

        try {
            User user = userService.login(name,password);
            session.setAttribute(CommonInfo.LOGIN_USER,user);
            return JsonUtils.createJsonBean(1, null);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtils.createJsonBean(0,e.getMessage());
        }

    }
}
