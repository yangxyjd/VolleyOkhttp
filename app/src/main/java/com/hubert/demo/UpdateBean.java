package com.hubert.demo;

/**
 * Created by yang on 2015/11/29 0029.
 */
public class UpdateBean {
    private String serverVersion;

    public String getUpgradeinfo() {
        return upgradeinfo;
    }

    public void setUpgradeinfo(String upgradeinfo) {
        this.upgradeinfo = upgradeinfo;
    }

    private String upgradeinfo;

    public String getServerVersion() {
        return serverVersion;
    }

    public void setServerVersion(String serverVersion) {
        this.serverVersion = serverVersion;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getUpdateurl() {
        return updateurl;
    }

    public void setUpdateurl(String updateurl) {
        this.updateurl = updateurl;
    }

    public String getLastForce() {
        return lastForce;
    }

    public void setLastForce(String lastForce) {
        this.lastForce = lastForce;
    }

    public String getServerFlag() {
        return serverFlag;
    }

    public void setServerFlag(String serverFlag) {
        this.serverFlag = serverFlag;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    private String serverName;
    private String updateurl;
    private String lastForce;
    private String serverFlag;
    private String appname;

    @Override
    public String toString() {
        return "UpdateBean{" +
                "serverVersion='" + serverVersion + '\'' +
                ", upgradeinfo='" + upgradeinfo + '\'' +
                ", serverName='" + serverName + '\'' +
                ", updateurl='" + updateurl + '\'' +
                ", lastForce='" + lastForce + '\'' +
                ", serverFlag='" + serverFlag + '\'' +
                ", appname='" + appname + '\'' +
                '}';
    }
}
