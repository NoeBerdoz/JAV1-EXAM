package ch.ansermgw.angryword.models;

import com.badlogic.gdx.math.Vector2;

import static ch.ansermgw.angryword.activities.Play.WORLD_HEIGHT;

public abstract class MovingObject extends PhysicalObject {
    protected final static double Gravity = -(WORLD_HEIGHT / 4.0);

    protected Vector2 speed;
    private boolean frozen;

    public MovingObject(Vector2 position, float width, float height, String spriteName, Vector2 speed) {
        super(position, width, height, spriteName);
        this.speed = speed;
    }

    public void move(float dt) {
        translate(speed.x * dt, speed.y * dt);
    }

    public abstract void accelerate(float dt);

    protected boolean isFrozen() {
        return frozen;
    }

    protected void setFrozen(boolean frozen) {
        frozen = frozen;
    }
}
