package dk.dtu.philipsclockradio;

import static dk.dtu.philipsclockradio.ContextClockradio.ui;

public class StateRadio extends StateAdapter {

    private ContextClockradio context;
    private int LEDnumber;
    private Radio FM1, FM2, FM3, FM4, FM5, AM1, AM2, AM3, AM4, AM5;

    @Override
    public void onEnterState(ContextClockradio context){
        ui.toggleRadioPlaying(true);
        ui.setDisplayText(context.getRadio().getRadioType());



        if (context.getRadio().getRadioType() == 'F') {
            ui.setDisplayText("FM" + Integer.toString(context.getRadio().getFrequence()));
        }
        else if (context.getRadio().getRadioType() == 'A'){
            ui.setDisplayText("AM" + Integer.toString(context.getRadio().getFrequence()));
            }
        LEDnumber = 1;
        radioPresets();
        }


    @Override
    public void onLongClick_Power(ContextClockradio context) {
        context.setState(new StateStandby(context.getTime()));
    }

    @Override
    public void onExitState(ContextClockradio context) {
        super.onExitState(context);
        ui.turnOffLED(1);
        ui.toggleRadioPlaying(false);
        context.updateDisplayTime();
    }
    public void radioPresets(){
        FM1 = new Radio(); FM1.setRadioType('F'); FM1.setFrequence(20);
        FM2 = new Radio(); FM2.setRadioType('F'); FM2.setFrequence(40);
        FM3 = new Radio(); FM3.setRadioType('F'); FM3.setFrequence(60);
        FM4 = new Radio(); FM4.setRadioType('F'); FM4.setFrequence(80);
        FM5 = new Radio(); FM5.setRadioType('F'); FM5.setFrequence(100);

        AM1 = new Radio(); AM1.setRadioType('A'); AM1.setFrequence(20);
        AM2 = new Radio(); AM2.setRadioType('A'); AM2.setFrequence(20);
        AM3 = new Radio(); AM3.setRadioType('A'); AM3.setFrequence(20);
        AM4 = new Radio(); AM4.setRadioType('A'); AM4.setFrequence(20);
        AM5 = new Radio(); AM5.setRadioType('A'); AM5.setFrequence(20);
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
}
