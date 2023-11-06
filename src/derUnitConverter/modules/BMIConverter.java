package derUnitConverter.modules;


import derUnitConverter.DerivedUnits;
import stdUnitConverter.modules.LengthConverter;
import stdUnitConverter.modules.MassConverter;

public class BMIConverter extends DerivedUnits{
    
    public BMIConverter(double mass,double length,String mu, String lu){
        this.mg1 = new MassConverter(mass+"#"+mu+"#kg").convert();
        this.mg2 = new LengthConverter(length+"#"+lu+"#m").convert();
    }
    public BMIConverter(String mass, String mu, String length, String lu){
        this.mg1 = new MassConverter(mass+"#"+mu+"#kg").convert();
        this.mg2 = new LengthConverter(length+"#"+lu+"#m").convert();
        
    }
    public void convert(){
       
        val = mg1/(mg2*mg2);

    }
    public String toString(){
        return "Your BMI is:-"+val;
    }
   


}
