package stdUnitConverter.modules;
import stdUnitConverter.UnitConverter;
public class AreaConverter extends UnitConverter {
    public AreaConverter(String request){
        super(request);
    }
    public double getRes(String s){
        double base;
        switch (s) {
            case "sqm": { // square meter
                base = 1;
                break;
            }
            case "sqin" : {// square inch
                base= 0.00064516;
                break;
            }
            case "sqft" : { // square feet
                base = 0.09290304;
                break;
            }
            case "sqkm" : {// square kilometer
                base = 1000000;
                break;
            }
            case "sqcm" :{ // square centimeter
                  base=  0.0001;
                  break;
            }
            case "sqmm" : { // square millimeter
                base = 1.0E-6;
                break;
            }
            case "sqyd" : {// square yard
                base = 0.83612736;
                break;
            }
            case "sqmi" : {// square mile
                base = 2589988.11;
                break;
            }
            case "acre" : {// acre
                base = 4046.85642;
                break;
            }
            case "hectare" : {//hectare
                base = 10000;
                break;
            }
            default : {
                base = 1.0;
                break;
            }
            }
            return base;
        }
    }
