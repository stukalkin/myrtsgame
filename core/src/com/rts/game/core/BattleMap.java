package com.rts.game.core;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.Arrays;

public class BattleMap {
    private TextureRegion grassTexture;
    private int [][] data;

    public BattleMap() {
        this.data = new int[16][9];
        for (int[] datum : data) {
            Arrays.fill(datum, 1);
            System.out.println();
        }
        this.grassTexture = Assets.getInstance().getAtlas().findRegion("grass");
    }

    public void setData(int i, int y) {
        this.data[i][y] = 0;
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 9; j++) {
                batch.draw(grassTexture, i * 80, j * 80);
                if (data[i][j] == 1) {batch.draw(Assets.getInstance().getAtlas().findRegion("resources"),
                        i * 80, j * 80);}
            }
        }
    }
}
