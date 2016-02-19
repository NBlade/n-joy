package com.mygdx.archive.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.archive.GameController;
import com.mygdx.archive.Tile;
import com.mygdx.archive.WorldMap;

public class GameScreen extends AbstractScreen implements InputProcessor {
    private static final int TILE_SIZE = 96;
    private final SpriteBatch batch;
    private Texture[][] textureMap;

    public GameScreen(GameController game) {
        super(game);

        Gdx.input.setInputProcessor(this);
        this.batch = new SpriteBatch();

        init();
    }

    private void init() {
        for (Tile tile : Tile.values()) {
            game.assetManager.load(tile.getFile(), Texture.class);
        }
        game.assetManager.finishLoading();

        WorldMap worldMap = game.getWorldMap();
        textureMap = new Texture[worldMap.sizeX][];

        for (int x = 0; x < worldMap.sizeX; x++) {
            textureMap[x] = new Texture[worldMap.sizeY];
            for (int y = 0; y < worldMap.sizeY; y++) {
                textureMap[x][y] = game.assetManager.get(worldMap.getTile(x, y).getFile());
            }
        }
    }

    @Override
    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        batch.begin();
        for (int x = 0; x < textureMap.length; x++) {
            for (int y = 0; y < textureMap[x].length; y++) {
                batch.draw(textureMap[x][y], x * TILE_SIZE, y * TILE_SIZE);
            }
        }
        batch.end();
    }

    @Override
    public void dispose() {
        for (Tile tile : Tile.values()) {
            game.assetManager.unload(tile.getFile());
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
