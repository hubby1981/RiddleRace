package biitworx.games.race.riddle.riddlerace.data.helper.poco;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import biitworx.games.race.riddle.riddlerace.MainMenu;
import biitworx.games.race.riddle.riddlerace.data.helper.BaseDataObject;
import biitworx.games.race.riddle.riddlerace.data.helper.DbField;
import biitworx.games.race.riddle.riddlerace.data.helper.DbReference;
import biitworx.games.race.riddle.riddlerace.data.helper.DbTable;
import biitworx.games.race.riddle.riddlerace.data.helper.JsonIgnore;

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
    @DbField(name = "editable")
    private boolean editable = false;
    @DbField(name = "pn")
    @JsonIgnore
    private int pageNormal = 0;
    @DbField(name = "pe")
    @JsonIgnore
    private int pageEdit = 0;

    public LevelSet() {

    }


    public LevelSet(String name, int stars) {
        this.name = name;
        this.stars = stars;
    }

    public LevelSet(String name, int stars, boolean editable) {
        this(name, stars);
        this.editable = editable;
    }

    public void add(Level level) {

            levels.add(level);
    }

    @Override
    protected void imported() {

    }

    public String getName() {
        return name;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public boolean isEditable() {
        return editable;
    }

    public int getPageNormal() {
        return pageNormal;
    }

    public void setPageNormal(int pageNormal) {
        this.pageNormal = pageNormal;
    }

    public int getPageEdit() {
        return pageEdit;
    }

    public void setPageEdit(int pageEdit) {
        this.pageEdit = pageEdit;
    }
}
