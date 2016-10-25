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
    @DbField(name = "editable")
    private boolean editable = false;

    public LevelSet() {

    }

    public JSONObject getJSON(){
        JSONObject result = new JSONObject();
        try {
            result.put("name",name);
            result.put("stars",stars);
            result.put("collected",collected);
            result.put("editable",editable);
            JSONArray lev = new JSONArray();

            for(Level l:levels){
                lev.put(l.getJSON());
            }
            result.put("levels",lev);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setJSON(JSONObject data){
        try {
            name=data.getString("name");
            stars=data.getInt("stars");
            collected=data.getInt("collected");
            editable=data.getBoolean("editable");

            JSONArray a = data.getJSONArray("levels");
            for(int i =0;i<a.length();i++){
                Level level = new Level();
                level.setJSON(a.getJSONObject(i));
                MainMenu.DATA.insert(level, true, MainMenu.DATA.get());
                levels.add(level);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
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

    public int getCollected() {
        return collected;
    }

    public void setCollected(int collected) {
        this.collected = collected;
    }

    public int getStars() {
        return getLevels() != null && getLevels().size() > 0 ?
                (int) (getLevels().size() * 2.5f) :
                0;
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
}
