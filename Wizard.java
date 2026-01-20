public class Wizard extends Troop {

  int heat, heatMax;
  String wizardType;

  public Wizard(String name, int hp, String type){
    super(name, hp);
    heatMax = 50;
    heat = heatMax / 2;
    wizardType = type;
  }

  public Wizard(String name, int hp){
    this(name, hp, "fire");
  }

  public Wizard(String name){
    this(name, 50);
  }

  public Wizard(){
    this("Evo Wizard");
  }

  public String getSpecialName(){
    return "heat";
  }

  public int getSpecial(){
    return heat;
  }
  
  public void setSpecial(int n){
    heat = n;
  }

  public int getSpecialMax(){
    return heatMax;
  }

  public String attack(Troop other){
    int damage = (int)(Math.random() * 30) + 10;
    other.applyDamage(damage);
    restoreSpecial(10);
    return this + " casts a spell on " + other +
           " dealing " + damage + " damage and absorbs elixir.";
  }

  public String specialAttack(Troop other){
    if (getSpecial() >= 40){
      setSpecial(getSpecial() - 40);
      int damage = (int)(Math.random() * 20 + Math.random() * 20) + 30;
      other.applyDamage(damage);
      return this + " unleashes a powerful " + wizardType +
             " explosion, overheating " + other +
             " for " + damage + " damage.";
    } else {
      return "Not enough heat. Instead " + attack(other);
    }
  }

  public String support(Troop other){
    return this + " channels elixir into " + other +
           ", restoring " + other.restoreSpecial(15) +
           " " + other.getSpecialName();
  }

  public String support(){
    int hp = 5;
    setHP(getHP() + hp);
    return this + " evolves, restoring " +
           restoreSpecial(20) + " " + getSpecialName() +
           " and " + hp + " HP";
  }
}