package biitworx.games.race.riddle.riddlerace;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;
import java.util.UUID;

import biitworx.games.race.riddle.riddlerace.data.helper.DbHelper;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.Level;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.User;

public class MainMenu extends AppCompatActivity {

    public static DbHelper DATA;
    public static Resources res;
    public static Level levelItem;
    public static LevelChooser that;
    public static Bitmap back001;
    public static Bitmap back002;
    public static User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainMenu.DATA = new DbHelper(this);
        MainMenu.res = getResources();
        MainMenu.back001 = B.get(R.drawable.back1);
        MainMenu.back002 = B.get(R.drawable.back2);
        checkUser();
        setContentView(R.layout.activity_main_menu);

        MainMenuView view = (MainMenuView) findViewById(R.id.viewMenu);
        if (view != null)
            view.menu = this;

    }


    private void checkUser() {
        List<User> u = DATA.getData(User.class, DATA.get(), true);
        if (u == null || u.size() == 0) {
            user = new User("USER" + String.valueOf(UUID.randomUUID().hashCode()), "generated");
            DATA.insert(user, true, DATA.get());
        }
    }

    public static void updateUser() {
        if (user != null) {
            DATA.insert(user, false, DATA.get());

        }
    }
}
