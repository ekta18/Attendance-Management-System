/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atd_mn_sys;


public class Attendance {
    String sstime,eetime,ppid,ssuid,sstatus;

    public Attendance(String sstime, String eetime, String ppid, String ssuid, String sstatus) {
        this.sstime = sstime;
        this.eetime = eetime;
        this.ppid = ppid;
        this.ssuid = ssuid;
        this.sstatus = sstatus;
    }

    public String getSstime() {
        return sstime;
    }

    public void setSstime(String sstime) {
        this.sstime = sstime;
    }

    public String getEetime() {
        return eetime;
    }

    public void setEetime(String eetime) {
        this.eetime = eetime;
    }

    public String getPpid() {
        return ppid;
    }

    public void setPpid(String ppid) {
        this.ppid = ppid;
    }

    public String getSsuid() {
        return ssuid;
    }

    public void setSsuid(String ssuid) {
        this.ssuid = ssuid;
    }

    public String getSstatus() {
        return sstatus;
    }

    public void setSstatus(String sstatus) {
        this.sstatus = sstatus;
    }
    
    
}
