package biitworx.games.race.riddle.riddlerace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class LevelEditor extends AppCompatActivity {
    private Timer time;
    private Runnable update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_editor);
        LevelEditorView view = (LevelEditorView) findViewById(R.id.editor);
        view.view=this;
        update = new Runnable() {
            @Override
            public void run() {
                LevelEditorView view = (LevelEditorView) findViewById(R.id.editor);

                view.invalidate();
            }
        };

        time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(update);
            }
        }, 1000, 50);
    }
}
