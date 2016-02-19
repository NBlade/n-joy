package com.mygdx.archive;

public enum Tile {
    VOID(0, "Empty", "empty.gif"),
    GRASS(1, "Grass", "grass.png"),
    DIRT(2, "Dirt", "dirt.png");

    private final int id;
    private final String name;
    private final String file;

    Tile(int id, String name, String file) {
        this.id = id;
        this.name = name;
        this.file = file;
    }

    public static Tile getTile(int id) {
        Tile[] tiles = Tile.values();
        for (int i = 0; i < tiles.length; i++) {
            if (id == tiles[i].getId()) {
                return tiles[i];
            }
        }
        return Tile.VOID;
    }

    private int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public String getFile() {
        return "tiles/" + this.file;
    }

    public Tile getTile(String name) {
        return Tile.valueOf(name.toUpperCase());
    }
}
