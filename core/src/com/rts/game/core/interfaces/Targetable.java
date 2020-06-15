package com.rts.game.core.interfaces;

import com.badlogic.gdx.math.Vector2;
import com.rts.game.core.units.types.TargetType;

public interface Targetable {
    Vector2 getPosition();
    TargetType getTargetType();
    boolean isActive();
}
