package temperature.mediator;

import StagePattern.Radiator;
import temperature.model.Temperature;
import temperature.model.TemperatureList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModelManager implements TemperatureModel
{
  private PropertyChangeSupport propertyChangeSupport;
  private TemperatureList temperatureList;
  private Radiator radiator;

  public TemperatureModelManager()
  {
    propertyChangeSupport = new PropertyChangeSupport(this);
    temperatureList = new TemperatureList();
    radiator = new Radiator();
  }

  @Override public void addTemperature(String id, double value)
  {
    Temperature temperature = new Temperature(id, value);
    Temperature old = getLastInsertedTemperature();
    this.temperatureList.addTemperature(temperature);
    if (old != null && old.getValue() != temperature.getValue())
    {
      System.out.println("-->" + temperature + " (from: " + old + ")");
    }
    propertyChangeSupport.firePropertyChange("AddTemperature", -1, 1);
  }

  @Override public Temperature getLastInsertedTemperature()
  {
    return temperatureList.getLastTemperature(null);
  }

  @Override public Temperature getLastInsertedTemperature(String id)
  {
    return temperatureList.getLastTemperature(id);
  }

  // and maybe other methods...

  @Override public void addListener(String propertyName,
      PropertyChangeListener listener)
  {
    if (propertyName == null) // all events
    {
      propertyChangeSupport.addPropertyChangeListener(listener);
    }
    else  // a specific event
    {
      propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }
  }

  @Override public void removeListener(String propertyName,
      PropertyChangeListener listener)
  {
    if (propertyName == null) // all events
    {
      propertyChangeSupport.removePropertyChangeListener(listener);
    }
    else  // a specific event
    {
      propertyChangeSupport.removePropertyChangeListener(propertyName, listener);
    }
  }

  public void turnUp(){
    this.radiator.turnUp();
  }

  @Override public void turnDown()
  {
    this.radiator.turnDown();
  }

  @Override public int getPower()
  {
    return radiator.getPower();
  }

}
