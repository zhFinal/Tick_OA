package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.common.LayUIListJsonBean;
import com.qianfeng.common.PageInfo;
import com.qianfeng.entity.User;
import com.qianfeng.service.UserService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.utils.PageUtil;
import com.qianfeng.vo.VUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Zelven
 * @date 2019/4/15/015
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/userall.do")
    public LayUIListJsonBean findAllUser(int page, int limit){
        PageInfo pageInfo = userService.findAllUser(page,limit);

        return JsonUtils.createListBean(0,pageInfo);
    }

    @RequestMapping("/userdel.do")
    public JsonBean deleleById(int id){
        userService.deleteById(id);
        return JsonUtils.createJsonBean(1000 ,null);
    }

    @RequestMapping("/find.do")
    public LayUIListJsonBean findByCondition(int page,int limit,String no,int flag){

        PageInfo pageInfo = userService.findByCondition(page,limit,no,flag);
        return JsonUtils.createListBean(0,pageInfo);
    }

    @RequestMapping("/leader.do")
    @ResponseBody
    public List<User> findLeader() {
        return userService.findLeader();
    }
}
