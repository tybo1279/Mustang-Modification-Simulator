
public class Mod {

  public Integer hpAdded;
  public Integer price;
  public String name;
  public boolean giveHpBoost;
  public Integer hpPotential;
  public boolean isDependent;
  
  
  public Integer getHpAdded() {
    return hpAdded;
  }
  public void setHpAdded(Integer hpAdded) {
    this.hpAdded = hpAdded;
  }
  public Integer getPrice() {
    return price;
  }
  public void setPrice(Integer price) {
    this.price = price;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public boolean isHpBoosted() {
    return giveHpBoost;
  }
  public void setHpBoost(boolean givehpBoost) {
    this.giveHpBoost = givehpBoost;
  }
  public Integer getHpPotential() {
    return hpPotential;
  }
  public void setHpPotential(Integer hpPotential) {
    this.hpPotential = hpPotential;
  }
  public boolean getIsDependent() {
    return isDependent;
  }
  public void setIsDependent(boolean isDependent) {
    this.isDependent = isDependent;
  }
 
  
  
}
