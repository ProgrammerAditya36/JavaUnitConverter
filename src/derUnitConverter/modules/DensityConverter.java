package derUnitConverter.modules;
import derUnitConverter.DerivedUnits;
import stdUnitConverter.modules.MassConverter;
import stdUnitConverter.modules.VolumeConverter;


public class DensityConverter extends DerivedUnits{       
    public DensityConverter(double mass, double volume, String mu,String vu){
        mg1 = new MassConverter(mass+"#"+mu+"#kg").convert();
        mg2 = new VolumeConverter(volume+"#"+vu+"#m").convert();
    }
    public DensityConverter(String mass, String mu, String volume,String vu){
        mg1 = new MassConverter(mass+"#"+mu+"#kg").convert();
        mg2 = new VolumeConverter(volume+"#"+vu+"#m").convert();       
    }
    public void convert(){

        val = mg1/(1000*mg2);
    }
    public String toString(){
        return "Relative Density: "+val;
    }
    
}
