package hu.nive.ujratervezes.kepesitovizsga.army;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private final List<MilitaryUnit> soldiers = new ArrayList<>();

    public int getArmySize() {
        return soldiers.size();
    }

    public void addUnit(MilitaryUnit militaryUnit) {
        soldiers.add(militaryUnit);
    }

    public int getArmyDamage() {
        int counter = 0;
        for (MilitaryUnit item : soldiers
        ) {
            counter += item.doDamage();
        }
        return counter;
    }

    public void damageAll(int i) {
        for (MilitaryUnit item : soldiers
        ) {
            item.sufferDamage(i);
        }
        removalOfDisabledSoldiers();
    }

    private void removalOfDisabledSoldiers() {
        soldiers.removeIf(militaryUnit -> (militaryUnit.hitPoints < 25));
    }
}
