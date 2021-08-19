import java.util.ArrayList;

public class Car {

  public String name;
  public ArrayList<Mod> currMods;
  public Integer hpPotential;
  public Integer currHP; //estimate, based on mods
  public Integer rwhp;
  public Integer totalInvested;
  
  public Car(String s) {
    this.currMods = new ArrayList<Mod>();
    this.totalInvested = 0; 
    this.name = s;
  }
  
  
  public void applyMod (Mod m) {
    if (m.giveHpBoost) {
        currHP += m.hpAdded;
        rwhp += m.hpAdded;
    }
    if (m.hpPotential != null) {
      if (m.hpPotential > this.hpPotential) {
        this.hpPotential = m.hpPotential; //FIXME
      }
    }
    totalInvested += m.price;
    if (m.isDependent) {
      for (Mod n: currMods) {
        currHP += n.hpAdded / 3;
      }
    }
    if (m instanceof SuspensionMod) {
      rwhp = (int) (rwhp + (((SuspensionMod) m).getRwhpBoost() * rwhp));
    }
    if (this.rwhp >= currHP) {
      this.rwhp = currHP - 10;
    }
    for (Mod s: currMods) {
      if (s.isDependent) {
      }
    }
    currMods.add(m);
  }
  
  public void applyTune() {
    for (Mod m : currMods) {
      if (m.giveHpBoost == false) {
        m.setHpBoost(true);
        currHP += m.hpAdded;
        rwhp += m.hpAdded;
      }
      if (m instanceof SuspensionMod) {
        rwhp = (int) (rwhp + (((SuspensionMod) m).getRwhpBoost() * currHP));
      }
      if (this.rwhp >= currHP) {
        this.rwhp = currHP - 10;
      }
    }
  }
  
  
  
  
}
