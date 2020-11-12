package ch.ansermgw.angryword.models;

import com.badlogic.gdx.math.Vector2;

public class Tnt extends PhysicalObject {
    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;
    private static final String SPRITE_NAME = "tnt.png";

    public Tnt(Vector2 position) {
        super(position, WIDTH, HEIGHT, SPRITE_NAME);
    }
}
