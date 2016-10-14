package biitworx.games.race.riddle.riddlerace.levels.basic.bundle;

import java.util.ArrayList;
import java.util.HashMap;

import biitworx.games.race.riddle.riddlerace.data.helper.poco.Levels;

/**
 * Created by marcel.weissgerber on 13.10.2016.
 */

public abstract class LevelBundle {

    private HashMap<String, Class> bundles = new HashMap<>();

    private ArrayList<InternalLevel> levels = new ArrayList<>();


    public LevelBundle() {
        initBundle();
    }

    protected abstract void initBundle();

    protected void add(String name, Class level) {
        bundles.put(name, level);

        InternalLevel i = new InternalLevel();
        i.aClass = level;
        i.name = name;
        levels.add(i);
    }


    public Class getByName(String name) {
        return bundles.get(name);
    }

    public HashMap<String, Class> getBundles() {
        return bundles;
    }

    public ArrayList<InternalLevel> getLevels() {
        return levels;
    }

    public InternalLevel nextIndexOf(String name) {
        for (InternalLevel i : levels) {
            if (i.name.equals(name)) {
                int ii = levels.indexOf(i);
                if (ii < levels.size() - 2) {
                    return levels.get(ii + 1);
                }
            }
        }
        return null;
    }


    public class InternalLevel {
        public String name;
        public Class aClass;

    }
}
