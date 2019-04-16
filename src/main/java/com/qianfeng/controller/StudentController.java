package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.common.LayUIListJsonBean;
import com.qianfeng.common.PageInfo;
import com.qianfeng.entity.Student;
import com.qianfeng.service.StudentService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.utils.LayuiJsonUtils;
import com.qianfeng.utils.PageUtil;
import com.qianfeng.vo.VStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/studentpage.do")
    public LayUIListJsonBean findAllStuByPage(Integer page, Integer limit) {

        int index = PageUtil.getIndex(page, limit);

        int count = studentService.findCount();

        List<VStudent> vStudentList = studentService.findAllStu(index, limit);

        return LayuiJsonUtils.createListBean(0, vStudentList, count);

    }


    @RequestMapping("/studentdelete.do")
    public JsonBean deleteStuById(String no) {

        studentService.deleteStuByNo(no);

        return JsonUtils.createJsonBean(1000, null);

    }

    @RequestMapping("/createno.do")
    public JsonBean createStuNo() {

        String no = studentService.createStuNo();
        Map<String, Object> map = new HashMap<>();
        map.put("no", no);
        return JsonUtils.createJsonBean(1, map);

    }

    @RequestMapping("/studentadd.do")
    public JsonBean addStudent(Student student) {

        int i = studentService.addStudent(student);
        System.out.println(i);

        return JsonUtils.createJsonBean(1, null);

    }

    @RequestMapping("/studentquery.do")
    public JsonBean queryByNo(String no) {

        Student stu = studentService.findStuByNo(no);

        return JsonUtils.createJsonBean(1, stu);

    }

    @RequestMapping("/studentupdate.do")
    public JsonBean updateStudent(Student student) {

        int i = studentService.updateStu(student);
        System.out.println(i);

        return JsonUtils.createJsonBean(1, null);

    }

}
