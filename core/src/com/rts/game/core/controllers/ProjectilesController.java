package com.rts.game.core.controllers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.rts.game.core.GameController;
import com.rts.game.core.utils.ObjectPool;
import com.rts.game.core.Projectile;
import com.rts.game.core.units.AbstractUnit;
import com.rts.game.screens.utils.Assets;

public class ProjectilesController extends ObjectPool<Projectile> {
    private GameController gc;
    private TextureRegion projectileTexture;

    @Override
    protected Projectile newObject() {
        return new Projectile(gc);
    }

    public ProjectilesController(GameController gc) {
        this.gc = gc;
        this.projectileTexture = Assets.getInstance().getAtlas().findRegion("bullet");
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < activeList.size(); i++) {
            activeList.get(i).render(batch);
        }
    }

    public void setup(AbstractUnit owner, Vector2 srcPosition, float angle) {
        Projectile p = activateObject();
        p.setup(owner, srcPosition, angle, projectileTexture);
    }

    public void update(float dt) {
        for (int i = 0; i < activeList.size(); i++) {
            activeList.get(i).update(dt);
        }
        checkPool();
    }
}
