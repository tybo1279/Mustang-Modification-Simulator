
public class SuspensionMod extends Mod {

  public Double rwhpBoost;
  
  public Double getRwhpBoost() {
    return rwhpBoost;
  }

  public void setRwhpBoost(Double rwhpBoost) {
    this.rwhpBoost = rwhpBoost;
  }

  public SuspensionMod() {
    this.giveHpBoost = false;
    this.hpAdded = 0;
    
  }
}
