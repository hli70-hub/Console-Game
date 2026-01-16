public class Wizard extends Adventurer{
  int heat, heatMax;
  String wizardType;

  /*the other constructors ultimately call the constructor
    with all parameters.*/
  public Wizard(String name, int hp, String language){
    super(name,hp);
    heatMax = 50;
    heat = heatMax/2;
    preferredLanguage = language;
  }

  public Wizard(String name, int hp){
    this(name,hp,"wizard");  
  }

  public Wizard(String name){
    this(name,50);
  }

  public Wizard(){
    this("Evo Wizard");
  }

  /*The next 8 methods are all required because they are abstract:*/
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

  /*Deal 1-6 damage to opponent, restores 2 caffeine*/
  public String attack(Adventurer other){
    int damage = (int)(Math.random()*30)+10;
    other.applyDamage(damage);
    restoreSpecial(10);
    return this + " attacked "+ other + " and dealt "+ damage +
    " points of damage. They then absorb elixir.";
  }
  /*Deal 3-12 damage to opponent, only if caffeine is high enough.
    Reduces caffeine by 8.
  */
  public String specialAttack(Adventurer other){
    if(getSpecial() >= 40){
      setSpecial(getSpecial()-40);
      int damage = (int)(Math.random()*20+Math.random()*20)+30;
      other.applyDamage(damage);
      return this + " used their "+wizardType+
      " skills to blow up the battlefield. "+
      " This overheats "+other+" dealing "+ damage +" points of damage.";
    }else{
      return "Not enough heat to use the ultimate move. Instead "+attack(other);
    }
  }

  /*Restores 5 special to other*/
  public String support(Adventurer other){
    return "Uses an elixir spell on "+other+" and restores " 
    +other.restoreSpecial(5)+" "+other.getSpecialName();
  }
  /*Restores 6 special and 1 hp to self.*/
  public String support(){
    int hp = 1;
    setHP(getHP()+hp);
    return this+" evolves to restore "+restoreSpecial(6)+" "
    + getSpecialName()+ " and "+hp+" HP";
  }
}
