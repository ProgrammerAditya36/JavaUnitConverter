package funUnitConverter.modules;
import funUnitConverter.FunConversions;
import stdUnitConverter.modules.*;
public class WeightEquivalence extends FunConversions{
    String funWeigthtchoices[] = {"humans","dogs","suns","tigers","earths","hydrogen atom"};
    String stdwtunit="Kg";
    public WeightEquivalence(String choice,String magnitude,String userUnit){
        switch (getIndex(funWeigthtchoices, choice)) {
            case 0:
                stdmg = 60;
                break;
            case 1:
                stdmg = 20;
                break;            
            case 2:
                stdmg = 1.989E30;
                break;
            case 3:
                stdmg = 200;
                break;
            case 4:
                stdmg = 5.972E24;
                break;
            case 5:
                stdmg = 1.674E-27;
                break;
            default:
                break;
            
        }
        userMg = magnitude;
        this.userUnit = userUnit;
        this.choice = choice;
        uc = new MassConverter(userMg+"#"+userUnit+"#kg");
    }

}
