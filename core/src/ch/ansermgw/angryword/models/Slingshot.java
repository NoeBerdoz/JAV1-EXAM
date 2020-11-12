package ch.ansermgw.angryword.models;

import com.badlogic.gdx.math.Vector2;

public class Slingshot extends PhysicalObject {
    private static final String SPRITE_NAME = "slingshot1.png";
    private static final int WIDTH = 100;
    private static final int HEIGHT = 300;

    public Slingshot(Vector2 position) {
        super(position, WIDTH, HEIGHT, SPRITE_NAME);
    }
}