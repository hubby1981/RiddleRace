package biitworx.games.race.riddle.riddlerace;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import biitworx.games.race.riddle.riddlerace.data.helper.DbHelper;
import biitworx.games.race.riddle.riddlerace.data.helper.JSONHelper;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.Level;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.LevelSet;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.Levels;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.User;
import biitworx.games.race.riddle.riddlerace.shop.GoogleShopService;

import static biitworx.games.race.riddle.riddlerace.data.helper.poco.Levels.*;

public class MainMenu extends AppCompatActivity {

    public static DbHelper DATA;
    public static Resources res;
    public static Level levelItem;
    public static LevelChooser that;
    public static Bitmap back001;
    public static Bitmap back002;
    public static User user;
    public static String myName = "";
    public static GoogleShopService shop;
    public static boolean edit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myName = getPackageName();
        shop = new GoogleShopService();

        Intent serviceIntent =
                new Intent("com.android.vending.billing.InAppBillingService.BIND");
        serviceIntent.setPackage("com.android.vending");
        bindService(serviceIntent, shop.serviceConnection, Context.BIND_AUTO_CREATE);

        MainMenu.DATA = new DbHelper(this);
        MainMenu.res = getResources();
        MainMenu.back001 = B.get(R.drawable.back1);
        MainMenu.back002 = B.get(R.drawable.back2);
        checkUser();
        setContentView(R.layout.activity_main_menu);

        MainMenuView view = (MainMenuView) findViewById(R.id.viewMenu);
        if (view != null)
            view.menu = this;

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                update();
            }
        },500,50);

    }


    public void update(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try{
                findViewById(R.id.viewMenu).invalidate();}
                catch (Exception e){}
            }
        });
    }


    private void checkUser() {
        List<User> u = DATA.getData(User.class, DATA.get(), true);
        if (u == null || u.size() == 0) {
            user = new User("USER" + String.valueOf(UUID.randomUUID().hashCode()), "generated");
            DATA.insert(user, true, DATA.get());
        }else{
            user=u.get(0);
        }
    }

    public static void updateUser() {
        if (user != null) {
            DATA.insert(user, false, DATA.get());

        }
    }

    public void sendMail() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("plain/text");


        JSONObject o = JSONHelper.mapFromObject(Levels.all);

        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"marcel.weissgerber@live.de"});
        i.putExtra(Intent.EXTRA_SUBJECT, "DATA");
        i.putExtra(Intent.EXTRA_TEXT, o.toString());
        startActivity(Intent.createChooser(i, "E-mail"));


    }
}
