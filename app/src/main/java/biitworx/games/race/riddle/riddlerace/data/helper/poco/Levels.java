package biitworx.games.race.riddle.riddlerace.data.helper.poco;

import java.util.ArrayList;
import java.util.List;

import biitworx.games.race.riddle.riddlerace.MainMenu;
import biitworx.games.race.riddle.riddlerace.R;
import biitworx.games.race.riddle.riddlerace.TE;
import biitworx.games.race.riddle.riddlerace.levels.basic.bundle.BasicBundle;

/**
 * Created by marce_000 on 12.10.2016.
 */
public class Levels {


    private static List<LevelSet> sets = new ArrayList<>();

    static {
        sets = MainMenu.DATA.getData(LevelSet.class, MainMenu.DATA.get(), true);
        if (sets == null || sets.size() == 0) {
            setupSets();
        }

    }

    public static Level getLevel(String name) {
        Level r = null;
        for (LevelSet s : sets)
        {
            for (Level l : s.getLevels())
            {
                if (l.getName().equals(name))
                {
                    r= l;
                    break;
                }
            }
        }
        return r;
    }

    public static LevelSet getSet(String name) {
        for (LevelSet s : sets)
            if (s.getName().equals(name))
                return s;
        return null;
    }


    public static void updateLevel(Level level,boolean insert) {

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

    private static void setupSets() {
        sets.add(setupBasicSet());
    }

    private static LevelSet setupBasicSet() {
        LevelSet result = new LevelSet(TE.get(R.string.bundle_basic), 40);
        /*result.add(BasicBundle.setupLevel1());
        result.add(BasicBundle.setupLevel2());
        result.add(BasicBundle.setupLevel3());
        result.add(BasicBundle.setupLevel4());
        result.add(BasicBundle.setupLevel5());
        result.add(BasicBundle.setupLevel6());
        result.add(BasicBundle.setupLevel7());*/



        for (Level l : result.getLevels())
            MainMenu.DATA.insert(l, true, MainMenu.DATA.get());

        MainMenu.DATA.insert(result, true, MainMenu.DATA.get());

        return result;
    }

}
