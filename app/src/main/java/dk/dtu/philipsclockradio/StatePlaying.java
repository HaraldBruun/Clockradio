package dk.dtu.philipsclockradio;

import static dk.dtu.philipsclockradio.ContextClockradio.ui;

public class StatePlaying extends StateAdapter{
    private int alarmID;
    private State previousState;

    public StatePlaying (int alarmID, State previousState){
        this.alarmID = alarmID;
        this.previousState = previousState;
    }

    @Override
    public void onEnterState(ContextClockradio context) {
        ui.setDisplayText(context.getAlarm(alarmID).getAlarmDisplay());
        ui.turnOnTextBlink();
        if (context.getAlarm(alarmID).isPlaying()){
            ui.toggleRadioPlaying(true);
        } else if (context.getRadio().isPlaying()) {
            ui.toggleAlarmPlaying(true);
        }
    }

    @Override
    public void onClick_AL1(ContextClockradio context) {
        context.getAlarm(1).setActive(false);
        ui.toggleAlarmPlaying(false);
        ui.shutdownLED();
    }

    @Override
    public void onClick_AL2(ContextClockradio context) {
        context.getAlarm(2).setActive(false);
        ui.toggleAlarmPlaying(false);
        ui.shutdownLED();
    }

}
