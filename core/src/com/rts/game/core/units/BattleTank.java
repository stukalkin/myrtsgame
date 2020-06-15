package com.rts.game.core.units;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rts.game.core.units.types.TargetType;
import com.rts.game.core.units.types.UnitType;
import com.rts.game.screens.utils.Assets;
import com.rts.game.core.GameController;
import com.rts.game.core.interfaces.Targetable;
import com.rts.game.core.Weapon;
import com.rts.game.core.users_logic.BaseLogic;

public class BattleTank extends AbstractUnit {
    public BattleTank(GameController gc) {
        super(gc);
        this.textures = Assets.getInstance().getAtlas().findRegion("tankcore").split(CORE_SIZE, CORE_SIZE)[0];
        this.weaponTexture = Assets.getInstance().getAtlas().findRegion("turret");
        this.speed = 120.0f;
        this.hpMax = 100;
        this.weapon = new Weapon(1.5f, 1);
        this.minDstToActiveTarget = weapon.getRange() - 40.0f;
        this.containerCapacity = 32;
        this.container = this.containerCapacity;
        this.unitType = UnitType.BATTLE_TANK;
    }

    @Override
    public void setup(BaseLogic baseLogic, float x, float y) {
        this.position.set(x, y);
        this.baseLogic = baseLogic;
        this.ownerType = baseLogic.getOwnerType();
        this.hp = this.hpMax;
        this.destination.set(position);
        this.commandMoveTo(this.position, true);
    }

    public void updateWeapon(float dt) {
        if (target != null) {
            if (!target.isActive()) {
                target = null;
                return;
            }
            if (container > 0 && this.position.dst(target.getPosition()) < weapon.getRange()) {
                float angleTo = tmp.set(target.getPosition()).sub(position).angle();
                weapon.setAngle(rotateTo(weapon.getAngle(), angleTo, 180.0f, dt));
                int power = weapon.use(dt);
                if (power > -1) {
                    container--;
                    gc.getProjectilesController().setup(this, position, weapon.getAngle());
                }
            }
        }
        if (target == null) {
            weapon.setAngle(rotateTo(weapon.getAngle(), angle, 180.0f, dt));
        }
    }

    @Override
    public void commandAttack(Targetable target) {
        if (target == null) {
            return;
        }
        if (target.getTargetType() == TargetType.UNIT && ((AbstractUnit) target).getOwnerType() != this.ownerType) {
            this.target = target;
            return;
        }
        if (target.getTargetType() == TargetType.BUILDING) {
            this.target = target;
            return;
        }
        commandMoveTo(target.getPosition(), true);
    }

    @Override
    public void renderGui(SpriteBatch batch) {
        super.renderGui(batch);
    }
}