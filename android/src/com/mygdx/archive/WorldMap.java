package com.mygdx.archive;

public class WorldMap {
    public final int sizeX = 10;
    public final int sizeY = 10;
    private final int[][] map = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 2, 2, 2, 2, 1, 1, 1, 1},
            {1, 1, 2, 2, 2, 2, 1, 1, 1, 1},
            {1, 1, 2, 2, 2, 2, 1, 1, 1, 1},
            {1, 1, 1, 2, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 2, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 2, 2, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 2, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 2, 2, 2, 2, 2, 2},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    public WorldMap() {

    }

    public Tile getTile(int x, int y) {
        return Tile.getTile(getCell(x, y));
    }

    private int getCell(int x, int y) {
        return map[x][y];
    }
}
