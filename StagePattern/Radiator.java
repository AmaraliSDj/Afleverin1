package StagePattern;

import java.beans.PropertyChangeSupport;

public class Radiator
{
  private RadiatorState currentState = new offState();
  private PropertyChangeSupport support;


  public void turnUp(){
    currentState.turnUp(this);
  }

  public void turnDown(){
    currentState.turnDown(this);
  }

  public int getPower(){
    return currentState.getpower();

  }

  public void setPowerStage(RadiatorState currentState)
  {
    support.firePropertyChange("radiator",null,currentState);
    this.currentState = currentState;
  }
}
