package ch.ansermgw.angryword.activities;

import ch.ansermgw.angryword.AngrywordMain;
import ch.ansermgw.angryword.models.*;
import ch.ansermgw.angryword.provider.VocabularyProvider;
import ch.ansermgw.angryword.resource.VocabularyResource;
import ch.ansermgw.angryword.resource.WordResource;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Play extends Activity {
    public static final int WORLD_WIDTH = 1600;
    public static final int WORLD_HEIGHT = 900;
    public static final int FLOOR_HEIGHT = 150;
    public static final Vector2 BIRD_SPAWN = new Vector2(200, FLOOR_HEIGHT + 200);

    private Bird bird;
    private Wasp wasp;
    private Scenery scenery;
    private VocabularyResource vocabulary;
    private Bubble bubble;
    private Panel panel;
    private Button pauseBtn;
    private BitmapFont langSelected;

    private final VocabularyResource vocGame;
    private final Language langFrom;
    private final Language langTo;

    public Play(VocabularyResource vocGame, Language langFrom, Language langTo) {
        this.vocGame = vocGame;
        this.langFrom = langFrom;
        this.langTo = langTo;


    }

    @Override
    public void create() {
        super.create();

        vocabulary = VocabularyProvider.getInstance().getRandomVocabulary();

        scenery = new Scenery(vocabulary);
        scenery.addFloor();
        scenery.addTnt();
        scenery.addPig();

        bird = new Bird(BIRD_SPAWN);
        wasp = new Wasp(new Vector2(Math.abs(WORLD_WIDTH / 3), Math.abs(WORLD_HEIGHT / 2)));

        panel = new Panel(new Vector2(Math.abs(WORLD_WIDTH / 15), WORLD_HEIGHT - Panel.HEIGHT), vocabulary.getRandomUsedWordResource().getLanguageValue(langFrom));

        langSelected = new BitmapFont();
        langSelected.setColor(Color.BLUE);
        langSelected.getData().setScale(5);

        pauseBtn = new Button(new Vector2(
                Math.abs(WORLD_WIDTH - 2 * WORLD_WIDTH / 15),
                WORLD_HEIGHT - Math.abs(Panel.HEIGHT / 2)
        ), "Pause");
    }

    private void update() {
        float dt = Gdx.graphics.getDeltaTime();

        bird.accelerate(dt);
        bird.move(dt);
        handleBirdCollision();

        wasp.accelerate(dt);
        wasp.move(dt);
    }

    @Override
    public void render() {
        super.render();
        update();

        bird.draw(super.batch);
        wasp.draw(super.batch);
        scenery.draw(super.batch);
        panel.draw(super.batch);
        langSelected.draw(
                super.batch,
                "Pratique de " + langFrom.getDisplayLanguage() + " en " + langTo.getDisplayLanguage(),
                Math.abs(WORLD_WIDTH / 4), Math.abs(WORLD_HEIGHT - 100)
        );
        pauseBtn.draw(super.batch);

        if (bubble != null)
            bubble.draw(super.batch);

        super.batch.end();
    }

    private void handleBirdCollision() {
        if (bird.getState() != Bird.BirdState.fly) {
            return;
        }

        if (bird.isCollidingTo(wasp)) {
            bird.kill();
            return;
        }

        for (PhysicalObject element : scenery.getElements()) {
            if (!(element instanceof Slingshot) && bird.isCollidingTo(element)) {
                bird.kill();

                if (element instanceof Pig) {
                    scenery.removeElement(element);
                    Pig pig = ((Pig) element);
                    pig.kill();

                    SemanticWord wordResource = vocabulary.getRandomUsedWordResource();

                    if (panel.getWordPanel().equals(pig.getWord().getLanguageValue(langFrom)) && wordResource != null) {
                        this.panel.setWordPanel(wordResource.getLanguageValue(langFrom));
                    } else {
                        AngrywordMain.getInstance().pop();
                    }

                    bird.reset();
                }

                break;
            }


        }
    }

    @Override
    public void dispose() {
        super.dispose();
        this.vocabulary.reset();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        bubble = null;
        Vector2 touchPosition = super.getAbsolutePosition(screenX, screenY);

        if (bird.getState() == Bird.BirdState.init && super.isPhysicalObjectContainingVector(bird, touchPosition)) {
            bird.aim();
            return true;
        }

        for (PhysicalObject physicalObject : scenery.getElements()) {
            if (physicalObject instanceof Pig && super.isPhysicalObjectContainingVector(physicalObject, touchPosition)) {
                bubble = new Bubble(
                        new Vector2(
                                physicalObject.getX() - physicalObject.getWidth(),
                                physicalObject.getY() + physicalObject.getHeight()
                        ),
                        ((Pig) physicalObject).getWord().getLanguageValue(langTo)
                );
                return true;
            }
        }

        if (super.isPhysicalObjectContainingVector(pauseBtn, touchPosition)) {
            Activity pause = new Pause();
            pause.create();
            AngrywordMain.getInstance().push(pause);
            return true;
        }

        // if touch no element and bird is flying or dead then reset bird
        if (bird.getState() == Bird.BirdState.fly || bird.getState() == Bird.BirdState.dead) {
            bird.reset();
        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (bird.getState() == Bird.BirdState.aim) {
            bird.release(super.getAbsolutePosition(screenX, screenY));
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if (bird.getState() == Bird.BirdState.aim) {
            Vector2 pos = limitPositionToShootingZone(super.getAbsolutePosition(screenX, screenY));

            bird.setPosition(pos.x, pos.y);
        }

        return true;
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

    private Vector2 limitPositionToShootingZone(Vector2 position) {
        return new Vector2(
                Math.min(Math.max(0, position.x), BIRD_SPAWN.x),
                Math.min(Math.max(FLOOR_HEIGHT, position.y), BIRD_SPAWN.y)
        );
    }
}
