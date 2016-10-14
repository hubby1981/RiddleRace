package biitworx.games.race.riddle.riddlerace;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.res.Resources;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

import biitworx.games.race.riddle.riddlerace.data.helper.DbHelper;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.Level;


public class LevelChooser extends AppCompatActivity {

    public static DbHelper DATA;

    public static Resources res;

    private Timer time;
    private Runnable update;

    public static Level levelItem;

    public static LevelChooser that;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        that = this;
        DATA = new DbHelper(this);
        res = getResources();
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

    public void openActivity(Class clazz, Level levelItem) {
        Intent level = new Intent(this, clazz);
        this.levelItem = levelItem;
        startActivity(level);
    }


}
