package converterThreads;
import derUnitConverter.*;
import derUnitConverter.modules.*;
public class derUnitThread implements Runnable {

  public DerivedUnits du;
  public Thread t;

  public derUnitThread(int choice, String mg1, String mu1, String mg2, String mu2) {
    t = new Thread(this);
    switch (choice) {
      case 1:
        {
          du = new BMIConverter(mg1, mu1, mg2, mu2);
          break;
        }
      case 2:
        {
          du = new DensityConverter(mg1, mu1, mg2, mu2);
          break;
        }
      default:
        {
          break;
        }
    }
    t.start();
  }
  public derUnitThread(int choice, double mg1, double mg2, String mu1, String mu2) {
    t = new Thread(this);
    switch (choice) {
      case 1:
        {
          du = new BMIConverter(mg1, mg2, mu1, mu2);
          break;
        }
      case 2:
        {
          du = new DensityConverter(mg1, mg2, mu1, mu2);
          break;
        }
      default:
        {
          break;
        }
    }
    t.start();
  }

  public void run() {
    du.convert();
  }
}