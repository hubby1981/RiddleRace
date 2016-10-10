package biitworx.games.race.riddle.riddlerace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainView extends AppCompatActivity {

    Runnable update;
    Timer time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);
        update=new Runnable() {
            @Override
            public void run() {
                updateView();
            }
        };

time=new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(update);
            }
        },1,20);

    }


    public void updateView(){

        PlacementCircleView place = (PlacementCircleView)findViewById(R.id.place);
        if(place!=null){

            place.invalidate();
        }
        CircleView view = (CircleView)findViewById(R.id.circle);
        if(view!=null){
            view.move();
            view.invalidate();
        }

        CircleView view2 = (CircleView)findViewById(R.id.circle2);
        if(view2!=null){
            view2.move();
            view2.invalidate();
        }

        CircleView view3 = (CircleView)findViewById(R.id.circle3);
        if(view3!=null){
            view3.move();
            view3.invalidate();
        }

        if(place!=null&&place.hasHit()){
            time.cancel();
        }
    }
}
