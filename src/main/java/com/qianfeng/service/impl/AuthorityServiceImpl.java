package com.qianfeng.service.impl;

import com.qianfeng.common.PageInfo;
import com.qianfeng.dao.AuthorityMapper;
import com.qianfeng.entity.Authority;
import com.qianfeng.entity.Course;
import com.qianfeng.service.AuthorityService;
import com.qianfeng.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zelven
 * @date 2019/4/13/013
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityMapper authorityMapper;


    @Override
    public int save(Authority authority) {
        return authorityMapper.save(authority);
    }

    @Override
    public List<Authority> queryAll() {
        return authorityMapper.queryAll();
    }

    @Override
    public PageInfo findAllAutByPage(Integer page, Integer limit) {

        Integer index = PageUtil.getIndex(page, limit);

        List<Authority> authorityList = authorityMapper.findAllAutByPage(index, limit);

        int count = authorityMapper.findCount();

        PageInfo pageInfo = new PageInfo();
        pageInfo.setCount(count);
        pageInfo.setData(authorityList);

        return pageInfo;
    }

    @Override
    public int deleteAutById(Integer id) {
        Authority authority = authorityMapper.selectByPrimaryKey(id);
        if (null == authority) {
            throw new RuntimeException("删除资源权限不存在");
        }

        if (0  == authority.getParentId()) {
            return -1;
        } else {
            int i = authorityMapper.deleteByPrimaryKey(id);
            System.out.println(i);
            return i;
        }

    }

    @Override
    public int addAuthority(Authority authority) {
        Authority aut = authorityMapper.findByName(authority.getTitle());

        if (aut != null) {
            // 判断权限名称是否重复
            throw new RuntimeException("该权限名称已存在，请重新输入");
        }

        if (null == authority.getParentId() || authority.getParentId().equals("")) {
            authority.setParentId(0);
        }

        return authorityMapper.insertSelective(authority);
    }

    @Override
    public List<Authority> findRootByParentId(Integer parentId) {
        return authorityMapper.findRootByParentId(parentId);
    }

    @Override
    public Authority findById(Integer id) {
        return authorityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateAuthority(Authority authority) {
        Authority aut = authorityMapper.findByName(authority.getTitle());

        if (aut != null && aut.getId() != authority.getId()) {
            // 判断资源名称是否重复
            throw new RuntimeException("该资源权限名称已存在，请重新输入");
        }
        return authorityMapper.updateByPrimaryKeySelective(authority);

    }


}
