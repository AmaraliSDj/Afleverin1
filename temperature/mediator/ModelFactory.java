package temperature.mediator;

import temperature.mediator.TemperatureModel;
import temperature.mediator.TemperatureModelManager;

public class ModelFactory {

    private TemperatureModel temperatureModel;

    public TemperatureModel getTemperatureModel() {
        if(temperatureModel == null) {
            temperatureModel = new TemperatureModelManager();
        }
        return temperatureModel;
    }

}
