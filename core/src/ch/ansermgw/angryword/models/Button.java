package ch.ansermgw.angryword.models;

import com.badlogic.gdx.math.Vector2;

public class Button extends TextualObject {
    public static final int WIDTH = 300 / 2;
    public static final int HEIGHT = 298 / 3;
    private static final String SPRITE_NAME = "rubber.png";

    public Button(Vector2 position, String text) {
        super(position, WIDTH, HEIGHT, SPRITE_NAME, text);
    }
}
