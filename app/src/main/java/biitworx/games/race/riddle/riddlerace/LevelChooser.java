package biitworx.games.race.riddle.riddlerace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import biitworx.games.race.riddle.riddlerace.data.helper.DbHelper;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.Level;
import biitworx.games.race.riddle.riddlerace.levels.basic.LevelPlay;


public class LevelChooser extends AppCompatActivity {

    private Timer time;
    private Runnable update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainMenu.that = this;
        setContentView(R.layout.activity_level_chooser);
        LevelView view = (LevelView) findViewById(R.id.view);
        view.instance = this;


        update = new Runnable() {
            @Override
            public void run() {
                LevelView view = (LevelView) findViewById(R.id.view);
                view.invalidate();
            }
        };

        time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(update);
            }
        }, 1000, 250);
    }

    public void openActivity(Level levelItem) {
        Intent level = new Intent(this, LevelPlay.class);
        MainMenu.levelItem = levelItem;
        startActivity(level);
    }


}
