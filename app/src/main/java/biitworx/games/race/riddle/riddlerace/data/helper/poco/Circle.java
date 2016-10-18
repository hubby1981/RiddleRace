package biitworx.games.race.riddle.riddlerace.data.helper.poco;

import biitworx.games.race.riddle.riddlerace.data.helper.BaseDataObject;
import biitworx.games.race.riddle.riddlerace.data.helper.DbField;
import biitworx.games.race.riddle.riddlerace.data.helper.DbTable;

/**
 * Created by marcel.weissgerber on 14.10.2016.
 */
@DbTable(name = "circle")
public class Circle extends BaseDataObject {
    @DbField(name = "red")
    private int red;
    @DbField(name = "green")
    private int green;
    @DbField(name = "blue")
    private int blue;
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

    @Override
    protected void imported() {

    }

    public Circle() {

    }


    public Circle(int red, int green, int blue, int speed, int positionx, int positiony, int direction, int length, int inverse, int position, int next, int faktor) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.mover = speed;
        this.posx = positionx;
        this.posy = positiony;
        this.direction = direction;
        this.length = length;
        this.inverse = inverse;
        this.position = position;
        this.next = next;
        this.faktor = faktor;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
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
}
