package com.qianfeng.service.impl;

import com.qianfeng.dao.GradeMapper;
import com.qianfeng.entity.Grade;
import com.qianfeng.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeMapper gradeDao;

    @Override
    public List<Grade> findAll() {
        return gradeDao.findAll();
    }
}
