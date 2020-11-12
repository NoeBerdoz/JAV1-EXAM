package ch.ansermgw.angryword.models;

import ch.ansermgw.angryword.resource.WordResource;
import com.badlogic.gdx.math.Vector2;

public class Pig extends PhysicalObject {

    public static final int WIDTH = 60;
    public static final int HEIGHT = 60;
    private static final String SPRITE_NAME = "pig.png";
    private final WordResource wordResource;

    public Pig(Vector2 position, WordResource word) {
        super(position, WIDTH, HEIGHT, SPRITE_NAME);
        wordResource = word;
    }

    public void kill() {
        this.wordResource.setUsed(false);
    }

    public WordResource getWord() {
        return wordResource;
    }
}
