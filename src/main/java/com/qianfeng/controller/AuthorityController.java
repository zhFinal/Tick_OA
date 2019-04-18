package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.common.LayUIListJsonBean;
import com.qianfeng.common.PageInfo;
import com.qianfeng.entity.Authority;
import com.qianfeng.entity.Course;
import com.qianfeng.service.AuthorityService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.utils.LayuiJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;

    @RequestMapping("/authorityall.do")
    @ResponseBody
    public List findAll() {

        List<Authority> list = authorityService.queryAll();

        return list;

    }

    @RequestMapping("/authoritylist.do")
    @ResponseBody
    public LayUIListJsonBean findAllAutByPage(Integer page, Integer limit) {

        PageInfo pageInfo = authorityService.findAllAutByPage(page,limit);

        Integer count = pageInfo.getCount();
        List<Authority> authorityList = (List<Authority>) pageInfo.getData();

        return LayuiJsonUtils.createListBean(0, authorityList, count);

    }


    @RequestMapping("/authoritydelete.do")
    @ResponseBody
    public JsonBean deleteAuthoritById(Integer id) {

        int ret = authorityService.deleteAutById(id);
        if (-1 == ret) {
            return JsonUtils.createJsonBean(2000,null);
        } else {
            return JsonUtils.createJsonBean(1000,null);
        }

    }

    @RequestMapping("/authorityadd.do")
    @ResponseBody
    public JsonBean addAuthority(Authority authority) {

        int i = authorityService.addAuthority(authority);
        System.out.println(i);

        return JsonUtils.createJsonBean(1000, null);

    }

    @RequestMapping("/authorityroot.do")
    @ResponseBody
    public List findRootByParentId(Integer root) {

        root = 0;

        List<Authority> parentAuthorityList = authorityService.findRootByParentId(root);

        return parentAuthorityList;

    }

    @RequestMapping("/authorityquery.do")
    @ResponseBody
    public JsonBean queryAutById(Integer id) {

        Authority authority = authorityService.findById(id);

        return JsonUtils.createJsonBean(1,authority);

    }

    @RequestMapping("/authorityupdate.do")
    @ResponseBody
    public JsonBean updateAuthority(Authority authority) {

        int i = authorityService.updateAuthority(authority);
        System.out.println(i);

        return JsonUtils.createJsonBean(1, null);

    }


}
