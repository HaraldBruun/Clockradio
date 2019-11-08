package dk.dtu.philipsclockradio;

import android.os.Handler;
import java.util.Date;

public class StateStandby extends StateAdapter {

    private Date time;
    private static Handler handler = new Handler();
    private ContextClockradio context;

    StateStandby(Date time){
        this.time = time;
    }

    //Opdaterer hvert 60. sekund med + 1 min til tiden
    Runnable setTime = new Runnable() {

        @Override
        public void run() {
            try {
                long currentTime = time.getTime();
                time.setTime(currentTime + 60000);
                context.setTime(time);
            } finally {
                handler.postDelayed(setTime, 1000);
            }
        }
    };

    void startClock() {
        setTime.run();
        context.isClockRunning = true;
    }

    void stopClock() {
        handler.removeCallbacks(setTime);
        context.isClockRunning = false;
    }

    // Implementerer skift til radio fra standby


    @Override
    public void onClick_Power(ContextClockradio context) {
        context.setState(new StateRadio());
    }

    @Override
    public void onEnterState(ContextClockradio context) {
        //Lokal context oprettet for at Runnable kan få adgang
        this.context = context;

        context.updateDisplayTime();
        if(!context.isClockRunning){
            startClock();
        }
    }

    @Override
    public void onLongClick_Preset(ContextClockradio context) {
        stopClock();
        context.setState(new StateSetTime());
    }

    @Override
    public void onClick_Sleep(ContextClockradio context) {
        context.setState(new StateSleep());
    }

    @Override
    public void onLongClick_AL1(ContextClockradio context) {
        context.setState(new StateAlarm1());
    }

    @Override
    public void onLongClick_AL2(ContextClockradio context) {
        context.setState(new StateAlarm2());
    }
}
