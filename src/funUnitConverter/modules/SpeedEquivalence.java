package funUnitConverter.modules;
import funUnitConverter.FunConversions;
import stdUnitConverter.modules.*;
public class SpeedEquivalence extends FunConversions{
    String funSpeedchoices[] = {"humans","cheetah","earth orbitspeed","light","tortoise","electron"};
    public SpeedEquivalence(String choice,String magnitude,String userUnit){
        switch (getIndex(funSpeedchoices, choice)) {
            case 0:
                stdmg = 12;
                break;
            case 1:
                stdmg = 64;
                break;
            case 2:
                stdmg = 107000;
                break;
            case 3:
                stdmg = 1.07925285E9;
                break;
            case 4:
                stdmg = 1;
                break;
            case 5:
                stdmg = 2.16E7;
                break;
            default:
                break;

        }
        userMg = magnitude;
        this.userUnit = userUnit;
        this.choice = choice;
        uc = new SpeedConverter(userMg+"#"+userUnit+"#kmph");
    }    
}