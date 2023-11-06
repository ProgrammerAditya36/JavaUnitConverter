package converterThreads;
import stdUnitConverter.*;
import stdUnitConverter.modules.*;
public class stdUnitThread extends Thread {

  public UnitConverter uc;
  String inp;

  public stdUnitThread(int choice, String inp) {
    switch (choice) {
      case 1:
        {
          uc = new MassConverter(inp);
          break;
        }
      case 2:
        {
          uc = new TimeConverter(inp);
          break;
        }
      case 3:
        {
          uc = new AngleConverter(inp);
          break;
        }
      case 4:
        {
          uc = new AreaConverter(inp);
          break;
        }
      case 5:
        {
          uc = new DataConverter(inp);
          break;
        }
      case 6:
        {
          uc = new LengthConverter(inp);
          break;
        }
      case 7:
        {
          uc = new SpeedConverter(inp);
          break;
        }
      case 8:
        {
          uc = new TemperatureConverter(inp);
          break;
        }
      case 9:
        {
          uc = new VolumeConverter(inp);
          break;
        }
      default:
        {
          uc = new MassConverter("1#kg#kg");
          break;
        }
    }
  }

  public void run() {
    uc.convert();
  }
}
