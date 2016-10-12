package biitworx.games.race.riddle.riddlerace;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import biitworx.games.race.riddle.riddlerace.data.helper.DbHelper;
import biitworx.games.race.riddle.riddlerace.levels.basic.Level_1;
import biitworx.games.race.riddle.riddlerace.levels.basic.Level_2;
import biitworx.games.race.riddle.riddlerace.levels.basic.Level_3;

public class LevelChooser extends AppCompatActivity {

    public static DbHelper DATA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_chooser);
        DATA = new DbHelper(this);

    }

    private void checkCam(){
       /* if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        1);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }*/
    }


    public void level1(View view) {

        openActivity(Level_1.class);
    }

    private void openActivity(Class clazz) {
        Intent level = new Intent(this, clazz);
        PlacementCircleView.start();
        startActivity(level);
    }

    public void level2(View view) {
        openActivity(Level_2.class);

    }

    public void level3(View view) {

       openActivity(Level_3.class);

    }
}
