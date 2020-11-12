package ch.ansermgw.angryword.models;

import ch.ansermgw.angryword.resource.WordResource;
import com.badlogic.gdx.math.Vector2;

public class Panel extends TextualObject {
    public static final int WIDTH = 510 / 2;
    public static final int HEIGHT = 486 / 2;
    private static final String SPRITE_NAME = "panel.png";
    private WordResource wordResource;
    private String wordPanel;

    public Panel(Vector2 position, String wordPanel) {
        super(position, WIDTH, HEIGHT, SPRITE_NAME, wordPanel, new Vector2(0, -Math.abs(HEIGHT / 4)));
        this.wordPanel = wordPanel;
    }

    public String getWordPanel() {
        return wordPanel;
    }

    public void setWordPanel(String wordPanel) {
      this.wordPanel = wordPanel;
      this.glyphLayout.setText(font, wordPanel);
    }

    public WordResource getWordResource() {
        return wordResource;
    }

    public void setWordResource(WordResource wordResource) {
        this.wordResource = wordResource;
        this.glyphLayout.setText(font, wordResource.getWord());
    }
}
