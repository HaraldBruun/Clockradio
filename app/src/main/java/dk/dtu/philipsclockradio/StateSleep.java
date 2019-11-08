package dk.dtu.philipsclockradio;

import android.os.Handler;

import static dk.dtu.philipsclockradio.ContextClockradio.ui;

public class StateSleep extends StateAdapter {
    private int sleep = 120, c = 0;
    private static Handler handler = new Handler();
    private ContextClockradio context;

    @Override
    public void onEnterState(ContextClockradio context) {
        this.context = context;
        ui.turnOnLED(3);
        ui.setDisplayText(Integer.toString(sleep));
        handler.postDelayed(toStandby,5000);
        handler.postDelayed(sleepTimer,sleep*1000);
    }
    Runnable toStandby = new Runnable() {
        @Override
        public void run(){
            context.setState(new StateStandby(context.getTime()));
        }
    };

    Runnable sleepTimer = new Runnable() {
        @Override
        public void run(){
            ui.turnOffLED(3);
        }
    };

    public void onClick_Sleep(ContextClockradio context) {
        switch (c){
            case 0:
                sleep = 90;
                handler.removeCallbacks(toStandby);
                handler.postDelayed(sleepTimer,sleep*1000);
                handler.postDelayed(toStandby,5000);
                break;

            case 1:
                sleep = 60;
                handler.removeCallbacks(toStandby);
                handler.postDelayed(sleepTimer,sleep*1000);
                handler.postDelayed(toStandby,5000);
                break;

            case 2:
                sleep = 30;
                handler.removeCallbacks(toStandby);
                handler.postDelayed(sleepTimer,sleep*1000);
                handler.postDelayed(toStandby,5000);
                break;

            case 3:
                sleep = 15;
                handler.removeCallbacks(toStandby);
                handler.postDelayed(sleepTimer,sleep*1000);
                handler.postDelayed(toStandby,5000);
                break;
            case 4:
                handler.removeCallbacks(toStandby);
                handler.removeCallbacks(sleepTimer);
                handler.postDelayed(toStandby,5000);
                handler.post(toStandby);
                ui.setDisplayText("S OFF");
                break;
        }
        ui.setDisplayText(Integer.toString(sleep));
        c++;
    }
}
