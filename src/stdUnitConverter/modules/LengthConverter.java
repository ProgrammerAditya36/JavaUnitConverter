package stdUnitConverter.modules;
import stdUnitConverter.UnitConverter;
public class LengthConverter extends UnitConverter {
    public LengthConverter(String request){
        super(request);
    }
    public double getRes(String s){
        double base=1;
        if(s.equalsIgnoreCase("km")) base=1000;
        else if(s.equalsIgnoreCase("mi")) base=1809.344;
        else if(s.equalsIgnoreCase("y")) base=0.9144;
        else if(s.equalsIgnoreCase("ft")) base=0.3048;
        else if(s.equalsIgnoreCase("in")) base=0.0254;
        else if(s.equalsIgnoreCase("mm")) base=0.001;
        else if(s.equalsIgnoreCase("cm")) base=0.01;
        else if(s.equalsIgnoreCase("dm")) base=0.1;
        else if(s.equalsIgnoreCase("mum")) base=1E-6;
        else if(s.equalsIgnoreCase("pm")) base=1E-12;
        else if(s.equalsIgnoreCase("nmi")) base=1852;
        else if(s.equalsIgnoreCase("pc")) base=3.0856775E+16;
        else if(s.equalsIgnoreCase("au")) base=1.4959E+11;
        else if(s.equalsIgnoreCase("ly")) base=9.4607E+15;
        return base;
    }
}