package hu.nive.ujratervezes.kepesitovizsga.army;

public abstract class MilitaryUnit {
    protected int hitPoints;
    protected int damage;
    protected boolean armor;

    protected MilitaryUnit(int hitPoints, int damage, boolean armor) {
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.armor = armor;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int doDamage() {
        return damage;
    }

    public void sufferDamage(int damage) {
        if (armor) {
            this.hitPoints = this.hitPoints - damage / 2;
        } else {
            this.hitPoints = this.hitPoints - damage;
        }
    }
}

