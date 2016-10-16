package biitworx.games.race.riddle.riddlerace.data.helper.poco;

import java.util.ArrayList;
import java.util.List;

import biitworx.games.race.riddle.riddlerace.data.helper.BaseDataObject;
import biitworx.games.race.riddle.riddlerace.data.helper.DbField;
import biitworx.games.race.riddle.riddlerace.data.helper.DbReference;
import biitworx.games.race.riddle.riddlerace.data.helper.DbTable;

/**
 * Created by marce_000 on 16.10.2016.
 */
@DbTable(name = "bundle")
public class LevelSet extends BaseDataObject {
    @DbReference(items = Level.class)
    private List<Level> levels = new ArrayList<>();
    @DbField(name = "name")
    private String name = "";
    @DbField(name = "stars")
    private int stars = 0;
    @DbField(name = "collected")
    private int collected = 0;

    public LevelSet() {

    }

    public LevelSet(String name, int stars){
        this.name = name;
        this.stars = stars;
    }

    public void add(Level level){
        levels.add(level);
    }

    @Override
    protected void imported() {

    }

    public int getCollected() {
        return collected;
    }

    public void setCollected(int collected){
        this.collected = collected;
    }

    public int getStars() {
        return stars;
    }

    public String getName() {
        return name;
    }

    public List<Level> getLevels() {
        return levels;
    }
}
