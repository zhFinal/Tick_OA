package com.qianfeng.vo;

import com.qianfeng.entity.Authority;

import java.util.List;

/**
 * @author Zelven
 * @date 2019/4/13/013
 */
public class VMenu {

    private Integer id;
    private String title;
    private String aurl;
    private List<VMenu> menuList;

    public String getAurl() {
        return aurl;
    }

    public void setAurl(String aurl) {
        this.aurl = aurl;
    }

    public List<VMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<VMenu> menuList) {
        this.menuList = menuList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
