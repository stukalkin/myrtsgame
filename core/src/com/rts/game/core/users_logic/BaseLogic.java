package com.rts.game.core.users_logic;

import com.rts.game.core.GameController;
import com.rts.game.core.units.types.Owner;

public class BaseLogic {
    protected Owner ownerType;
    protected GameController gc;
    protected int money;
    protected int unitsCount;
    protected int unitsMaxCount;

    public void addMoney(int amount) {
        this.money += amount;
    }

    public int getMoney() {
        return money;
    }

    public int getUnitsCount() {
        return unitsCount;
    }

    public int getUnitsMaxCount() {
        return unitsMaxCount;
    }

    public Owner getOwnerType() {
        return ownerType;
    }
}
