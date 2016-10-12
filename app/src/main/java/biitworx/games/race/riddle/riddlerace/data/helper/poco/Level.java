package biitworx.games.race.riddle.riddlerace.data.helper.poco;

import biitworx.games.race.riddle.riddlerace.data.helper.BaseDataObject;
import biitworx.games.race.riddle.riddlerace.data.helper.DbField;
import biitworx.games.race.riddle.riddlerace.data.helper.DbTable;

/**
 * Created by marce_000 on 12.10.2016.
 */
@DbTable(name="level")
public class Level extends BaseDataObject {
    @DbField(name="min")
    private int min=0;
    @DbField(name="med")
    private int med=0;
    @DbField(name="max")
    private int max=0;
    @DbField(name="name")
    private String name="";
    @DbField(name="score")
    private int score=0;
    public Level(String name,int min,int max,int med){
        this.name=name;
        this.min=min;
        this.max=max;
        this.med=med;

    }

    public Level(){

    }

    public void setScore(int score){
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

    public int getMax() {
        return max;
    }

    public int getMed() {
        return med;
    }

    public int getMin() {
        return min;
    }
}
