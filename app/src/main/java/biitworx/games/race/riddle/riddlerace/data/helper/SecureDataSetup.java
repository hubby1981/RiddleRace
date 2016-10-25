package biitworx.games.race.riddle.riddlerace.data.helper;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import biitworx.games.race.riddle.riddlerace.MainMenu;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.Circle;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.Level;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.LevelSet;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.User;


/**
 * Created by marce_000 on 28.05.2016.
 */
public class SecureDataSetup {


    List<Class> secureDataList = new ArrayList<>();


    public SecureDataSetup() {

        ///TODO: tables to add
/*
        secureDataList.add(Level.class);
        secureDataList.add(Circle.class);
        secureDataList.add(LevelSet.class);
        secureDataList.add(User.class);*/
    }

    public HashMap<String, List<Object>> getAll(SQLiteDatabase db) {
        HashMap<String, List<Object>> all = new HashMap<>();
        for (Class c : secureDataList) {
            all.put(c.getSimpleName(), MainMenu.DATA.getData(c, db, true));
        }
        return all;
    }

    public void reInsertData(HashMap<String, List<Object>> all, SQLiteDatabase db) {
        for (Map.Entry<String, List<Object>> e : all.entrySet()) {
            for (Object o : e.getValue()) {
                MainMenu.DATA.insert(o, true, db);
            }
        }
    }
}
