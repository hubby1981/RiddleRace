package biitworx.games.race.riddle.riddlerace.data.helper.poco;

import java.util.ArrayList;
import java.util.List;

import biitworx.games.race.riddle.riddlerace.data.helper.BaseDataObject;
import biitworx.games.race.riddle.riddlerace.data.helper.DbReference;

/**
 * Created by marcel.weissgerber on 26.10.2016.
 */

public class Sets {
    @DbReference(items = LevelSet.class)
    public static List<LevelSet> sets=new ArrayList<>();
    public Sets(){

    }
}
