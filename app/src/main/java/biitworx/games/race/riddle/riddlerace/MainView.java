package biitworx.games.race.riddle.riddlerace;

import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadFactory;

import biitworx.games.race.riddle.riddlerace.data.helper.poco.Circle;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.Level;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.Levels;

public abstract class MainView extends AppCompatActivity {

    Runnable update;
    Runnable update2;

    static Timer time;
    int count = 3;
    private Level level;

    private ArrayList<CircleView> views = new ArrayList<>();
    private PlacementCircleView place;

    public void add(CircleView view) {
        views.add(view);

    }

    public void addPlacement(PlacementCircleView place) {
        this.place = place;
        findLevel();
        this.setContentView(place);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        update = new Runnable() {
            @Override
            public void run() {
                updateView();
            }
        };
        update2 = new Runnable() {
            @Override
            public void run() {
                updateView2();
            }
        };
        count = 3;

        time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {

                if (place != null) {


                    place.count = count - 1;
                    runOnUiThread(update2);
                    count--;
                    if (count == 0) {
                        place.count = 0;
                        newRun();

                    }
                }

            }
        }, 1000, 1000);


    }

    protected abstract void initViews();

    protected void findLevel() {
        level = MainMenu.levelItem;
        place.level = level;
    }

    public void newRun() {
        if (count == 0) {
            if (time != null) time.cancel();
            time = new Timer();
            time.schedule(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(update);
                }
            }, 1, 20);
        }
    }

    public void updateView2() {


        if (place != null) {
            place.setView(this);
            place.invalidate();
        }

    }

    public void updateView() {


        if (place != null) {
            place.setView(this);

            if (!place.crashed) {
                if (place.hasHit()) {
                    time.cancel();
                    place.crashed = true;

                    if (level != null && level.getScore() < place.rounds) {
                        Runnable r = new Runnable() {
                            @Override
                            public void run() {
                                level.setScore(place.rounds);
                                Levels.updateLevel(level, false);
                            }
                        };
                        Thread t = new Thread(r);
                        t.setPriority(Thread.MIN_PRIORITY);
                        t.start();
                    }


                } else {


                    for (CircleView view : place.allViews()) {
                        view.move();

                    }
                }
            }
            place.invalidate();
        }

    }

    @NonNull
    protected PlacementCircleView getPlacementCircleView(String idName) {

        PlacementCircleView place = new PlacementCircleView(getApplicationContext(), idName);
        place.start(level);

        addPlacement(place);

        for (Circle c : level.getCircles()) {
            place.addAll(new CircleView(place, Levels.getRedArray()[c.getColor()], Levels.getGreenArray()[c.getColor()], Levels.getBlueArray()[c.getColor()], c.getMover(), c.getPosx(), c.getPosy(), c.getDirection(), c.getLength(), c.getInverse(), c.getPosition(), c.getNext(), c.getFaktor(), c.getFreaky()));
        }
        return place;
    }

    @Override
    public void onPause() {
        super.onPause();
        count = 3;
        place.start(level);
        if (time != null)
            time.cancel();

        finish();

    }

}
