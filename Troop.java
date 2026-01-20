// Collaborators: Aditya Roy and Henry Li

import java.util.Random;

public abstract class Troop {
  private String name;
  private int HP, maxHP;

  public Troop(String name){
    this(name, 10);
  }

  public Troop(String name, int hp){
    this.name = name;
    this.HP = hp;
    this.maxHP = hp;
  }

  public int restoreSpecial(int n){
    if (n > getSpecialMax() - getSpecial()){
      n = getSpecialMax() - getSpecial();
    }
    setSpecial(getSpecial() + n);
    return n;
  }

  public abstract String getSpecialName();
  public abstract int getSpecial();
  public abstract void setSpecial(int n);
  public abstract int getSpecialMax();

  public abstract String attack(Troop other);
  public abstract String support(Troop other);
  public abstract String support();
  public abstract String specialAttack(Troop other);

  public void applyDamage(int amount){
    HP -= amount;
  }

  public String toString(){
    return name;
  }

  public String getName(){
    return name;
  }

  public int getHP(){
    return HP;
  }

  public int getMaxHP(){
    return maxHP;
  }

  public void setMaxHP(int newMax){
    maxHP = newMax;
  }

  public void setHP(int health){
    HP = health;
  }

  public void setName(String s){
    name = s;
  }
}