package dk.dtu.philipsclockradio;

import static dk.dtu.philipsclockradio.ContextClockradio.ui;

public class StateAlarm2 extends StateAdapter {
    int alarmID;
    State previousState;

    public void StateAlarm(int alarmID, State previousState){
        this.alarmID = alarmID;
        this.previousState = previousState;
    }

    @Override
    public void onEnterState(ContextClockradio context) {
        alarmID = 2;
        ui.turnOnTextBlink();
        ui.setDisplayText(context.getAlarm(alarmID).getAlarmDisplay());
    }

    @Override
    public void onClick_Hour(ContextClockradio context) {
       context.getAlarm(alarmID).setAlarmTimeSec(context.getAlarm(alarmID).getAlarmTimeSec() + 3600000);
       ui.setDisplayText(context.getAlarm(alarmID).getAlarmDisplay());
    }

    @Override
    public void onClick_Min(ContextClockradio context) {
        context.getAlarm(alarmID).setAlarmTimeSec(context.getAlarm(alarmID).getAlarmTimeSec() + 60000);
        ui.setDisplayText(context.getAlarm(alarmID).getAlarmDisplay());
    }

    @Override
    public void onLongClick_AL1(ContextClockradio context) {
        context.getAlarm(alarmID).setTime(context.getAlarm(alarmID).getTime());
        ui.setDisplayText(context.getAlarm(alarmID).getAlarmDisplay());
    }

    @Override
    public void onLongClick_AL2(ContextClockradio context) {
        context.getAlarm(alarmID).setTime(context.getAlarm(alarmID).getTime());
        ui.setDisplayText(context.getAlarm(alarmID).getAlarmDisplay());
    }

    @Override
    public void onClick_AL1(ContextClockradio context) {
        ui.setDisplayText(context.getAlarm(alarmID).getAlarmDisplay());
        context.setState(new StateStandby(context.getTime()));
    }

    @Override
    public void onClick_AL2(ContextClockradio context) {
        ui.setDisplayText(context.getAlarm(alarmID).getAlarmDisplay());
        context.setState(new StateStandby(context.getTime()));
    }

    @Override
    public void onExitState(ContextClockradio context) {
        ui.turnOffTextBlink();
    }
}

