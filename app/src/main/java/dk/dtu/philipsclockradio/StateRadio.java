package dk.dtu.philipsclockradio;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static dk.dtu.philipsclockradio.ContextClockradio.ui;
import static dk.dtu.philipsclockradio.Radio.checkFrequence;
import static java.lang.Math.random;

public class StateRadio extends StateAdapter {

    private ContextClockradio context;
    private int LEDnumber;


    @Override
    public void onEnterState(ContextClockradio context) {
        ui.toggleRadioPlaying(true);
        ui.setDisplayText(Character.toString(context.getRadio().getRadioType()) + "M" + context.getRadio().getFrequence());
        LEDnumber = 1;
    }

    @Override
    public void onClick_Power(ContextClockradio context) {
        context.getRadio().changeRadioType();
        ui.setDisplayText(Character.toString(context.getRadio().getRadioType()) + "M" + context.getRadio().getFrequence());
    }

    @Override
    public void onClick_Hour(ContextClockradio context) {
        context.getRadio().setFrequence(context.getRadio().getFrequence() - 1);
        checkFrequence(context);
        ui.setDisplayText(Character.toString(context.getRadio().getRadioType()) + "M" + Integer.toString(context.getRadio().getFrequence()));
    }

    @Override
    public void onClick_Min(ContextClockradio context) {
        context.getRadio().setFrequence(context.getRadio().getFrequence() + 1);
        checkFrequence(context);
        ui.setDisplayText(Character.toString(context.getRadio().getRadioType()) + "M" + Integer.toString(context.getRadio().getFrequence()));
    }

    @Override
    // Lavet enkelt med preset-eksempler. Har lidt bugs.
    public void onLongClick_Hour(ContextClockradio context) {
        ContextClockradio c = context;
        if (context.getRadio().getRadioType() == 'F') {
            if (c.getRadio().getFrequence() > c.getFM1().getFrequence()) {
                c.getRadio().setFrequence(c.getFM1().getFrequence());
            } else if (c.getRadio().getFrequence() > c.getFM2().getFrequence()) {
                c.getRadio().setFrequence(c.getFM2().getFrequence());
            } else if (c.getRadio().getFrequence() > c.getFM3().getFrequence()) {
                c.getRadio().setFrequence(c.getFM3().getFrequence());
            } else if (c.getRadio().getFrequence() > c.getFM4().getFrequence()) {
                c.getRadio().setFrequence(c.getFM4().getFrequence());
            } else if (c.getRadio().getFrequence() > c.getFM5().getFrequence()) {
                c.getRadio().setFrequence(c.getFM5().getFrequence());
            }
        }
        else if (context.getRadio().getRadioType() == 'A') {
            if (c.getRadio().getFrequence() > c.getAM1().getFrequence()) {
                c.getRadio().setFrequence(c.getAM1().getFrequence());
            } else if (c.getRadio().getFrequence() > c.getAM2().getFrequence()) {
                c.getRadio().setFrequence(c.getAM2().getFrequence());
            } else if (c.getRadio().getFrequence() > c.getAM3().getFrequence()) {
                c.getRadio().setFrequence(c.getAM3().getFrequence());
            } else if (c.getRadio().getFrequence() > c.getAM4().getFrequence()) {
                c.getRadio().setFrequence(c.getAM4().getFrequence());
            } else if (c.getRadio().getFrequence() > c.getAM5().getFrequence()) {
                c.getRadio().setFrequence(c.getAM5().getFrequence());
            }
        }
        ui.setDisplayText(Character.toString(context.getRadio().getRadioType()) + "M" + Integer.toString(context.getRadio().getFrequence()));
        }

    @Override
    public void onLongClick_Min(ContextClockradio context) {
        ContextClockradio c = context;
        if (context.getRadio().getRadioType() == 'F') {
            if (c.getRadio().getFrequence() < c.getFM1().getFrequence()) {
                c.getRadio().setFrequence(c.getFM1().getFrequence());
            } else if (c.getRadio().getFrequence() < c.getFM2().getFrequence()) {
                c.getRadio().setFrequence(c.getFM2().getFrequence());
            } else if (c.getRadio().getFrequence() < c.getFM3().getFrequence()) {
                c.getRadio().setFrequence(c.getFM3().getFrequence());
            } else if (c.getRadio().getFrequence() < c.getFM4().getFrequence()) {
                c.getRadio().setFrequence(c.getFM4().getFrequence());
            } else if (c.getRadio().getFrequence() < c.getFM5().getFrequence()) {
                c.getRadio().setFrequence(c.getFM5().getFrequence());
            }
        }
        else if (context.getRadio().getRadioType() == 'A') {
            if (c.getRadio().getFrequence() < c.getAM1().getFrequence()) {
                c.getRadio().setFrequence(c.getAM1().getFrequence());
            } else if (c.getRadio().getFrequence() < c.getAM2().getFrequence()) {
                c.getRadio().setFrequence(c.getAM2().getFrequence());
            } else if (c.getRadio().getFrequence() < c.getAM3().getFrequence()) {
                c.getRadio().setFrequence(c.getAM3().getFrequence());
            } else if (c.getRadio().getFrequence() < c.getAM4().getFrequence()) {
                c.getRadio().setFrequence(c.getAM4().getFrequence());
            } else if (c.getRadio().getFrequence() < c.getAM5().getFrequence()) {
                c.getRadio().setFrequence(c.getAM5().getFrequence());
            }
        }
        ui.setDisplayText(Character.toString(context.getRadio().getRadioType()) + "M" + Integer.toString(context.getRadio().getFrequence()));
    }

    @Override
    public void onLongClick_Preset(ContextClockradio context) {
        if(LEDnumber != 1){
            ui.turnOffLED(LEDnumber - 1);
        } else {
            ui.turnOffLED(5);
            ui.turnOffLED(1);

        }
        ui.turnOnLED(LEDnumber);
        if(!(Character.toString(context.getPresets(LEDnumber).getRadioType()).equals(Character.toString((context.getRadio().getRadioType()))))){
            context.getRadio().changeRadioType();
        }
        context.getRadio().setFrequence(context.getPresets(LEDnumber).getFrequence());
        ui.setDisplayText(context.getRadio().getRadioType() + Integer.toString(context.getRadio().getFrequence()));
        LEDnumber++;
        if(LEDnumber == 6){
            LEDnumber = 1;
        }
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
}
