package ch.ansermgw.angryword.models;

import com.badlogic.gdx.math.Vector2;

public class Block extends PhysicalObject {
    private static final String SPRITE_NAME = "block.png";
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;


    public Block(Vector2 position) {
        super(position, WIDTH, HEIGHT, SPRITE_NAME);
    }
}
