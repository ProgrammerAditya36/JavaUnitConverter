package stdUnitConverter.modules;
import stdUnitConverter.UnitConverter;
public class AngleConverter extends UnitConverter{
    public AngleConverter(String request){
        super(request);
    }

public  double getRes(String  s){
    double res=1;
    switch(s){
        case "min":{
        res=1.0/60;
        break;
        }
        case "sec":{
            res=1.0/3600;
            break;
        }
        case "rad":{
            res=(180/Math.PI);
            break;
        }
        case "rev":{
            res=360;
            break;
        }
    }
    return res;
    }
}