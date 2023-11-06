package funUnitConverter.modules;
import funUnitConverter.FunConversions;
import stdUnitConverter.modules.*;
public class LengthEquivalence extends FunConversions{
    String funLengthchoices[] = {"humans","ruler","tree","football stadium","earths","hydrogen atom"};

    public LengthEquivalence(String choice,String magnitude,String userUnit){
        switch (getIndex(funLengthchoices, choice)) {
            case 0:
                stdmg = 1.7;
                break;
            case 1:
                stdmg = 0.15;
                break;
            case 2:
                stdmg = 12.192;
                break;
            case 3:
                stdmg = 109.728;
                break;
            case 4:
                stdmg = 4.0075E7;
                break;
            case 5:
                stdmg = 4E-11;
                break;
            default:
                break;

        }
        userMg = magnitude;
        this.userUnit = userUnit;
        this.choice = choice;
        uc = new LengthConverter(userMg+"#"+userUnit+"#m");
    }

}
