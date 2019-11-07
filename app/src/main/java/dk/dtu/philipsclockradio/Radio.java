package dk.dtu.philipsclockradio;

public class Radio {
    private int frequence;
    private char radioType;

    public void radioSetup(){
        radioType = 'F';
        frequence = 21;
    }
    public void changeRadioType(){
        if (this.radioType == 'F'){
            setRadioType('A');
            setFrequence(42);
        }
        else if (this.radioType == 'A'){
            setRadioType('F');
            setFrequence(21);
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
}
