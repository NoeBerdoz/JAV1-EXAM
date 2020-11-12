package ch.ansermgw.angryword.models;

import ch.ansermgw.angryword.activities.Play;
import ch.ansermgw.angryword.exception.OutOfSceneryException;
import ch.ansermgw.angryword.resource.VocabularyResource;
import ch.ansermgw.angryword.resource.WordResource;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class Scenery {
    private static final int BLOCK_SIZE = 50;
    private final ArrayList<PhysicalObject> elements;
    private final VocabularyResource vocabulary;

    public Scenery(VocabularyResource vocabulary) {
        this.vocabulary = vocabulary;
        elements = new ArrayList<>();
    }

    public void addElement(PhysicalObject el) {
        elements.add(el);
    }

    public void removeElement(PhysicalObject el) {
        elements.remove(el);
    }

    public void addFloor() {
        for (int i = 0; i < 20; i++) {
            Vector2 position = generateRandomItemPosition();
            addElement(new Block(position));
        }

        addElement(new Slingshot(new Vector2(Play.BIRD_SPAWN.x - 25, Play.BIRD_SPAWN.y - 225)));
    }

    public ArrayList<PhysicalObject> getElements() {
        return elements;
    }

    public void addPig() {
        //used to limit the number of time it try to place a pig
        int nbIteration = 0;
        int pigCount = 0;

        while (pigCount < 3 && nbIteration < 100) {
            WordResource wordResource = vocabulary.getRandomUnusedWordResource();

            try {
                PhysicalObject element = elements.get(Play.rand.nextInt(elements.size()));

                Vector2 position = generateRandomItemPosition(
                        Math.round(element.getX()),
                        Math.round(element.getY())
                );

                Pig pig = new Pig(position, wordResource);
                wordResource.setUsed(true);
                addElement(pig);
                pigCount++;
            } catch (OutOfSceneryException e) {
                System.out.println("One pig is already on this x position");
            }

            nbIteration++;
        }
    }

    public void addTnt() {
        for (int i = 0; i < 10; i++) {
            Vector2 position = generateRandomItemPosition();
            addElement(new Tnt(position));
        }
    }

    private Vector2 generateRandomItemPosition() {
        Vector2 position = null;
        int startX = Math.round(Play.BIRD_SPAWN.x) * 2;

        while (position == null) {
            try {
                int randomeX = startX + Play.rand.nextInt(Play.WORLD_WIDTH - startX - 100);
                int startY = Play.FLOOR_HEIGHT;

                position = generateRandomItemPosition(randomeX, startY);
            } catch (OutOfSceneryException ignored) {
            }
        }

        return position;
    }

    private Vector2 generateRandomItemPosition(int x, int startY) throws OutOfSceneryException {
        for (PhysicalObject element : elements) {
            Rectangle rec = element.getBoundingRectangle();

            if (rec.overlaps(new Rectangle(x, startY, BLOCK_SIZE, BLOCK_SIZE))) {
                return generateRandomItemPosition(x, Math.round(rec.y + rec.height + 5));
            }
        }

        if (startY > Play.WORLD_HEIGHT / 2) {
            throw new OutOfSceneryException("Space filled");
        }

        return new Vector2(x, startY);
    }

    public void draw(Batch batch) {
        for (PhysicalObject p : elements) p.draw(batch);
    }
}
