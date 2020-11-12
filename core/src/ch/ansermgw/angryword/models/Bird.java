package ch.ansermgw.angryword.models;

import com.badlogic.gdx.math.Vector2;

public class Bird extends MovingObject {
    private static final String SPRITE_NAME = "bird.png";
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;
    private final Vector2 initialPos;
    private BirdState state = BirdState.init;

    public Bird(Vector2 position) {
        super(position, WIDTH, HEIGHT, SPRITE_NAME, new Vector2(0, 0));
        initialPos = position;
    }

    @Override
    public void accelerate(float dt) {
        speed.y += Gravity * dt;
    }

    @Override
    public void move(float dt) {
        if (state == BirdState.fly || state == BirdState.dead) {
            if (getY() < 0) {
                reset();
                return;
            }

            super.move(dt);
        }
    }

    public void reset() {
        state = BirdState.init;
        setPosition(initialPos.x, initialPos.y);
        speed = new Vector2(0, 0);
    }

    public BirdState getState() {
        return state;
    }

    public void aim() {
        state = BirdState.aim;
    }

    public void release(Vector2 position) {
        state = BirdState.fly;
        speed = new Vector2(initialPos.x - position.x, initialPos.y - position.y).scl(3);
    }

    public void kill() {
        state = BirdState.dead;
        speed = new Vector2(-speed.x, speed.y);
    }

    public enum BirdState {init, aim, fly, dead}
}
