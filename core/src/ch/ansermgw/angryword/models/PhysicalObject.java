package ch.ansermgw.angryword.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class PhysicalObject extends Sprite {
    public PhysicalObject(Vector2 position, float width, float height, String spriteName) {
        super(new Texture(spriteName));
        setBounds(position.x, position.y, width, height);
    }

    public boolean isCollidingTo(PhysicalObject otherObject) {
        return isCollidingTo(otherObject.getBoundingRectangle());
    }

    public boolean isCollidingTo(Rectangle otherHibox) {
        return getBoundingRectangle().overlaps(otherHibox);
    }

}
