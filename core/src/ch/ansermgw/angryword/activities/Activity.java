package ch.ansermgw.angryword.activities;

import ch.ansermgw.angryword.models.PhysicalObject;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import static ch.ansermgw.angryword.activities.Play.WORLD_HEIGHT;
import static ch.ansermgw.angryword.activities.Play.WORLD_WIDTH;

public abstract class Activity extends Game implements InputProcessor {
    protected static final String BACKGROUND_NAME = "background.jpg";
    protected Texture background;
    protected SpriteBatch batch;
    protected OrthographicCamera camera;

    @Override
    public void create() {
        batch = new SpriteBatch();

        background = new Texture(BACKGROUND_NAME);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();
    }

    //Do not forget to call batch.end(); !
    @Override
    public void render() {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    protected boolean isPhysicalObjectContainingVector(PhysicalObject physicalObject, Vector2 vector) {
        return physicalObject.getBoundingRectangle().contains(vector);
    }

    protected Vector2 getAbsolutePosition(int x, int y) {
        Vector3 pos = camera.unproject(new Vector3(x, y, 0));
        return new Vector2(pos.x, pos.y);
    }
}
