package com.mygdx.archive.screen;

import com.badlogic.gdx.Screen;
import com.mygdx.archive.GameController;

public abstract class AbstractScreen implements Screen {
    protected final GameController game;

    public AbstractScreen(GameController game) {
        this.game = game;
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
