package com.down.ssm.domain;

import com.down.ssm.pojo.time;
import org.springframework.context.annotation.Scope;

import java.util.Date;
@Scope("prototype")
public class DownInformation {
    private Integer down_id;

    private String down_url;

    private String down_filename;

    private String down_savapath;

    private String down_size;

    private Date down_strattime;

    private Date down_endtime;

    private Integer down_YNsuccess;

    public Integer getDown_id() {
        return down_id;
    }

    public void setDown_id(Integer down_id) {
        this.down_id = down_id;
    }

    public String getDown_url() {
        return down_url;
    }

    public void setDown_url(String down_url) {
        this.down_url = down_url;
    }

    public String getDown_filename() {
        return down_filename;
    }

    public void setDown_filename(String down_filename) {
        this.down_filename = down_filename;
    }

    public String getDown_savapath() {
        return down_savapath;
    }

    public void setDown_savapath(String down_savapath) {
        this.down_savapath = down_savapath;
    }

    public String getDown_size() {
        return down_size;
    }

    public void setDown_size(String down_size) {
        this.down_size = down_size;
    }

    public Date getDown_strattime() {
        return down_strattime;
    }

    public void setDown_strattime(Date down_strattime) {
        this.down_strattime = down_strattime;
    }

    public Date getDown_endtime() {
        return down_endtime;
    }

    public void setDown_endtime(Date down_endtime) {
        this.down_endtime = down_endtime;
    }

    public Integer getDown_YNsuccess() {
        return down_YNsuccess;
    }

    public void setDown_YNsuccess(Integer down_YNsuccess) {
        this.down_YNsuccess = down_YNsuccess;
    }

    public String toString(){

        String down_YN;
        time downtime = new time();

        if(this.down_YNsuccess == 2)
        {
            down_YN = "下载中断";
        }
        else if(this.down_YNsuccess == 1)
        {
            down_YN = "下载成功";
        }
        else
        {
            down_YN = "下载失败";
        }

        downtime.starttime = downtime.formattime(down_strattime);
        downtime.endtime = downtime.formattime(down_endtime);



        return "下载id:"+this.down_id+"\n"
                +"下载链接:"+this.down_url+"\n"
                +"文件名:"+this.down_filename+"\n"
                +"保存路径:" +this.down_savapath+"\n"
                +"下载开始时间:"+downtime.starttime+"\n"
                +"下载结束时间:"+downtime.endtime+"\n"
                +"文件大小:"+this.down_size+"Kb"+"\n"
                +"下载状态:"+down_YN+"\n";
    }

}