package StagePattern;

public class Radiator
{
  private RadiatorState currentState = new offState();


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
    this.currentState = currentState;
  }
}
