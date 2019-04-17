package com.qianfeng.service;

import com.qianfeng.common.PageInfo;
import com.qianfeng.entity.Role;
import com.qianfeng.entity.User;
import com.qianfeng.vo.VMenu;
import com.qianfeng.vo.VPage;
import com.qianfeng.vo.VUser;

import java.util.List;

public interface UserService {
//    1645

    public User login(String name, String password);

    public void loginRememberMe(String no, String password, boolean rememberMe);

    PageInfo findAllUser(int page, int limit);

    void deleteById(int id);

    User selectByName(String name);

//    void login(String name, String password);


    List<VMenu> queryMenuById(int id);

    PageInfo findByCondition(int page,int limit,String no,int flag);
//    void loginRememberMe(String name, String password, boolean rememberMe);

    List<User> findLeader();
}
