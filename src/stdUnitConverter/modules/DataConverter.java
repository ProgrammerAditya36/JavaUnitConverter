package stdUnitConverter.modules;
import stdUnitConverter.UnitConverter;
public class DataConverter extends UnitConverter {
    public DataConverter(String request){
        super(request);
    }
    public double getRes(String s){
        double base=1;
        if(s.equalsIgnoreCase("byt")) {
            base=Math.pow(2,3);
        }
        if(s.equalsIgnoreCase("kb")) {
            base=Math.pow(2,13);
        }
        if(s.equalsIgnoreCase("mb")) {
            base=Math.pow(2,23);
        }
        if(s.equalsIgnoreCase("gb")) {
            base=Math.pow(2,33);
        }
        if(s.equalsIgnoreCase("tb")) {
            base=Math.pow(2,43);
        }
        if(s.equalsIgnoreCase("pb")) {
            base=Math.pow(2,53);
        }
        if(s.equalsIgnoreCase("eb")) {
            base=Math.pow(2,63);
        }
        return base;
    }
}