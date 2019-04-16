package com.qianfeng.service.impl;

import com.qianfeng.common.PageInfo;
import com.qianfeng.dao.RoleMapper;
import com.qianfeng.entity.Role;
import com.qianfeng.service.RoleService;
import com.qianfeng.utils.PageUtil;
import com.qianfeng.vo.VUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zelven
 * @date 2019/4/13/013
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public PageInfo findAllRole(int page, int limit) {
       int index = PageUtil.getIndex(page,limit);
       int count = roleMapper.queryCount();
       List<Role> list = roleMapper.queryAll(index,limit);
       return PageUtil.createPage(count,list);
    }
    @Override
    public void deleteById(int id) {
        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Role> queryRole(int id) {
        return roleMapper.queryRole(id);
    }
}
