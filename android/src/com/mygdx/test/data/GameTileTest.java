package com.mygdx.test.data;

import android.graphics.Point;

import com.mygdx.game.GameTile;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GameTileTest {
    @Test
    public void testConstructGameTile() {
        int x = 13;
        int y = 29;

        GameTile tile = new GameTile(null, new Point(x, y));

        assertThat(x, is(tile.getX()));
        assertThat(y, is(tile.getY()));
    }

    @Test
    public void testSetType() {
        GameTile tile = new GameTile(null, new Point(0, 0));

        tile.setType(GameTile.Type.EMPTY);
        assertThat(GameTile.Type.EMPTY, is(tile.getType()));
    }

    @Test
    public void testSetTypeInt() {
        GameTile tile = new GameTile(null, new Point(0, 0));

        tile.setType(GameTile.Type.EMPTY.getId());
        assertThat(GameTile.Type.EMPTY, is(tile.getType()));
    }

    @Test
    public void testIsBlocker() {
        GameTile tile = new GameTile(null, new Point(0, 0));

        //For all GameTile types -- only EMPTY should not be blocker
        for (GameTile.Type type : GameTile.Type.values()) {
            tile.setType(type);
            if (!type.equals(GameTile.Type.EMPTY)) {
                assertThat(true, is(tile.isBlockerTile()));
            } else {
                assertThat(false, is(tile.isBlockerTile()));
            }
        }
    }

    @Test
    public void testIsDangerous() {
        GameTile tile = new GameTile(null, new Point(0, 0));

        //For all GameTile types -- only DANGEROUS should be... dangerous
        for (GameTile.Type type : GameTile.Type.values()) {
            tile.setType(type);
            if (!type.equals(GameTile.Type.DANGEROUS)) {
                assertThat(false, is(tile.isDangerous()));
            } else {
                assertThat(true, is(tile.isDangerous()));
            }
        }
    }

    @Test
    public void testIsVisible() {
        GameTile tile = new GameTile(null, new Point(0, 0));

        tile.setVisible(true);
        assertThat(true, is(tile.isVisible()));

        tile.setVisible(false);
        assertThat(false, is(tile.isVisible()));
    }

    @Test
    public void testIsCollisionTile() {
        GameTile tile = new GameTile(null, new Point(0, 0));

        assertThat(false, is(tile.isCollisionTile()));

        tile.setVisible(false);
        //Invisible tiles cannot cause collision
        for (GameTile.Type type : GameTile.Type.values()) {
            tile.setType(type);
            assertThat(false, is(tile.isCollisionTile()));
        }

        tile.setVisible(true);
        //Visible tiles that are not empty cause collision
        for (GameTile.Type type : GameTile.Type.values()) {
            tile.setType(type);
            if (!type.equals(GameTile.Type.EMPTY)) {
                assertThat(true, is(tile.isCollisionTile()));
            } else {
                assertThat(false, is(tile.isBlockerTile()));
            }
        }
    }

    @Test
    public void testGetCollision() {
        int x = 13;
        int y = 29;

        GameTile tile = new GameTile(null, new Point(x, y));

        assertThat(false, is(tile.getCollision(0f, 0f, 12, 28)));
        assertThat(true, is(tile.getCollision(5f, 5f, 12, 28)));
    }
}