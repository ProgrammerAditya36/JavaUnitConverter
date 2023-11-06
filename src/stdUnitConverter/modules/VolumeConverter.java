package stdUnitConverter.modules;
import stdUnitConverter.UnitConverter;
public class VolumeConverter extends UnitConverter{
    public VolumeConverter(String request){
        super(request);
    }

    public double getRes(String s) {
        double res=1;
        switch (s) {
            case "gal": {
                res = 1 / 264.172;
                break;
            }
            case "lit": {
                res = 0.001;
                break;
            }
            case "cf": {
                res = 1 / 35.3147;
                break;
            }
            case "ci": {
                res = 1 / 61023.7;
                break;
            }
            case "ml": {
                res = 1.0 / 1000000;
                break;
            }
            case "flo": {
                res = 1 / 33813.96;
                break;
            }
            case "qui":{
                res = 1 / 1056.69;
                break;
            }
        }
        return res;
    }

}