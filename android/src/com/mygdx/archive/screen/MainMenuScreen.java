package com.mygdx.archive.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.archive.GameController;

public class MainMenuScreen extends AbstractScreen {
    private final Stage stage;
    private Skin skin;

    public MainMenuScreen(GameController game) {
        super(game);

        this.stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        init();
    }

    private void init() {
        createBasicSkin();

        Table menuTable = new Table();
        menuTable.add(createButton("New Game", new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new GameScreen(game));
            }
        }));
        menuTable.row();
        menuTable.add(createButton("Exit", new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.exit(0);
            }
        }));
        menuTable.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);

        stage.addActor(menuTable);

    }

    private TextButton createButton(String name, EventListener listener) {
        TextButton newButton = new TextButton(name, skin);
        newButton.addListener(listener);
        return newButton;
    }

    @Override
    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        skin.dispose();
        stage.dispose();
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

    private void createBasicSkin() {
        //Create a font
        BitmapFont font = new BitmapFont();
        skin = new Skin();
        skin.add("default", font);

        //Create a texture
        Pixmap pixmap = new Pixmap(Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 10, Pixmap.Format.RGB888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        skin.add("background", new Texture(pixmap));

        //Create a button style
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("background", Color.GRAY);
        textButtonStyle.down = skin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.checked = skin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.over = skin.newDrawable("background", Color.LIGHT_GRAY);
        textButtonStyle.font = skin.getFont("default");
        skin.add("default", textButtonStyle);
    }
}
