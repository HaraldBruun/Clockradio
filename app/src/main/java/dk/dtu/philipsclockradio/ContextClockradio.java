package dk.dtu.philipsclockradio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//
public class ContextClockradio {
    private State currentState;
    private Date time;
    private String displayText;
    public boolean isClockRunning = false;
    private Radio radio, FM1, FM2, FM3, FM4, FM5, AM1, AM2, AM3, AM4, AM5, PS1, PS2, PS3, PS4, PS5;
    private List<Radio> presets = new ArrayList<Radio>();
    private Alarm alarm_1, alarm_2, alarmSet;

    public static MainUI ui;

    public ContextClockradio(MainUI context){
        ui = context;

        //Sætter tiden til 12.00, hvis tiden ikke er sat endnu
        if(time == null){
            Calendar date = Calendar.getInstance();
            date.set(2019, 1, 1, 12, 00);
            time = date.getTime();
        }
        // Opretter radio-objekt
        radio = new Radio();
        radio.setFrequence(42);
        radio.setRadioType('F');
        radioPresets();
        presetAlarm();


        //Når app'en starter, så går vi ind i Standby State
        currentState = new StateStandby(time);
        currentState.onEnterState(this);
    }

    //setState er når vi skifter State
    void setState(final State newState) {
        currentState.onExitState(this);
        currentState = newState;
        currentState.onEnterState(this);
        System.out.println("Current state: "+ newState.getClass().getSimpleName());
    }

    //Opdaterer kontekst time state og UI
    void setTime(Date time){
        this.time = time;
        if(currentState.getClass().getSimpleName().equals("StateStandby")){
            updateDisplayTime();
        }
    }


    void updateDisplayTime(){
        displayText = time.toString().substring(11,16);
        ui.setDisplayText(displayText);
    }

    public void radioPresets(){
        FM1 = new Radio(); FM1.setRadioType('F'); FM1.setFrequence(20);
        FM2 = new Radio(); FM2.setRadioType('F'); FM2.setFrequence(40);
        FM3 = new Radio(); FM3.setRadioType('F'); FM3.setFrequence(60);
        FM4 = new Radio(); FM4.setRadioType('F'); FM4.setFrequence(80);
        FM5 = new Radio(); FM5.setRadioType('F'); FM5.setFrequence(100);

        AM1 = new Radio(); AM1.setRadioType('A'); AM1.setFrequence(20);
        AM2 = new Radio(); AM2.setRadioType('A'); AM2.setFrequence(40);
        AM3 = new Radio(); AM3.setRadioType('A'); AM3.setFrequence(60);
        AM4 = new Radio(); AM4.setRadioType('A'); AM4.setFrequence(80);
        AM5 = new Radio(); AM5.setRadioType('A'); AM5.setFrequence(100);

        presets.add(FM1);
        presets.add(FM2);
        presets.add(FM3);
        presets.add(FM4);
        presets.add(FM5);

        presets.add(AM1);
        presets.add(AM2);
        presets.add(AM3);
        presets.add(AM4);
        presets.add(AM5);

        PS1 = new Radio(); PS1.setRadioType('F'); PS1.setFrequence(85);
        PS2 = new Radio(); PS2.setRadioType('A'); PS2.setFrequence(30);
        PS3 = new Radio(); PS3.setRadioType('F'); PS3.setFrequence(36);
        PS4 = new Radio(); PS4.setRadioType('A'); PS4.setFrequence(99);
        PS5 = new Radio(); PS5.setRadioType('A'); PS5.setFrequence(18);
    }

    public Alarm getAlarm(int ID){
        if (ID == 1) {
            return alarm_1;
        }
        else if (ID == 2) {
            return alarm_2;
        }
        else return alarmSet;
    }


    public Radio getFM1() { return FM1; }

    public Radio getFM2() { return FM2; }

    public Radio getFM3() { return FM3; }

    public Radio getFM4() { return FM4; }

    public Radio getFM5() { return FM5; }

    public Radio getAM1() { return AM1; }

    public Radio getAM2() { return AM2; }

    public Radio getAM3() { return AM3; }

    public Radio getAM4() { return AM4; }

    public Radio getAM5() { return AM5; }

    public Radio getPS1() {  return PS1; }

    public void setPS1(Radio PS1) {this.PS1 = PS1;}

    public Radio getPS2() {return PS2;}

    public void setPS2(Radio PS2) {this.PS2 = PS2;}

    public Radio getPS3() {return PS3;}

    public void setPS3(Radio PS3) {this.PS3 = PS3;}

    public Radio getPS4() {return PS4;}

    public void setPS4(Radio PS4) {this.PS4 = PS4;}

    public Radio getPS5() {return PS5;}

    public void setPS5(Radio PS5) {this.PS5 = PS5;}

    public Radio getPresets(int ps){
        Radio radio = new Radio();
        switch (ps){
            case 1:
                radio = PS1;
                break;
            case 2:
                radio = PS2;
                break;
            case 3:
                radio = PS3;
                break;
            case 4:
                radio = PS4;
                break;
            case 5:
                radio = PS5;
            default:
                break;
        }
        return radio;
    }

    public void presetAlarm(){
        Calendar alarmPreset = Calendar.getInstance();
        alarmPreset.set(2019,1,1,12,0);
        alarm_1 = new Alarm(alarmPreset.getTime());
        alarm_2 = new Alarm(alarmPreset.getTime());
        alarmSet = new Alarm(alarmPreset.getTime());
    }
    public List<Radio> getPresets() {
        return presets;
    }
    public State getCurrentState() {
        return currentState;
    }

    public Radio getRadio(){
        return radio;
    }

    public Date getTime(){
        return time;
    }

    //Disse metoder bliver kaldt fra UI tråden
    public void onClick_Hour() {
        currentState.onClick_Hour(this);
    }

    public void onClick_Min() {
        currentState.onClick_Min(this);
    }

    public void onClick_Preset() {
        currentState.onClick_Preset(this);
    }

    public void onClick_Power() {
        currentState.onClick_Power(this);

    }

    public void onClick_Sleep() {
        currentState.onClick_Sleep(this);
    }

    public void onClick_AL1() {
        currentState.onClick_AL1(this);
    }

    public void onClick_AL2() {
        currentState.onClick_AL2(this);
    }

    public void onClick_Snooze() {
        currentState.onClick_Snooze(this);
    }

    public void onLongClick_Hour(){
        currentState.onLongClick_Hour(this);
    }

    public void onLongClick_Min(){
        currentState.onLongClick_Min(this);
    }

    public void onLongClick_Preset(){
        currentState.onLongClick_Preset(this);
    }

    public void onLongClick_Power(){
        currentState.onLongClick_Power(this);
    }

    public void onLongClick_Sleep(){
        currentState.onLongClick_Sleep(this);
    }

    public void onLongClick_AL1(){
        currentState.onLongClick_AL1(this);
    }

    public void onLongClick_AL2(){
        currentState.onLongClick_AL2(this);
    }

    public void onLongClick_Snooze(){
        currentState.onLongClick_Snooze(this);
    }
}