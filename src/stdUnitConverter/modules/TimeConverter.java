package stdUnitConverter.modules;

import stdUnitConverter.UnitConverter;

public class TimeConverter extends UnitConverter{
    public TimeConverter(String request){
        super(request);
    }


    public double getRes(String s) {
        double res=1;
        switch (s) {
            case "min": {
                res = 60;
                break;
            }
            case "hrs": {
                res = 3600;
                break;
            }
            case "day": {
                res = 24*3600;
                break;
            }
            case "week": {
                res = 24*7*3600;
                break;
            }
            case "month" :{
                res = (double) (24 * 365 * 3600) /12;
                break;
            }
            case "year" :{
                res = 24*365*3600;
                break;
            }

        }
        return res;
    }

}