package ch.ansermgw.angryword.activities;

import ch.ansermgw.angryword.AngrywordMain;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import static ch.ansermgw.angryword.activities.Play.WORLD_HEIGHT;
import static ch.ansermgw.angryword.activities.Play.WORLD_WIDTH;

public class Pause extends Activity {
    private BitmapFont title;

    @Override
    public void create() {
        super.create();

        title = new BitmapFont();
        title.setColor(Color.RED);
        title.getData().setScale(7);
    }

    @Override
    public void render() {
        super.render();
        title.draw(super.batch, "Pause screen", Math.abs(WORLD_WIDTH / 2), Math.abs(WORLD_HEIGHT / 2));
        super.batch.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        AngrywordMain.getInstance().pop();
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
