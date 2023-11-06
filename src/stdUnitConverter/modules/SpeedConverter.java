package stdUnitConverter.modules;
import stdUnitConverter.UnitConverter;
public class SpeedConverter extends UnitConverter {
    public SpeedConverter(String request){
        super(request);
    }
    public double getRes(String s){
        double base=1;
         if(s.equalsIgnoreCase("mps")) base=1;
        if(s.equalsIgnoreCase("kmph")) base=5/18d;
        if(s.equalsIgnoreCase("miph")) base=.44704;
        if(s.equalsIgnoreCase("ypm")) base=0.01524;
        if(s.equalsIgnoreCase("fps")) base=0.3048;
        if(s.equalsIgnoreCase("mach")) base=343;
        if(s.equalsIgnoreCase("knots")) base=463/900d;
        return base;
    }
}