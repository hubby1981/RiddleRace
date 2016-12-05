package biitworx.games.race.riddle.riddlerace;

/**
 * Created by marcel.weissgerber on 05.12.2016.
 */
public class Frame {

    private  Runnable action;
    private long wait=0;
    public Frame(Runnable action){
        this.action = action;
    }
    public Frame(Runnable action,long wait){
        this(action);
        this.wait = wait*1000;
    }

    public void run(){
        if(action!=null){
            action.run();
        }
    }

    public long getWait() {
        return wait;
    }
}
