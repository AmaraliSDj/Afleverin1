package StagePattern;

public class offState implements RadiatorState
{
  private int power = 0;
  @Override public void turnUp(Radiator radiator)
  {
    System.out.println("Turning up");
    radiator.setPowerStage(new power1State());

  }

  @Override public void turnDown(Radiator radiator)
  {
    System.out.println("Intet sker");
  }

  @Override public int getpower()
  {
    return power;
  }
}
