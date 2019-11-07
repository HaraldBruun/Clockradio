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
    private boolean firstTime = true;


    @Override
    public void onEnterState(ContextClockradio context) {
        ui.toggleRadioPlaying(true);
        ui.setDisplayText(Character.toString(context.getRadio().getRadioType()) + "M" + context.getRadio().getFrequence());
        LEDnumber = 1;
        ui.shutdownLED();
        ui.turnOnLED(LEDnumber);
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
    // Lavet scanner med onLongClick på hour og min, scanner op- og nedad.
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
        //Log.d(Integer.toString(LEDnumber), "onLongClick_Preset: ");
        if (firstTime){
            ui.turnOnLEDBlink(LEDnumber);
            firstTime = false;
            // Der er en mindre bug her, er der resulterer i at displayText ikke ændrer sig hensigtsmæssigt.
        }
        else LEDnumber++;
        ui.shutdownLED();
        ui.turnOffLEDBlink();
        ui.turnOnLEDBlink(LEDnumber);
         if (LEDnumber == 1) {
             context.getRadio().setRadioType(context.getPS1().getRadioType());
             context.getRadio().setFrequence(context.getPS1().getFrequence());
             ui.setDisplayText(Character.toString(context.getPS1().getRadioType()) + "M" + context.getPS1().getFrequence());
        } else if (LEDnumber == 2) {
             context.getRadio().setRadioType(context.getPS2().getRadioType());
             context.getRadio().setFrequence(context.getPS2().getFrequence());
             ui.setDisplayText(Character.toString(context.getPS2().getRadioType()) + "M" + context.getPS2().getFrequence());
        } else if (LEDnumber == 3) {
             context.getRadio().setRadioType(context.getPS3().getRadioType());
             context.getRadio().setFrequence(context.getPS3().getFrequence());
             ui.setDisplayText(Character.toString(context.getPS3().getRadioType()) + "M" + context.getPS3().getFrequence());
        } else if (LEDnumber == 4) {
             context.getRadio().setRadioType(context.getPS4().getRadioType());
             context.getRadio().setFrequence(context.getPS4().getFrequence());
             ui.setDisplayText(Character.toString(context.getPS4().getRadioType()) + "M" + context.getPS4().getFrequence());
        } else if (LEDnumber == 5) {
             context.getRadio().setRadioType(context.getPS5().getRadioType());
             context.getRadio().setFrequence(context.getPS5().getFrequence());
             ui.setDisplayText(Character.toString(context.getPS5().getRadioType()) + "M" + context.getPS5().getFrequence());
            LEDnumber = 0;
        }
    }

    @Override
    public void onClick_Preset(ContextClockradio context) {
        ui.turnOffLEDBlink();
        ui.turnOnLED(LEDnumber);
        firstTime = true;
        if (LEDnumber == 1) {
            context.setPS1(context.getRadio());
        } else if (LEDnumber == 2) {
            context.setPS2(context.getRadio());
        } else if (LEDnumber == 3) {
            context.setPS3(context.getRadio());
        } else if (LEDnumber == 4) {
            context.setPS4(context.getRadio());
        } else if (LEDnumber == 5) {
            context.setPS5(context.getRadio());
            LEDnumber = 0;
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
