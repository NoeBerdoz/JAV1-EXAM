package ch.ansermgw.angryword.activities;

import ch.ansermgw.angryword.AngrywordMain;
import ch.ansermgw.angryword.models.Button;
import ch.ansermgw.angryword.models.Language;
import ch.ansermgw.angryword.provider.VocabularyProvider;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

import static ch.ansermgw.angryword.activities.Play.WORLD_HEIGHT;
import static ch.ansermgw.angryword.activities.Play.WORLD_WIDTH;

public class Welcome extends Activity {
    private BitmapFont title;
    private BitmapFont choiceTitle;
    private VocabularyProvider vocabularyProvider;
    private List<Button> buttonLangFrom;
    private List<Button> buttonLangTo;

    private Language langFrom;
    private Language langTo;

    @Override
    public void create() {
        super.create();
        this.vocabularyProvider = VocabularyProvider.getInstance();
        buttonLangFrom = new ArrayList<>();
        buttonLangTo = new ArrayList<>();

        int index = 0;

        for (Language language : vocabularyProvider.getLanguages()) {
            float yPos = WORLD_HEIGHT - (2 + index) * Math.abs(WORLD_HEIGHT / 4);
            buttonLangFrom.add(new Button(new Vector2(Math.abs(WORLD_WIDTH / 4), yPos), language.getDisplayLanguage()));
            buttonLangTo.add(new Button(new Vector2(Math.abs(WORLD_WIDTH / 4), yPos), language.getDisplayLanguage()));
            index++;
        }

        title = new BitmapFont();
        title.setColor(Color.RED);
        title.getData().setScale(7);

        choiceTitle = new BitmapFont();
        choiceTitle.setColor(Color.RED);
        choiceTitle.getData().setScale(3);
    }

    @Override
    public void render() {
        super.render();
        List<Button> allButtons = new ArrayList<>();
        String langFromChoice;
        String langToChoice;

        if (langFrom == null) {
            langFromChoice = " choisir ";
            allButtons.addAll(buttonLangFrom);
        } else {
            langFromChoice = langFrom.getDisplayLanguage();
        }
        if (langTo == null) {
            langToChoice = " choisir ";
            allButtons.addAll(buttonLangTo);
        } else {
            langToChoice = langTo.getDisplayLanguage();
        }

        title.draw(super.batch, "Angry Wirds", Math.abs(WORLD_WIDTH / 3), Math.abs(WORLD_HEIGHT - 50));
        choiceTitle.draw(
            super.batch,
                "Exercice de " + langFromChoice + " en " + langToChoice,
                Math.abs(WORLD_WIDTH / 4),
                WORLD_HEIGHT - 200
        );

        for (Button button : allButtons) {
            button.draw(super.batch);
        }

        super.batch.end();
    }

    private Language getButtonLanguage(List<Button> langBtn, Vector2 touched) {
        for (Button button : langBtn) {
            if (isPhysicalObjectContainingVector(button, touched)) {
                for (Language language : vocabularyProvider.getLanguages()) {
                    if (language.getDisplayLanguage().equals(button.getValue())) {
                        return language;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        /* REMETTRE CETTE PARTIE POUR POUVOIR ACCEDER à L'ACTIVITY PLAY
        Activity play = new Play(
                vocabularyProvider.getRandomVocabulary(),
                vocabularyProvider.getLanguages().get(0),
                vocabularyProvider.getLanguages().get(1)
        );
        play.create();
        AngrywordMain.getInstance().push(play);*/
        Vector2 touchPos = getAbsolutePosition(screenX, screenY);
        Language touchedLangButtonFrom = getButtonLanguage(buttonLangFrom, touchPos);

        if (touchedLangButtonFrom != null) {
            langFrom = touchedLangButtonFrom;
                    return true;
        }


        Language touchedLangButtonTo = getButtonLanguage(buttonLangTo, touchPos);
        if (touchedLangButtonTo != null) {
            langTo = touchedLangButtonTo;
            return true;
        }
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
