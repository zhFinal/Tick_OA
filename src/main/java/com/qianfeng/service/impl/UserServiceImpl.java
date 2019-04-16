package com.qianfeng.service.impl;

import com.qianfeng.common.PageInfo;
import com.qianfeng.dao.UserDao;
import com.qianfeng.entity.Role;
import com.qianfeng.entity.User;
import com.qianfeng.service.UserService;
import com.qianfeng.utils.PageUtil;
import com.qianfeng.vo.VMenu;
import com.qianfeng.vo.VUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * 1645
 */
@Service
public class UserServiceImpl  implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public User login(String name, String password) {
        // shiro中提供的认证操作方法
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        // 登出
        //subject.logout();
        User user = userDao.selectByName(name);
        return user;
    }

    @Override
    public void loginRememberMe(String name, String password, boolean rememberMe) {
        // shiro中提供的认证操作方法
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
//        if(rememberMe){
            // 何止是否记住我
            token.setRememberMe(rememberMe);
//        }
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
    }

    @Override
    public PageInfo findAllUser(int page, int limit) {
        int index = PageUtil.getIndex(page,limit);
        int count = userDao.queryCount();
        List<VUser> list = userDao.findAllUser(index,limit);
        return PageUtil.createPage(count,list);

    }

    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public User selectByName(String name) {
        return userDao.selectByName(name);
    }


    @Override
    public List<VMenu> queryMenuById(int id) {
        return userDao.queryMenu(id);
    }

    @Override
    public PageInfo findByCondition(int page, int limit, String no, int flag) {
        int index = PageUtil.getIndex(page,limit);
        int count = userDao.queryCountByCondition(no,flag);
        List<VUser> list = userDao.findByCondition(no,flag);
        return PageUtil.createPage(count,list);
    }


}
