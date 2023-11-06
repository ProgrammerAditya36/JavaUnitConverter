package funUnitConverter;
import stdUnitConverter.*;
public class FunConversions{
    public UnitConverter uc;
    public double stdmg;
    public String choice;
    public String userMg,userUnit;
    double res;
    public String toString(){
        convert();
        return userMg+" "+userUnit+" equals "+res/stdmg+" "+choice;
    }
    public int getIndex(String arr[], String ele){
        for (int i=0;i<arr.length;i++){
            if(arr[i].equals(ele)){
                return i;
            }
        }
        return -1;
    }
    public void convert(){
        res = uc.convert();
    }
}



