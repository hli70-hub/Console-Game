public class MegaKnight extends Troop {

  int charge, chargeMax;

  public MegaKnight(String name, int hp){
    super(name, hp);
    chargeMax = 60;
    charge = chargeMax / 3;
  }

  public MegaKnight(String name){
    this(name, 90);
  }

  public MegaKnight(){
    this("Mega Knight");
  }

  public String getSpecialName(){
    return "charge";
  }

  public int getSpecial(){
    return charge;
  }

  public void setSpecial(int n){
    charge = n;
  }

  public int getSpecialMax(){
    return chargeMax;
  }

  public String attack(Troop other){
    int damage = (int)(Math.random() * 20) + 15;
    other.applyDamage(damage);
    restoreSpecial(5);
    return this + " slams " + other +
           " dealing " + damage + " damage.";
  }

  public String specialAttack(Troop other){
    if (getSpecial() >= 40){
      setSpecial(getSpecial() - 40);
      int damage = (int)(Math.random() * 30) + 50;
      other.applyDamage(damage);
      return this + " leaps into the air and CRASHES down on " +
             other + " for " + damage + " massive damage!";
    } else {
      return "Not enough charge. Instead " + attack(other);
    }
  }

  public String support(Troop other){
    return this + " shields " + other +
           ", restoring " + other.restoreSpecial(10) +
           " " + other.getSpecialName();
  }

  public String support(){
    int hp = 10;
    setHP(getHP() + hp);
    return this + " braces himself, restoring " +
           restoreSpecial(15) + " " + getSpecialName() +
           " and " + hp + " HP.";
  }
}