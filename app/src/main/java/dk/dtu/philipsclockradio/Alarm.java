package dk.dtu.philipsclockradio;

import java.util.Date;

public class Alarm {
    private Date time;
    private boolean isActive;

    public Alarm (Date time){
        this.time = time;
        this.isActive = false;
    }

    public Date getTime() {return time;}

    public void setTime(Date time) {this.time = time;}

    public void setAlarmTimeSec(long time) {
        this.time.setTime(time);
    }

    public long getAlarmTimeSec(){
        return time.getTime();
    }
    public String getAlarmDisplay(){
        return time.toString().substring(11,16);
    }

    public boolean isActive() {return isActive;}

    public void setActive(boolean active) {isActive = active;}
}
