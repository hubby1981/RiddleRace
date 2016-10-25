package biitworx.games.race.riddle.riddlerace.data.helper.poco;

import android.graphics.Color;
import android.graphics.Point;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import biitworx.games.race.riddle.riddlerace.MainMenu;
import biitworx.games.race.riddle.riddlerace.data.helper.BaseDataObject;
import biitworx.games.race.riddle.riddlerace.data.helper.DbField;
import biitworx.games.race.riddle.riddlerace.data.helper.DbTable;

/**
 * Created by marcel.weissgerber on 14.10.2016.
 */
@DbTable(name = "circle")
public class Circle extends BaseDataObject {

    @DbField(name = "mover")
    private int mover;
    @DbField(name = "posx")
    private int posx;
    @DbField(name = "posy")
    private int posy;
    @DbField(name = "direction")
    private int direction;
    @DbField(name = "length")
    private int length;
    @DbField(name = "inverse")
    private int inverse;
    @DbField(name = "position")
    private int position;
    @DbField(name = "next")
    private int next;
    @DbField(name = "faktor")
    private int faktor;
    @DbField(name = "pointx")
    private int pointx = 2;
    @DbField(name = "pointy")
    private int pointy = 2;
    @DbField(name = "color")
    private int color;
    @DbField(name = "freaky")
    private int freaky;

    @Override
    protected void imported() {

    }

    public Circle() {

    }

    public void setJSON(JSONObject data) {
        try {


            mover = data.getInt("mover");
            posx = data.getInt("posx");
            posy = data.getInt("posy");
            length = data.getInt("length");
            direction = data.getInt("direction");
            inverse = data.getInt("inverse");
            position = data.getInt("position");
            next = data.getInt("next");
            faktor = data.getInt("faktor");
            pointx = data.getInt("pointx");
            pointy = data.getInt("pointy");
            color = data.getInt("color");
            freaky = data.getInt("freaky");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getJSON() {
        JSONObject result = new JSONObject();
        try {
            result.put("mover", mover);
            result.put("posx", posx);
            result.put("posy", posy);
            result.put("direction", direction);
            result.put("length", length);
            result.put("inverse", next);
            result.put("position", position);
            result.put("next", next);
            result.put("faktor", faktor);
            result.put("pointx", pointx);
            result.put("pointy", pointy);
            result.put("color", color);
            result.put("freaky", freaky);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }


    public Circle(int speed, int positionx, int positiony, int direction, int length, int inverse, int position, int next, int faktor, int pointx, int pointy, int color) {

        this.mover = speed;
        this.posx = positionx;
        this.posy = positiony;
        this.direction = direction;
        this.length = length;
        this.inverse = inverse;
        this.position = position;
        this.next = next;
        this.faktor = faktor;
        this.pointx = pointx;
        this.pointy = pointy;
        this.color = color;
        this.freaky = 0;
    }

    public Point getPoint() {
        return new Point(getPointx(), getPointy());
    }


    public int getMover() {
        return mover;
    }

    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }

    public int getDirection() {
        return direction;
    }

    public int getLength() {
        return length;
    }

    public int getInverse() {
        return inverse;
    }

    public int getPosition() {
        return position;
    }

    public int getNext() {
        return next;
    }

    public int getFaktor() {
        return faktor;
    }

    public void setMover(int mover) {
        this.mover = mover;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setInverse(int inverse) {
        this.inverse = inverse;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public void setFaktor(int faktor) {
        this.faktor = faktor;
    }

    public int getPointx() {
        return pointx;
    }

    public int getPointy() {
        return pointy;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getFreaky() {
        return freaky;
    }

    public void setFreaky(int freaky) {
        this.freaky = freaky;
    }


    public enum CircleColorEnum {
        Green,
        Red,
        Blue,
        Purple,
        Orange,
        Teal,
        Lime,
        Pink,
        Gray,
        Yellow
    }
}
