package com.rts.game.core.controllers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rts.game.core.GameController;
import com.rts.game.core.utils.ObjectPool;
import com.rts.game.core.units.BattleTank;
import com.rts.game.core.users_logic.BaseLogic;

public class BattleTanksController extends ObjectPool<BattleTank> {
    private GameController gc;

    @Override
    protected BattleTank newObject() {
        return new BattleTank(gc);
    }

    public BattleTanksController(GameController gc) {
        this.gc = gc;
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < activeList.size(); i++) {
            activeList.get(i).render(batch);
        }
    }

    public void setup(float x, float y, BaseLogic baseLogic) {
        BattleTank t = activateObject();
        t.setup(baseLogic, x, y);
    }

    public void update(float dt) {
        for (int i = 0; i < activeList.size(); i++) {
            activeList.get(i).update(dt);
        }
        checkPool();
    }
}
