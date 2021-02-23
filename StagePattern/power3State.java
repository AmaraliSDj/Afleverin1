package StagePattern;

public class power3State implements RadiatorState
{
  private int power = 3;
  Thread turnDown;
  public power3State(Radiator radiator){
    turnDown=new Thread(()->{
      try
      {
        Thread.sleep(10000);
        this.turnDown(radiator);
      }
      catch (InterruptedException e)
      {
        System.out.println("Turning down the power room is to hot");
      }
    });
    System.out.println("Hvis rummet bliver for varmet skrue vi selv ned");
    turnDown.start();


  }
  @Override public void turnUp(Radiator radiator)
  {
    System.out.println("Du kan ikke skrue længere op ");

  }

  @Override public void turnDown(Radiator radiator)
  {
    System.out.println("Turn down ");
    turnDown.interrupt();
    radiator.setPowerStage(new power2State());

  }

  @Override public int getpower()
  {
    return power;
  }
}
