package com.rts.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rts.game.screens.GameScreen;

public class RTSGame extends Game {
    private SpriteBatch batch;
    private GameScreen gameScreen;

    // Домашнее задание:
    // 1. Разбор кода, в домашке задавайте вопросы что не ясно
    // 2. Реализовать класс Projectile (снаряд), игрок по кнопке K
    // может выпускать снаряд. Если снаряд улетает за экран, он
    // должен деактивироваться. Если снаряд деактивирован, то им можно
    // выстрелить снова

    @Override
    public void create() {
        this.batch = new SpriteBatch();
        this.gameScreen = new GameScreen(batch);
        this.setScreen(gameScreen);
    }

    @Override
    public void render() {
        getScreen().render(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}