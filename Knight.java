public class Knight extends Troop {

    int rage, rageMax;

    public Knight(String name, int hp) {
        super(name, hp);
        rageMax = 11;
        rage = 0;
    }

    public Knight(String name) {
        this(name, 80);
    }

    public Knight() {
        this("Knight");
    }

    public String getSpecialName() {
        return "rage";
    }

    public int getSpecial() {
        return rage;
    }

    public void setSpecial(int n) {
        rage = n;
    }

    public int getSpecialMax() {
        return rageMax;
    }

    public String attack(Troop other) {
        int damage = (int)(Math.random() * 21) + 25;
        other.applyDamage(damage);
        restoreSpecial(2);
        return this + " slashes " + other + " and deals " + damage + " damage. Rage increases!";
    }

    public String support(Troop other) {
        return this + " motivates " + other + " and restores " + other.restoreSpecial(5) + " " + other.getSpecialName();
    }

    public String support() {
        int hp = (int)(Math.random() * 31) + 10;
        setHP(getHP() + hp);
        return this + " psychs himself up, restores " + restoreSpecial(3) + " " + getSpecialName() + " and " + hp + " HP";
    }

    public String specialAttack(Troop other) {
        if (getSpecial() >= 5) {
            setSpecial(getSpecial() - 5);
            int damage = (int)(Math.random() * 26) + 20;
            int hp = (int)(Math.random() * 16) + 5;
            other.applyDamage(damage);
            setHP(getHP() + hp);
            return this + " uses shield smash on " + other + ", dealing " + damage +
                   " damage and healing " + hp + " HP!";
        } else {
            return "Not enough rage! " + attack(other);
        }
    }
}
