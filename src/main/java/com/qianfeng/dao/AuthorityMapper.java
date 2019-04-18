package com.qianfeng.dao;

import com.qianfeng.entity.Authority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthorityMapper {

    // 根据权限编号id删除对应权限
    int deleteByPrimaryKey(Integer id);

    int insert(Authority record);

    // 选择性添加新权限信息
    int insertSelective(Authority record);

    // 根据权限编号id查询对应权限信息
    Authority selectByPrimaryKey(Integer id);

    // 选择性更新资源权限信息
    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);

    //新增
    int save(Authority authority);

    List<Authority> queryAll();

    //查询数量
    Integer queryCount(String where);


    // 分页查询所有学生信息
    List<Authority> findAllAutByPage(@Param("index") Integer index, @Param("limit") Integer limit);

    // 查询所有权限资源信息总条数
    public int findCount();

    // 根据资源权限名称查询信息
    public Authority findByName(String name);

    // 查询一级菜单权限信息
    public List<Authority> findRootByParentId(Integer parentId);


}