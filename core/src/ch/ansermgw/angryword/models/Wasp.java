package ch.ansermgw.angryword.models;

import ch.ansermgw.angryword.activities.Play;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;


public class Wasp extends MovingObject {
    private static final String SPRITE_NAME = "wasp.png";
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;

    private final Vector2 cycleLength = new Vector2(1300, 900);
    private final Vector2 cycleScale = new Vector2(
            Math.abs(Play.WORLD_WIDTH / 5) - WIDTH,
            Math.abs(Play.WORLD_HEIGHT / 4)
    );
    private final long spawnTime;

    public Wasp(Vector2 position) {
        super(position, WIDTH, HEIGHT, SPRITE_NAME, Vector2.Zero);
        spawnTime = TimeUtils.millis();
    }

    @Override
    public void accelerate(float dt) {
        long globalCounter = TimeUtils.timeSinceMillis(spawnTime);

        float x = (float) Math.sin(globalCounter / cycleLength.x) * cycleScale.x;
        float y = (float) Math.cos(globalCounter / cycleLength.y) * cycleScale.y;

        this.speed = new Vector2(x, y);
    }
}


