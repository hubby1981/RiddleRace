package biitworx.games.race.riddle.riddlerace.data.helper.poco;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import biitworx.games.race.riddle.riddlerace.MainMenu;
import biitworx.games.race.riddle.riddlerace.R;
import biitworx.games.race.riddle.riddlerace.TE;
import biitworx.games.race.riddle.riddlerace.data.helper.ObjectHelper;


/**
 * Created by marce_000 on 12.10.2016.
 */
public class Levels {

    static String base ="{\"sets\":[{\"name\":\"Basic\",\"stars\":40,\"collected\":3,\"editable\":false,\"levels\":[{\"name\":\"Level 1 - Start\",\"min\":10,\"med\":20,\"max\":30,\"score\":0,\"next\":\"Level 1 - unbekannt\",\"editable\":true,\"circles\":[{\"mover\":2,\"posx\":20,\"posy\":0,\"direction\":1,\"length\":1,\"inverse\":10,\"position\":270,\"next\":10,\"faktor\":2,\"pointx\":0,\"pointy\":2,\"color\":0,\"freaky\":0},{\"mover\":2,\"posx\":20,\"posy\":0,\"direction\":2,\"length\":1,\"inverse\":5,\"position\":90,\"next\":5,\"faktor\":2,\"pointx\":4,\"pointy\":2,\"color\":1,\"freaky\":25}]},{\"name\":\"Level 2 - Rings\",\"min\":10,\"med\":20,\"max\":30,\"score\":0,\"next\":\"Level 2 - unbekannt\",\"editable\":true,\"circles\":[{\"mover\":2,\"posx\":10,\"posy\":10,\"direction\":1,\"length\":1,\"inverse\":10,\"position\":0,\"next\":10,\"faktor\":2,\"pointx\":1,\"pointy\":1,\"color\":0,\"freaky\":0},{\"mover\":2,\"posx\":10,\"posy\":10,\"direction\":0,\"length\":1,\"inverse\":5,\"position\":80,\"next\":5,\"faktor\":2,\"pointx\":3,\"pointy\":3,\"color\":1,\"freaky\":50}]},{\"name\":\"Level 3 - Fallout\",\"min\":20,\"med\":30,\"max\":40,\"score\":0,\"next\":\"Level 3 - unbekannt\",\"editable\":true,\"circles\":[{\"mover\":4,\"posx\":10,\"posy\":0,\"direction\":1,\"length\":1,\"inverse\":10,\"position\":320,\"next\":10,\"faktor\":2,\"pointx\":1,\"pointy\":2,\"color\":0,\"freaky\":0},{\"mover\":5,\"posx\":10,\"posy\":0,\"direction\":2,\"length\":1,\"inverse\":10,\"position\":40,\"next\":10,\"faktor\":2,\"pointx\":3,\"pointy\":2,\"color\":2,\"freaky\":0}]},{\"name\":\"Level 4 - Hazard\",\"min\":30,\"med\":50,\"max\":70,\"score\":0,\"next\":\"Level 4 - unbekannt\",\"editable\":true,\"circles\":[{\"mover\":3,\"posx\":20,\"posy\":10,\"direction\":3,\"length\":1,\"inverse\":10,\"position\":70,\"next\":10,\"faktor\":2,\"pointx\":0,\"pointy\":3,\"color\":1,\"freaky\":16},{\"mover\":1,\"posx\":20,\"posy\":10,\"direction\":0,\"length\":1,\"inverse\":10,\"position\":260,\"next\":10,\"faktor\":2,\"pointx\":4,\"pointy\":3,\"color\":7,\"freaky\":5},{\"mover\":2,\"posx\":0,\"posy\":10,\"direction\":2,\"length\":1,\"inverse\":10,\"position\":0,\"next\":10,\"faktor\":2,\"pointx\":2,\"pointy\":1,\"color\":3,\"freaky\":20}]},{\"name\":\"Level 5 - Funny\",\"min\":30,\"med\":40,\"max\":50,\"score\":0,\"next\":\"Level 5 - unbekannt\",\"editable\":true,\"circles\":[{\"mover\":3,\"posx\":10,\"posy\":10,\"direction\":1,\"length\":1,\"inverse\":10,\"position\":0,\"next\":10,\"faktor\":2,\"pointx\":1,\"pointy\":1,\"color\":0,\"freaky\":0},{\"mover\":2,\"posx\":10,\"posy\":10,\"direction\":3,\"length\":1,\"inverse\":10,\"position\":0,\"next\":10,\"faktor\":2,\"pointx\":1,\"pointy\":3,\"color\":5,\"freaky\":0},{\"mover\":4,\"posx\":10,\"posy\":0,\"direction\":2,\"length\":1,\"inverse\":10,\"position\":50,\"next\":10,\"faktor\":2,\"pointx\":3,\"pointy\":2,\"color\":2,\"freaky\":30}]},{\"name\":\"Level 6 - Snowman\",\"min\":40,\"med\":60,\"max\":80,\"score\":0,\"next\":\"Level 6 - unbekannt\",\"editable\":true,\"circles\":[{\"mover\":1,\"posx\":0,\"posy\":10,\"direction\":2,\"length\":1,\"inverse\":7,\"position\":0,\"next\":7,\"faktor\":2,\"pointx\":2,\"pointy\":1,\"color\":7,\"freaky\":0},{\"mover\":2,\"posx\":0,\"posy\":0,\"direction\":0,\"length\":1,\"inverse\":10,\"position\":70,\"next\":10,\"faktor\":2,\"pointx\":2,\"pointy\":2,\"color\":1,\"freaky\":0},{\"mover\":2,\"posx\":0,\"posy\":10,\"direction\":3,\"length\":1,\"inverse\":10,\"position\":0,\"next\":10,\"faktor\":2,\"pointx\":2,\"pointy\":3,\"color\":3,\"freaky\":0}]},{\"name\":\"Level 7 - Pyramid\",\"min\":30,\"med\":40,\"max\":50,\"score\":0,\"next\":\"Level 7 - unbekannt\",\"editable\":true,\"circles\":[{\"mover\":3,\"posx\":0,\"posy\":10,\"direction\":2,\"length\":1,\"inverse\":10,\"position\":0,\"next\":10,\"faktor\":2,\"pointx\":2,\"pointy\":1,\"color\":0,\"freaky\":0},{\"mover\":2,\"posx\":10,\"posy\":10,\"direction\":3,\"length\":1,\"inverse\":8,\"position\":0,\"next\":8,\"faktor\":2,\"pointx\":1,\"pointy\":3,\"color\":1,\"freaky\":20},{\"mover\":1,\"posx\":10,\"posy\":10,\"direction\":0,\"length\":1,\"inverse\":5,\"position\":60,\"next\":5,\"faktor\":2,\"pointx\":3,\"pointy\":3,\"color\":2,\"freaky\":20}]},{\"name\":\"Level 8 - Arrow\",\"min\":40,\"med\":60,\"max\":80,\"score\":0,\"next\":\"Level 8 - unbekannt\",\"editable\":true,\"circles\":[{\"mover\":2,\"posx\":10,\"posy\":20,\"direction\":3,\"length\":1,\"inverse\":10,\"position\":0,\"next\":10,\"faktor\":6,\"pointx\":1,\"pointy\":4,\"color\":0,\"freaky\":0},{\"mover\":2,\"posx\":0,\"posy\":10,\"direction\":3,\"length\":1,\"inverse\":10,\"position\":60,\"next\":10,\"faktor\":2,\"pointx\":2,\"pointy\":3,\"color\":1,\"freaky\":0},{\"mover\":4,\"posx\":10,\"posy\":0,\"direction\":2,\"length\":1,\"inverse\":10,\"position\":20,\"next\":10,\"faktor\":2,\"pointx\":3,\"pointy\":2,\"color\":2,\"freaky\":0}]},{\"name\":\"Level 9 - Titel & Love\",\"min\":50,\"med\":70,\"max\":90,\"score\":0,\"next\":\"Level 9 - unbekannt\",\"editable\":true,\"circles\":[{\"mover\":2,\"posx\":20,\"posy\":10,\"direction\":3,\"length\":1,\"inverse\":5,\"position\":20,\"next\":5,\"faktor\":2,\"pointx\":0,\"pointy\":3,\"color\":0,\"freaky\":30},{\"mover\":3,\"posx\":20,\"posy\":10,\"direction\":1,\"length\":1,\"inverse\":10,\"position\":260,\"next\":10,\"faktor\":2,\"pointx\":0,\"pointy\":1,\"color\":1,\"freaky\":5},{\"mover\":3,\"posx\":20,\"posy\":10,\"direction\":2,\"length\":1,\"inverse\":10,\"position\":40,\"next\":10,\"faktor\":2,\"pointx\":4,\"pointy\":1,\"color\":2,\"freaky\":0},{\"mover\":2,\"posx\":20,\"posy\":10,\"direction\":0,\"length\":1,\"inverse\":10,\"position\":90,\"next\":10,\"faktor\":2,\"pointx\":4,\"pointy\":3,\"color\":3,\"freaky\":0}]},{\"name\":\"Level 10 - Crazy\",\"min\":70,\"med\":90,\"max\":110,\"score\":0,\"next\":\"Level 10 - unbekannt\",\"editable\":true,\"circles\":[{\"mover\":2,\"posx\":20,\"posy\":20,\"direction\":1,\"length\":1,\"inverse\":10,\"position\":0,\"next\":10,\"faktor\":2,\"pointx\":0,\"pointy\":0,\"color\":0,\"freaky\":0},{\"mover\":2,\"posx\":0,\"posy\":0,\"direction\":0,\"length\":1,\"inverse\":10,\"position\":0,\"next\":10,\"faktor\":2,\"pointx\":2,\"pointy\":2,\"color\":1,\"freaky\":0},{\"mover\":2,\"posx\":0,\"posy\":20,\"direction\":3,\"length\":1,\"inverse\":10,\"position\":0,\"next\":10,\"faktor\":2,\"pointx\":2,\"pointy\":4,\"color\":2,\"freaky\":0},{\"mover\":3,\"posx\":20,\"posy\":20,\"direction\":2,\"length\":1,\"inverse\":10,\"position\":0,\"next\":10,\"faktor\":5,\"pointx\":4,\"pointy\":0,\"color\":3,\"freaky\":0}]},{\"name\":\"Level 11 - House\",\"min\":40,\"med\":70,\"max\":100,\"score\":0,\"next\":\"Level 11 - unbekannt\",\"editable\":true,\"circles\":[{\"mover\":3,\"posx\":20,\"posy\":20,\"direction\":3,\"length\":1,\"inverse\":10,\"position\":30,\"next\":10,\"faktor\":4,\"pointx\":0,\"pointy\":4,\"color\":0,\"freaky\":10},{\"mover\":4,\"posx\":20,\"posy\":0,\"direction\":1,\"length\":1,\"inverse\":10,\"position\":0,\"next\":10,\"faktor\":2,\"pointx\":0,\"pointy\":2,\"color\":1,\"freaky\":0},{\"mover\":3,\"posx\":20,\"posy\":0,\"direction\":2,\"length\":1,\"inverse\":10,\"position\":80,\"next\":10,\"faktor\":2,\"pointx\":4,\"pointy\":2,\"color\":2,\"freaky\":15},{\"mover\":2,\"posx\":20,\"posy\":20,\"direction\":0,\"length\":1,\"inverse\":10,\"position\":0,\"next\":10,\"faktor\":2,\"pointx\":4,\"pointy\":4,\"color\":3,\"freaky\":0}]},{\"name\":\"Level 12 - River\",\"min\":60,\"med\":80,\"max\":90,\"score\":0,\"next\":\"Level 12 - unbekannt\",\"editable\":true,\"circles\":[{\"mover\":3,\"posx\":20,\"posy\":20,\"direction\":1,\"length\":1,\"inverse\":8,\"position\":30,\"next\":8,\"faktor\":2,\"pointx\":0,\"pointy\":0,\"color\":0,\"freaky\":0},{\"mover\":2,\"posx\":20,\"posy\":20,\"direction\":2,\"length\":1,\"inverse\":10,\"position\":0,\"next\":10,\"faktor\":2,\"pointx\":4,\"pointy\":0,\"color\":1,\"freaky\":0},{\"mover\":2,\"posx\":20,\"posy\":20,\"direction\":3,\"length\":1,\"inverse\":10,\"position\":270,\"next\":10,\"faktor\":2,\"pointx\":0,\"pointy\":4,\"color\":2,\"freaky\":0},{\"mover\":2,\"posx\":0,\"posy\":0,\"direction\":0,\"length\":1,\"inverse\":6,\"position\":340,\"next\":6,\"faktor\":2,\"pointx\":2,\"pointy\":2,\"color\":3,\"freaky\":0}]},{\"name\":\"Level 13 - Clown \",\"min\":60,\"med\":70,\"max\":80,\"score\":0,\"next\":\"Level 13 - unbekannt\",\"editable\":true,\"circles\":[{\"mover\":2,\"posx\":20,\"posy\":0,\"direction\":1,\"length\":1,\"inverse\":10,\"position\":260,\"next\":10,\"faktor\":6,\"pointx\":0,\"pointy\":2,\"color\":0,\"freaky\":8},{\"mover\":2,\"posx\":10,\"posy\":10,\"direction\":1,\"length\":1,\"inverse\":10,\"position\":320,\"next\":10,\"faktor\":6,\"pointx\":1,\"pointy\":1,\"color\":1,\"freaky\":5},{\"mover\":3,\"posx\":10,\"posy\":10,\"direction\":3,\"length\":1,\"inverse\":7,\"position\":20,\"next\":7,\"faktor\":6,\"pointx\":1,\"pointy\":3,\"color\":2,\"freaky\":23},{\"mover\":3,\"posx\":20,\"posy\":0,\"direction\":2,\"length\":1,\"inverse\":10,\"position\":50,\"next\":10,\"faktor\":6,\"pointx\":4,\"pointy\":2,\"color\":3,\"freaky\":16}]},{\"name\":\"Level 14 - Zyklus \",\"min\":70,\"med\":100,\"max\":130,\"score\":0,\"next\":\"Level 14 - unbekannt\",\"editable\":true,\"circles\":[{\"mover\":4,\"posx\":0,\"posy\":20,\"direction\":3,\"length\":1,\"inverse\":10,\"position\":0,\"next\":10,\"faktor\":2,\"pointx\":2,\"pointy\":4,\"color\":0,\"freaky\":0},{\"mover\":2,\"posx\":20,\"posy\":20,\"direction\":1,\"length\":1,\"inverse\":10,\"position\":0,\"next\":10,\"faktor\":2,\"pointx\":0,\"pointy\":0,\"color\":1,\"freaky\":0},{\"mover\":2,\"posx\":10,\"posy\":0,\"direction\":1,\"length\":1,\"inverse\":10,\"position\":60,\"next\":10,\"faktor\":2,\"pointx\":1,\"pointy\":2,\"color\":2,\"freaky\":6},{\"mover\":2,\"posx\":10,\"posy\":0,\"direction\":2,\"length\":1,\"inverse\":10,\"position\":0,\"next\":10,\"faktor\":2,\"pointx\":3,\"pointy\":2,\"color\":3,\"freaky\":0},{\"mover\":3,\"posx\":20,\"posy\":20,\"direction\":2,\"length\":1,\"inverse\":10,\"position\":290,\"next\":10,\"faktor\":2,\"pointx\":4,\"pointy\":0,\"color\":4,\"freaky\":7}]},{\"name\":\"Level 15 - They get it\",\"min\":60,\"med\":70,\"max\":80,\"score\":0,\"next\":\"Level 15 - unbekannt\",\"editable\":true,\"circles\":[{\"mover\":2,\"posx\":20,\"posy\":10,\"direction\":1,\"length\":1,\"inverse\":10,\"position\":0,\"next\":10,\"faktor\":6,\"pointx\":0,\"pointy\":1,\"color\":0,\"freaky\":0},{\"mover\":2,\"posx\":10,\"posy\":0,\"direction\":1,\"length\":1,\"inverse\":10,\"position\":290,\"next\":10,\"faktor\":6,\"pointx\":1,\"pointy\":2,\"color\":5,\"freaky\":0},{\"mover\":4,\"posx\":10,\"posy\":0,\"direction\":2,\"length\":1,\"inverse\":10,\"position\":320,\"next\":10,\"faktor\":4,\"pointx\":3,\"pointy\":2,\"color\":2,\"freaky\":0},{\"mover\":3,\"posx\":20,\"posy\":10,\"direction\":0,\"length\":1,\"inverse\":10,\"position\":60,\"next\":10,\"faktor\":4,\"pointx\":4,\"pointy\":3,\"color\":3,\"freaky\":0}]},{\"name\":\"Level 16 - Goodies \",\"min\":70,\"med\":90,\"max\":110,\"score\":0,\"next\":\"Level 16 - unbekannt\",\"editable\":true,\"circles\":[{\"mover\":2,\"posx\":10,\"posy\":10,\"direction\":0,\"length\":1,\"inverse\":10,\"position\":0,\"next\":10,\"faktor\":3,\"pointx\":3,\"pointy\":3,\"color\":0,\"freaky\":0},{\"mover\":4,\"posx\":10,\"posy\":10,\"direction\":3,\"length\":1,\"inverse\":10,\"position\":280,\"next\":10,\"faktor\":5,\"pointx\":1,\"pointy\":3,\"color\":1,\"freaky\":17},{\"mover\":2,\"posx\":10,\"posy\":10,\"direction\":1,\"length\":1,\"inverse\":10,\"position\":300,\"next\":10,\"faktor\":4,\"pointx\":1,\"pointy\":1,\"color\":2,\"freaky\":0},{\"mover\":3,\"posx\":0,\"posy\":20,\"direction\":2,\"length\":1,\"inverse\":10,\"position\":0,\"next\":10,\"faktor\":10,\"pointx\":2,\"pointy\":0,\"color\":3,\"freaky\":20}]},{\"name\":\"Level 17 - Postman \",\"min\":70,\"med\":90,\"max\":110,\"score\":0,\"next\":\"Level 17 - unbekannt\",\"editable\":true,\"circles\":[{\"mover\":2,\"posx\":20,\"posy\":0,\"direction\":1,\"length\":1,\"inverse\":10,\"position\":270,\"next\":10,\"faktor\":5,\"pointx\":0,\"pointy\":2,\"color\":0,\"freaky\":0},{\"mover\":2,\"posx\":0,\"posy\":0,\"direction\":0,\"length\":1,\"inverse\":5,\"position\":0,\"next\":5,\"faktor\":2,\"pointx\":2,\"pointy\":2,\"color\":1,\"freaky\":50},{\"mover\":3,\"posx\":20,\"posy\":0,\"direction\":2,\"length\":1,\"inverse\":10,\"position\":90,\"next\":10,\"faktor\":5,\"pointx\":4,\"pointy\":2,\"color\":2,\"freaky\":0}]}]}]}";

