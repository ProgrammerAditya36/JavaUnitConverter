package stdUnitConverter.modules;
import stdUnitConverter.UnitConverter;
public class MassConverter extends UnitConverter{
    public MassConverter(String request){
        super(request);
    }

public  double getRes(String  s){
    double res=1;
    switch(s){
        case "mg":{
        res=1.0/1000000;
        break;
        }
        case "dg":{
            res=1.0/10000;
            break;
        }
        case "cg":{
            res=1.0/100000;
            break;
        }
        case "g":{
            res=1.0/1000;
            break;
        }
        case "dag":{
            res=1.0/100;
            break;
        }
        case "hg":{
            res=1.0/10;
            break;
        }
        case "ton":{
            res=100;
            break;
        }
        case "lbs":{
            res=1.0/2.205;
            break;
        }
    }
    return res;
    }
}