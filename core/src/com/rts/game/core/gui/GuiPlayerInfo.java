package com.rts.game.core.gui;


import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.StringBuilder;
import com.rts.game.core.users_logic.PlayerLogic;

public class GuiPlayerInfo extends Group {
    private PlayerLogic playerLogic;
    private Label money;
    private Label unitsCount;
    private StringBuilder tmpSB;

    public GuiPlayerInfo(PlayerLogic playerLogic, Skin skin) {
        this.playerLogic = playerLogic;
        this.money = new Label("", skin, "simpleLabel");
        this.unitsCount = new Label("", skin, "simpleLabel");
        this.money.setPosition(10, 10);
        this.unitsCount.setPosition(210, 10);
        this.addActor(money);
        this.addActor(unitsCount);
        this.tmpSB = new StringBuilder();
    }

    public void update(float dt) {
        tmpSB.clear();
        tmpSB.append("MINERALS: ").append(playerLogic.getMoney());
        money.setText(tmpSB);
        tmpSB.clear();
        tmpSB.append("UNITS: ").append(playerLogic.getUnitsCount()).append(" / ").append(playerLogic.getUnitsMaxCount());
        unitsCount.setText(tmpSB);
    }
}
