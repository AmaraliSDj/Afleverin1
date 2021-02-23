import com.sun.webkit.Timer;
import javafx.application.Application;
import javafx.stage.Stage;
import temperature.ViewModelFactory;
import temperature.mediator.ModelFactory;
import temperature.mediator.TemperatureModel;
import temperature.mediator.TemperatureModelManager;
import temperature.view.ViewHandler;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {

    // Model
    ModelFactory mfs = new ModelFactory();
    ViewModelFactory vmf = new ViewModelFactory(mfs);
    ViewHandler view = new ViewHandler(vmf);
    view.start(primaryStage);

    // Termometer
    Thread t1 = new Thread(new Termometer(mfs.getTemperatureModel(),"0", 2, 1));
    Thread t2 = new Thread(new Termometer(mfs.getTemperatureModel(), "1", 2, 7));
    Thread t3 = new Thread(new Termometer(mfs.getTemperatureModel(), "2",2,4));
    t1.start();
    t2.start();
    t3.start();
  }
}
