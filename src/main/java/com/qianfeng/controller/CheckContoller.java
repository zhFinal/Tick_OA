package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.common.LayUIListJsonBean;
import com.qianfeng.common.PageInfo;
import com.qianfeng.entity.Check;
import com.qianfeng.entity.User;
import com.qianfeng.service.CheckService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VEcharts;
import com.qianfeng.vo.VPage;
import com.qianfeng.vo.VProcess;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zelven
 * @date 2019/4/16/016
 */
@RestController
public class CheckContoller {
    @Autowired
    private CheckService checkService;
    @RequestMapping("/processlist.do")
    public LayUIListJsonBean selectAll(int page,int limit){
        PageInfo pageInfo = checkService.queryAll(page,limit);
        return JsonUtils.createListBean(0,pageInfo);

    }

    @RequestMapping("/processecharts.do")
    public VEcharts processTb(String pid){
        return checkService.queryBtEcharts(pid);
    }


    @RequestMapping("/processdel.do")
    public JsonBean deleteById(int id){
        checkService.delete(id);
        return JsonUtils.createJsonBean(1,null);
    }

    @RequestMapping("/processnolist.do")
    public VPage<VProcess> processNoList(){
        User user = (User)SecurityUtils.getSubject().getSession().getAttribute("user");
        return checkService.queryByName(user.getName());
    }


}
