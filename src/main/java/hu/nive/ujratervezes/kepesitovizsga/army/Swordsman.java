package hu.nive.ujratervezes.kepesitovizsga.army;

public class Swordsman extends MilitaryUnit {
    private boolean isTheShieldUseAble = true;

    public Swordsman(boolean armor) {
        super(100, 10, armor);
    }

    @Override
    public void sufferDamage(int damage) {
        if (isTheShieldUseAble) {
            this.isTheShieldUseAble = false;
            return;
        }
        super.sufferDamage(damage);
    }
}