    public static List<LevelSet> sets = new ArrayList<>();

    static {
        sets = MainMenu.DATA.getData(LevelSet.class, MainMenu.DATA.get(), true);
        if (sets == null || sets.size() == 0) {
            setupSets();
        }

    }

    public static Level getLevel(UUID id) {
        Level r = null;
        for (LevelSet s : sets) {
            for (Level l : s.getLevels()) {
                if (l.getUID().equals(id)) {
                    r = l;
                    break;
                }
            }
        }
        return r;
    }

    public static LevelSet getLevelSet(UUID id) {
        Level r = null;
        for (LevelSet s : sets) {
            for (Level l : s.getLevels()) {
                if (l.getUID().equals(id)) {
                    return s;

                }
            }
        }
        return null;
    }

    public static LevelSet getSet(String name) {
        for (LevelSet s : sets)
            if (s.getName().equals(name))
                return s;
        return null;
    }

    public static void removeLevel(Level level) {

    }

    public static void updateLevel(Level level, boolean insert) {

        MainMenu.DATA.insert(level, insert, MainMenu.DATA.get());

        LevelSet bundle = null;
        for (LevelSet b : sets) {
            if (b.getLevels().contains(level)) {
                bundle = b;
            }
        }
        if (bundle != null) {
            int stars = 0;
            for (Level l : bundle.getLevels()) {
                stars += l.getScore() >= l.getMax() ? 3 : l.getScore() >= l.getMed() ? 2 : l.getScore() >= l.getMin() ? 1 : 0;
            }
            bundle.setCollected(stars);
            MainMenu.DATA.insert(bundle, false, MainMenu.DATA.get());

        }

    }

    public static int[] getRedArray() {
        return new int[]{76, 224, 33, 103, 255, 0, 205, 233, 25, 253};
    }

    public static int[] getGreenArray() {
        return new int[]{175, 67, 150, 58, 87, 150, 220, 30, 25, 216};
    }

    public static int[] getBlueArray() {
        return new int[]{80, 54, 243, 183, 34, 136, 57, 99, 25, 53};
    }

    public static void updateSet(LevelSet set) {
        MainMenu.DATA.insert(set, false, MainMenu.DATA.get());
    }

    private static void setupSets() {
        setupBasicSet();
    }

    private static void setupBasicSet() {

        try {
            JSONObject o = new JSONObject(base);

            if(o!=null){
               JSONArray a = o.getJSONArray("sets");
               for(int i =0;i<a.length();i++){
                   LevelSet set = new LevelSet();
                   set.setJSON(a.getJSONObject(i));
                   MainMenu.DATA.insert(set, true, MainMenu.DATA.get());
                   sets.add(set);
               }
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
