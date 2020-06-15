package com.rts.game.core.controllers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rts.game.core.Building;
import com.rts.game.core.GameController;
import com.rts.game.core.utils.ObjectPool;
import com.rts.game.core.users_logic.BaseLogic;

public class BuildingsController extends ObjectPool<Building> {
    private GameController gc;

    @Override
    protected Building newObject() {
        return new Building(gc);
    }

    public BuildingsController(GameController gc) {
        this.gc = gc;
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < activeList.size(); i++) {
            activeList.get(i).render(batch);
        }
    }

    public void setup(int cellX, int cellY, BaseLogic ownerLogic) {
        Building b = activateObject();
        b.setup(ownerLogic, cellX, cellY);
    }

    public void update(float dt) {
        for (int i = 0; i < activeList.size(); i++) {
            activeList.get(i).update(dt);
        }
        checkPool();
    }
}
