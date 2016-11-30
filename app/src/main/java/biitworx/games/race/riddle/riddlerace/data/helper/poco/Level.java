package biitworx.games.race.riddle.riddlerace.data.helper.poco;

import android.graphics.Point;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import biitworx.games.race.riddle.riddlerace.LevelChooser;
import biitworx.games.race.riddle.riddlerace.MainMenu;
import biitworx.games.race.riddle.riddlerace.data.helper.BaseDataObject;
import biitworx.games.race.riddle.riddlerace.data.helper.DbField;
import biitworx.games.race.riddle.riddlerace.data.helper.DbReference;
import biitworx.games.race.riddle.riddlerace.data.helper.DbTable;
import biitworx.games.race.riddle.riddlerace.data.helper.JsonIgnore;

/**
 * Created by marce_000 on 12.10.2016.
 */
@DbTable(name = "level")
public class Level extends BaseDataObject {
    @DbField(name = "min")
    private int min = 0;
    @DbField(name = "med")
    private int med = 0;
    @DbField(name = "max")
    private int max = 0;
    @DbField(name = "name")
    private String name = "";
    @DbField(name = "score")
    @JsonIgnore
    private int score = 0;
    @DbField(name = "next")
    private String next = "";
    @DbReference(items = Circle.class)
    private List<Circle> circles = new ArrayList<>();
    @DbField(name="editable")
    private boolean editable=false;

    public Level(String name, int min, int med, int max) {
        this.name = name;
        this.min = min;
        this.max = max;
        this.med = med;

    }

    public Level(String name, int min, int med, int max, String next) {
        this(name, min, med, max);
        this.next = next;
    }

    public Level(String name, int min, int med, int max, String next,boolean editable) {
        this(name, min, med, max,next);
        this.editable = editable;
    }

    public Level() {

    }

    public Level add(Circle circle) {
        circles.add(circle);
        return this;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    protected void imported() {
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public int getMax() {
        return max;
    }

    public int getMed() {
        return med;
    }

    public int getMin() {
        return min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMed(int med) {
        this.med = med;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public List<Circle> getCircles() {
        return circles;
    }

    public String getNext() {
        return next;
    }

    public boolean isEditable() {
        return editable;
    }
    public Circle getActive(Point point){
        for(Circle c: circles){
            if(c.getPoint().equals(point.x,point.y)){
                return c;
            }
        }
        return null;
    }

}
