package com.mygdx.archive;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.mygdx.archive.screen.LoadingScreen;

public class GameController extends Game {

    public final AssetManager assetManager = new AssetManager();
    private WorldMap worldMap;

    @Override
    public void create() {
        setScreen(new LoadingScreen(this));

        worldMap = new WorldMap();
    }

    public WorldMap getWorldMap() {
        return worldMap;
    }
}
