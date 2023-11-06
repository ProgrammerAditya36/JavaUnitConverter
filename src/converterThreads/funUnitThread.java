package converterThreads;
import funUnitConverter.*;
import funUnitConverter.modules.*;
public class funUnitThread extends Thread{
  public FunConversions funConversions;
  public funUnitThread(int c, String choice, String magnitude, String userUnit){
    switch (c){
      case 1:{
        funConversions = new WeightEquivalence(choice, magnitude, userUnit);
        break;
      }
      case 2:{
        funConversions = new LengthEquivalence(choice, magnitude, userUnit);
        break;
      }
      case 3:{
        funConversions = new SpeedEquivalence(choice, magnitude, userUnit);
      }
    }

  }
  public void run(){
    funConversions.convert();
  }
}