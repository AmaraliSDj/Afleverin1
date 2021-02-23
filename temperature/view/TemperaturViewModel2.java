package temperature.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import temperature.mediator.TemperatureModel;
import temperature.model.TemperatureList;

public class TemperaturViewModel2 {

    private final TemperatureModel model;
    private TemperatureList temperatureList;


    public TemperaturViewModel2(TemperatureModel model) {
        this.model=model;

    }


}
