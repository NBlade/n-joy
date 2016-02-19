package com.mygdx.game;

import android.content.Context;
import android.graphics.Rect;

/**
 * An extension of GameImage, GameUnit represents a playable or non-playable
 * unit in the game.
 * <p/>
 * In addition to the GameImage properties, game units include a unique ID,
 * based on a static count property. This is useful when creating, and later
 * modifying, multiple units.
 */
public class GameUnit extends GameImage {
    private static int count = 1;
    private final int id;

    public GameUnit(Context context, int drawable) {
        super(context, drawable);

        id = count;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void resetCount() {
        count = 1;
    }

    public Rect getRect() {
        Rect rect = new Rect(mX, mY, (mX + this.getWidth()), (mY + this.getHeight()));
        return rect;
    }

    public boolean getCollision(int x, int y, int width, int height) {
        Rect rect = new Rect(x, y, (x + width), (y + height));
        return (rect.intersects(mX, mY, (mX + getWidth()), (mY + getHeight())));
    }

    public boolean getImpact(int x, int y) {
        if ((x >= mX) && (x <= (mX + this.getWidth()))) {
            if ((y >= mY) && (y <= (mY + this.getHeight()))) {
                return true;
            }
        }

        return false;
    }

    public int getId() {
        return id;
    }
}
