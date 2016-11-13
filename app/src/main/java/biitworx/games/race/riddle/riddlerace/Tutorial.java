package biitworx.games.race.riddle.riddlerace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Tutorial extends AppCompatActivity {

    private TutorialView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        view = (TutorialView)findViewById(R.id.tutorial);
        if(view!=null)
            view.view = this;


        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(view!=null)
                            view.invalidate();
                    }
                });
            }
        },50,50);
    }
}
