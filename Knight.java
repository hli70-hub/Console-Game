public class Knight extends Game{
  int rage, rageMax;

  public Knight(String name, int hp){
    super(name, hp);
    rage = 0;
    rageMax = 11;
  }

  public Knight(String name){
    super(name);
    rage = 0;
    rageMax = 9;
  }

  public Knight(){
    super("Knight");
    rage = 0;
    rageMax = 9;
  }

  //Abstract methods are meant to be implemented in child classes.

  /*
    all adventurers must have a custom special
    consumable resource (mana/rage/money/witts etc)
  */
  //give it a short name (fewer than 13 characters)
  public String getSpecialName()
    return "shield";
  //accessor methods
  public abstract int getSpecial()
    return rage;
  public abstract void setSpecial(int n)
    rage = n;
  public abstract int getSpecialMax()
    return rageMax;

  /*
    all adventurers must have a way to attack enemies and
    support their allys
  */
  //hurt or hinder the target adventurer
  public String attack(Adventurer other){
    int damage = (int)(Math.random*26) + 25;
    other.applyDamage(damage);
    restoreSpecial(2);
    return this + " slashed "+ other + " and dealt "+ damage +
      " points of damage. They then get even angrier.";
  }

  //heall or buff the target adventurer
  public String support(Adventurer other){
    return "Screams and actually motivates  "+other+" and restores "
      +other.restoreSpecial(5)+" "+other.getSpecialName();
  }

  //heall or buff self
  public String support(){
    int hp = (int)(Math.random() * 51);
    setHP(getHP()+hp);
    return this+" psyches himself up and restores "+restoreSpecial(3)+" "
    + getSpecialName()+ " and "+hp+" HP";
  }

  //hurt or hinder the target adventurer, consume some special resource
  public String specialAttack(Adventurer other){
    if(getSpecial() >= 5){
      setSpecial(getSpecial()-5);
      int damage = (int)(Math.random()*31);
      int hp = (int)(Math.random()*51)
      other.applyDamage(damage);
      return this + " used their shield."
      " This dazed "+other+" dealing "+ damage +" points of damage and raised his HP by " + hp;
    }else{
      return "Not enough rage to use the ultimate code. Instead "+attack(other);
    }
  }
}
