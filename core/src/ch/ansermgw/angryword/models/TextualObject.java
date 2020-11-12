package ch.ansermgw.angryword.models;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;

public class TextualObject extends PhysicalObject {
    protected BitmapFont font;
    protected GlyphLayout glyphLayout;
    private Vector2 fontOffset;

    public TextualObject(Vector2 position, float width, float height, String spriteName, String text, Vector2 fontOffset) {
        this(position, width, height, spriteName, text);
        this.fontOffset = fontOffset;
    }

    public TextualObject(Vector2 position, float width, float height, String spriteName, String text) {
        super(position, width, height, spriteName);

        font = new BitmapFont();
        font.getData().setScale(2f);
        font.setColor(Color.BLACK);

        glyphLayout = new GlyphLayout(font, text);

        this.fontOffset = Vector2.Zero;
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
        font.draw(
                batch,
                glyphLayout,
                getX() + ((getWidth() - glyphLayout.width) / 2) + fontOffset.x,
                getY() + ((getHeight() + glyphLayout.height * 2) / 2) + fontOffset.y);
    }
}
