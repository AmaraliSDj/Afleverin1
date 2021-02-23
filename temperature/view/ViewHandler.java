package temperature.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import temperature.ViewModelFactory;
import temperature.mediator.TemperatureModel;

public class ViewHandler extends Application {
  private Stage primaryStage;
  private Scene currentScene;

  private TemperatureViewController temperatureViewController;
  private TemperatureViewController2 temperatureViewController2;
  private TemperatureModel model;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory vmf) {
    this.viewModelFactory = vmf;
  }

  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    this.currentScene = new Scene(new Region());
    openView("temperature");
  }

  public void openView(String id) {
    Region root = null;
    switch (id) {
      case "temperature":
        root = loadTemperatureView("TemperatureView.fxml");
        break;
      case "temperature2":
        root = loadTemperatureView("TemperatureView2.fxml");
        break;
    }
    currentScene.setRoot(root);

    String title = "";
    if (root.getUserData() != null) {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  private Region loadTemperatureView(String fxmlFile) {
    if (fxmlFile.equals("TemperatureView.fxml")) {
      if (temperatureViewController == null) {
        try {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource(fxmlFile));
          Region root = loader.load();
          temperatureViewController = loader.getController();
          temperatureViewController.init(this, viewModelFactory.getTemperaturViewModel(), root);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      return temperatureViewController.getRoot();
    }
      if (fxmlFile.equals("TemperatureView2.fxml")) {
      if (temperatureViewController2 == null) {
        try {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource(fxmlFile));
          Region root = loader.load();
          temperatureViewController2 = loader.getController();
          temperatureViewController2.init(this, viewModelFactory.getTemperaturViewModel2(), root);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
        return temperatureViewController2.getRoot();
    }
    return null;
  }
}


