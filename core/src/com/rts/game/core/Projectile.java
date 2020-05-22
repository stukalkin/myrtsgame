package com.rts.game.core;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Projectile {
    private Vector2 position;
    private Vector2 velocity;
    private TextureRegion texture;
    private boolean fired;

    public boolean isFired() {
        return fired;
    }

    public Projectile(TextureAtlas atlas) {
        this.position = new Vector2( 0, 0);
        this.velocity = new Vector2( 0, 0);
        this.texture = atlas.findRegion("bullet");
        this.fired = false;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setFired(boolean status) {
        fired = status;
    }

    public TextureRegion getTexture() {
        return texture;
    }

    public void setup(Vector2 startPosition, float angle) {
        velocity.set(100.0f * MathUtils.cosDeg(angle), 0.0f);
        position.set(startPosition);
    }

    public void update(float dt) {
        position.mulAdd(velocity, dt);
    }
}
