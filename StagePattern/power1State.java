package StagePattern;

public class power1State implements RadiatorState
{
  private int power = 1;
  @Override public void turnUp(Radiator radiator)
  {
    System.out.println("Turning power up by one");
    radiator.setPowerStage(new power2State());
  }

  @Override public void turnDown(Radiator radiator)
  {
    System.out.println("");
    radiator.setPowerStage((new offState()));
  }

  @Override public int getpower()
  {
    return power;
  }
}
