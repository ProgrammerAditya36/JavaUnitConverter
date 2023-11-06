package stdUnitConverter;
public class UnitConverter implements Functions{
  public String request,fr,to;
  public double val,ratio,addqty,result;
  public UnitConverter(String request){
    this.request = request;
    String[] a = request.split("#");
    val = Double.parseDouble(a[0]);
    fr = a[1];
    to = a[2];
    addqty = 0;
  }
    public double getRat(){
        double base=1, res=1;
        base = getRes(fr);
        res = getRes(to);
        return base/res;
    }


   public double convert(){
        result = val*getRat()+addqty;
        return result;
    }
    public String toString(){
      return val+ fr +" = "+convert()+to;
    }

    public double getRes(String s) {
        return 0;
    }
   
}