package com.mygdx.archive.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.archive.GameController;

public class LoadingScreen extends AbstractScreen {
    private static final String LOGO = "logo.jpg";
    private final SpriteBatch batch;
    private Texture logoTexture;

    public LoadingScreen(GameController game) {
        super(game);

        this.batch = new SpriteBatch();
    }

    @Override
    public void show() {
        //TODO: show text "loading"
        game.assetManager.load(LOGO, Texture.class);
        game.assetManager.finishLoading();

        logoTexture = game.assetManager.get(LOGO);
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        game.assetManager.unload(LOGO);
    }

    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        // Draws a white background
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(logoTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();

        if (game.assetManager.update()) {
            //TODO: set text to display that the user needs to click to continue
            if (Gdx.input.isTouched()) {
                game.setScreen(new MainMenuScreen(game));
            }
        }
    }
}
