package biitworx.games.race.riddle.riddlerace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import biitworx.games.race.riddle.riddlerace.data.helper.poco.Level;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.Levels;

public class MainView extends AppCompatActivity {

    Runnable update;
    Runnable update2;

    static Timer time;
    int count = 3;
private Level level;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                PlacementCircleView place = (PlacementCircleView) findViewById(R.id.place);
                if (place != null) {
                    findLevel();
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

    private void findLevel(){
        PlacementCircleView place = (PlacementCircleView) findViewById(R.id.place);
        if (place != null) {
            level = Levels.getLevel(place.name);
            if(level==null){
                level=new Level(place.name,place.min,place.med,place.max);
                Levels.addLevel(level);
            }
        }
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

        PlacementCircleView place = (PlacementCircleView) findViewById(R.id.place);
        if (place != null) {
            place.setView(this);
            place.invalidate();
        }

    }

    public void updateView() {

        PlacementCircleView place = (PlacementCircleView) findViewById(R.id.place);
        if (place != null) {
            place.setView(this);


            if (place.hasHit()) {
                time.cancel();
                place.crashed = true;

                level.setScore(place.rounds);
                Levels.updateLevel(level);

            } else {


                for (CircleView view : place.allViews()) {
                    view.move();
                    view.invalidate();
                }
            }
            place.invalidate();
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        count=3;
        if(time!=null)time.cancel();
        PlacementCircleView place = (PlacementCircleView) findViewById(R.id.place);

    }
}
