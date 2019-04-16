package com.qianfeng.controller;

import com.qianfeng.entity.LoginLog;
import com.qianfeng.service.LoginLogService;
import com.qianfeng.vo.VPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zelven
 * @date 2019/4/15/015
 */

@RestController
public class LoginLogController {
    @Autowired
    private LoginLogService loginLogService;

    @RequestMapping("/loginloglist.do")
    public VPage<LoginLog> list(){
        VPage<LoginLog> po = new VPage<>();
        po.setData(loginLogService.queryAll());
        po.setCode(0);
        po.setCount(po.getData().size());
        po.setMsg("OK");
        return po;
    }
}
