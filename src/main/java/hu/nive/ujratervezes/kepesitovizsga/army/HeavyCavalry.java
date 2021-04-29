package hu.nive.ujratervezes.kepesitovizsga.army;

public class HeavyCavalry extends MilitaryUnit {
    public static final int FIRST_DAMAGE_MULTIPLIER = 3;
    private boolean isFirstDamage = true;

    protected HeavyCavalry() {
        super(150, 20, true);
    }


    @Override
    public int doDamage() {
        if (isFirstDamage) {
            isFirstDamage = false;
            return super.doDamage() * FIRST_DAMAGE_MULTIPLIER;
        }
        return super.doDamage();
    }
}
