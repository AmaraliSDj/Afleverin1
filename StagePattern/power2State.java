package StagePattern;

public class power2State implements RadiatorState
{
  private int power = 2;
  @Override public void turnUp(Radiator radiator)
  {
    System.out.println("Turning power up by one");
    radiator.setPowerStage(new power3State(radiator));
  }

  @Override public void turnDown(Radiator radiator)
  {
    System.out.println("Turning down the power by one");
    radiator.setPowerStage(new power1State());
  }

  @Override public int getpower()
  {
    return power;
  }
}
