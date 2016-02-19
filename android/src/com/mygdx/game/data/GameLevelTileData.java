package com.mygdx.game.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static android.provider.BaseColumns._ID;

public class GameLevelTileData extends GameDAO {
    public static final String TABLE_NAME = "gameLevelTileData";

    public static final String LEVEL = "level";
    public static final String PLAYER_START_TILE_X = "playerStartTileX";
    public static final String PLAYER_START_TILE_Y = "playerStartTileY";
    public static final String TILE_DATA = "tileData";
    public static final int FIELD_ID_PLAYER_START_TILE_X = 2;
    public static final int FIELD_ID_PLAYER_START_TILE_Y = 3;
    public static final int FIELD_ID_TILE_DATA = 4;
    public static final String TILE_DATA_LINE_BREAK = "//";
    private static final int FIELD_ID_ID = 0;
    private static final int FIELD_ID_LEVEL = 1;

    public GameLevelTileData(Context ctx) {
        super(ctx);
    }

    /**
     * Gets an array of game level data for a given level.
     */
    public ArrayList<String> getGameLevelData(int level) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] from = {_ID, LEVEL, PLAYER_START_TILE_X, PLAYER_START_TILE_Y, TILE_DATA};
        String where = LEVEL + " = " + level;

        Cursor cursor = db.query(TABLE_NAME, from, where, null, null, null, null);

        ArrayList<String> levelData = new ArrayList<>();

        if (cursor != null) {
            while (cursor.moveToNext()) {
                levelData.add(cursor.getString(FIELD_ID_ID));
                levelData.add(cursor.getString(FIELD_ID_LEVEL));
                levelData.add(cursor.getString(FIELD_ID_PLAYER_START_TILE_X));
                levelData.add(cursor.getString(FIELD_ID_PLAYER_START_TILE_Y));
                levelData.add(cursor.getString(FIELD_ID_TILE_DATA));
            }
            cursor.close();
        }

        db.close();
        return levelData;
    }
}
