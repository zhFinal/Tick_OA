package com.qianfeng.vo;

/**
 * @author Zelven
 * @date 2019/4/16/016
 */
public class EchartsItem {


    private String pid;
    private String aname;
    private String stime;
    private String etime;
    private String dura;

    public String getEtime() {
        return etime;
    }

    public String getDura() {
        return dura;
    }

    public void setDura(String dura) {
        this.dura = dura;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
