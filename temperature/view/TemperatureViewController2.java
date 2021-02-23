package temperature.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.beans.PropertyChangeListener;

public class TemperatureViewController2 {

        private ViewHandler viewHandler;
        private Region root;
        private TemperaturViewModel2 viewModel;

        public TemperatureViewController2()
        {
        }

        public void init(ViewHandler viewHandler, TemperaturViewModel2 viewModel, Region root)
        {
            this.viewHandler = viewHandler;
            this.viewModel = viewModel;
            this.root = root;
        }


    public Region getRoot() {
            return root;
    }
}
