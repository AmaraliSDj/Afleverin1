package temperature.view;

import StagePattern.Radiator;
import StagePattern.RadiatorState;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TemperatureViewController implements PropertyChangeListener
{
   @FXML private Label outputLabel;
   @FXML private TextField filterField;
   @FXML private Label filterLabel;
   @FXML private Label t0;
   @FXML private Label t1;
   @FXML private Label rediatorStage;



   private ViewHandler viewHandler;
   private Region root;
   private TemperaturViewModel viewModel;

   public TemperatureViewController()
   {
   }

   public void init(ViewHandler viewHandler, TemperaturViewModel viewModel, Region root)
   {
      this.viewHandler = viewHandler;
      this.viewModel = viewModel;
      this.root = root;
      outputLabel.textProperty().bind(viewModel.temperaturProperty());
      t1.textProperty().bind(viewModel.temperaturProperty1());
      t0.textProperty().bind(viewModel.temperaturProperty2());
      rediatorStage.textProperty().bind(viewModel.getPowerProperty());
   }


   public Region getRoot()
   {
      return root;
   }

   @FXML private void updateButtonPressed()
   {
    viewModel.update();
    }



   @Override public void propertyChange(PropertyChangeEvent evt)
   {

   }
   public void nextpage(ActionEvent actionEvent) {
      viewHandler.openView("temperature2");
   }

   public void TurnDown(ActionEvent actionEvent)
   {
      viewModel.turnDown();
   }

   public void TurnUp(ActionEvent actionEvent)
   {
      viewModel.turnUp();

   }
}
