package com.qianfeng.controller;

import com.qianfeng.entity.Grade;
import com.qianfeng.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @RequestMapping("/gradeall.do")
    public List findAll() {

        List<Grade> list = gradeService.findAll();

        return list;

    }


}
