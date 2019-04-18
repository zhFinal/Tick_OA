package com.qianfeng.service;

import com.qianfeng.common.PageInfo;
import com.qianfeng.entity.Authority;

import java.util.List;

/**
 * @author Zelven
 * @date 2019/4/13/013
 */
public interface AuthorityService {


    //新增
    int save(Authority authority);

    //查询
    List<Authority> queryAll();

    // 分页查询所有资源权限信息
    public PageInfo findAllAutByPage(Integer page, Integer limit);

    // 根据班级编号删除资源权限信息
    public int deleteAutById(Integer id);

    // 选择性添加新资源权限信息
    public int addAuthority(Authority authority);

    // 查询一级菜单权限信息
    public List<Authority> findRootByParentId(Integer parentId);

    // 根据学科名称查询学科信息
    public Authority findById(Integer id);

    // 选择性更新学科信息
    public int updateAuthority(Authority authority);


}
