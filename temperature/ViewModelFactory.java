package temperature;

import temperature.mediator.ModelFactory;
import temperature.view.TemperaturViewModel;
import temperature.view.TemperaturViewModel2;

public class ViewModelFactory {

    private TemperaturViewModel temperaturViewModel;
    private TemperaturViewModel2 temperaturViewModel2;

    public ViewModelFactory(ModelFactory vmf) {
        temperaturViewModel = new TemperaturViewModel(vmf.getTemperatureModel());
        temperaturViewModel2 = new TemperaturViewModel2(vmf.getTemperatureModel());
    }

    public TemperaturViewModel getTemperaturViewModel() {
        return temperaturViewModel;
    }

    public TemperaturViewModel2 getTemperaturViewModel2() {
        return temperaturViewModel2;
    }


}
