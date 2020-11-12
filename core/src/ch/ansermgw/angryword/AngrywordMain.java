package ch.ansermgw.angryword;

import ch.ansermgw.angryword.activities.Activity;
import ch.ansermgw.angryword.activities.Welcome;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import java.util.Enumeration;
import java.util.Stack;

public class AngrywordMain extends Game {
    private static AngrywordMain instance;
    private static Stack<Activity> activities;

    private AngrywordMain() {
    }

    public static AngrywordMain getInstance() {
        if (instance == null) {
            instance = new AngrywordMain();
        }

        return instance;
    }

    private void updateInputProcessor() {
        Gdx.input.setInputProcessor(activities.peek());
    }

    public void push(Activity activity) {
        activities.push(activity);
        updateInputProcessor();
    }

    public void pop() {
        activities.pop();
        updateInputProcessor();
    }

    @Override
    public void create() {
        activities = new Stack<>();

        Activity welcome = new Welcome();
        welcome.create();

        push(welcome);
    }

    @Override
    public void render() {
        activities.peek().render();
    }

    @Override
    public void dispose() {
        Enumeration<Activity> activitiesEnum = activities.elements();

        while (activitiesEnum.hasMoreElements()) {
            Game nextActivity = activitiesEnum.nextElement();
            nextActivity.dispose();
        }
    }
}
