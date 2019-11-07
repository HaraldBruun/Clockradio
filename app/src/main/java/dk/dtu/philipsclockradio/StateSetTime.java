package dk.dtu.philipsclockradio;

import java.util.Date;


public class StateSetTime extends StateAdapter {
    Date time;

    StateSetTime(){}

    @Override
    public void onEnterState(ContextClockradio context) {
        time = context.getTime();
        context.ui.turnOnTextBlink();
        context.updateDisplayTime();
    }

    @Override
    public void onExitState(ContextClockradio context) {
        context.ui.turnOffTextBlink();
    }

    @Override
    public void onClick_Hour(ContextClockradio context) {
        //Gets current timestamp (Date)
        time.setTime(time.getTime() + 3600000);
        context.setTime(time);
        context.updateDisplayTime();
    }

    @Override
    public void onClick_Min(ContextClockradio context) {
        //Gets current timestamp (Date)
        time.setTime(time.getTime() + 60000);
        context.setTime(time);
        context.updateDisplayTime();
    }

    @Override
    public void onClick_Preset(ContextClockradio context) {
        context.setState(new StateStandby(context.getTime()));
    }

}
