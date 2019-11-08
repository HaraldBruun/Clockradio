package dk.dtu.philipsclockradio;

public class Radio {
    private int frequence;
    private char radioType;
    private boolean isPlaying;

    public void Radio(char radioType, int frequence){
        this.radioType = radioType;
        this.frequence = frequence;
    }
    public void changeRadioType(){
        if (this.radioType == 'F'){
            setRadioType('A');
        }
        else if (this.radioType == 'A'){
            setRadioType('F');
        }
    }

    public int getFrequence() { return frequence; }

    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }

    public char getRadioType() {
        return radioType;
    }

    public void setRadioType(char radioType) {
        this.radioType = radioType;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public static void checkFrequence(ContextClockradio context) {
        if (context.getRadio().getFrequence() >= 100) {
            context.getRadio().setFrequence(1);
        } else if (context.getRadio().getFrequence() <= 0) {
            context.getRadio().setFrequence(99);
        }
    }

}
