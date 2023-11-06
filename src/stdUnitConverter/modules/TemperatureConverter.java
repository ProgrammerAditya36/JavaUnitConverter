package stdUnitConverter.modules;
import stdUnitConverter.UnitConverter;
public class TemperatureConverter extends UnitConverter  {
    public TemperatureConverter(String request){
        super(request);
        addqty = addqtyget();
    }
    public double getRes(String s){
        double res = 1.0; 
            switch (s) {
            case "celsius" :{
                res=1;
                break;
            }
            case "fahrenheit" :{
                res=5.0/9;
                break;
            }
            case "kelvin" :{
                res=1;
                break;
            }
            case "rankin" : {
                res= 5.0/9;
                break;
            }
            default :{
                res=1.0;
                break;
            }
        };
        return res;
    }
    public double addqtyget(){
        double add= 0.0;
        if(fr.equals("celsius")){
            switch(to){
                case "fahrenheit" : {add = 32; break;}
                case "kelvin": {add = 273.15; break;}
                case "rankin": {add = 491.67; break;}
            }
        }
        else if ( fr.equals("fahrenheit")){
            switch(to){
                case "celsius" : {add = -160.0/9; break;}
                case "kelvin": {add = 2298.35/9; break;}
                case "rankin": {add = 459.67; break;}
            }
        }
        else if( fr.equals("kelvin")){
            switch(to){
                 case "fahrenheit" : {add = -459.67; break;}
                case "celsius":{ add = -273.15; break;}
                case "rankin": {add =0.0; break;}
            }
        }
        else if( fr.equals("rankin")){
            switch(to){
                 case "fahrenheit" : {add = -459.67; break;}
                case "celsius":{ add = -273.15; break;}
                case "kelvin":{ add =0.0; break;}
            }
        }   return add;
    }

}