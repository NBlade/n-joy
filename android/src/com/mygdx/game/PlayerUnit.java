package com.mygdx.game;

import android.content.Context;

/**
 * An extension of GameUnit, PlayerUnit represents the player-controlled
 * unit in the game.
 */
public class PlayerUnit extends GameUnit {
    public static final int SPEED = 3;

    private final Context mContext;

    private int mUnmodifiedX = 0;
    private int mUnmodifiedY = 0;

    public PlayerUnit(Context context, int drawable) {
        super(context, drawable);
        this.mContext = context;
    }

    public int getUnmodifiedX() {
        return this.mUnmodifiedX;
    }

    public void setUnmodifiedX(int unmodifiedX) {
        this.mUnmodifiedX = unmodifiedX;
    }

    public int getUnmodifiedY() {
        return this.mUnmodifiedY;
    }

    public void setUnmodifiedY(int unmodifiedY) {
        this.mUnmodifiedY = unmodifiedY;
    }
}
