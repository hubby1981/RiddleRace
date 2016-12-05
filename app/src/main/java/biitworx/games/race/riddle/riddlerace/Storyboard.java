package biitworx.games.race.riddle.riddlerace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by marcel.weissgerber on 05.12.2016.
 */

public class Storyboard {

    public HashMap<Integer, List<Frame>> frames = new HashMap<>();
    private List<Timer> timers = new ArrayList<>();

    public void play(int delay) {

        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                internalPlay();
            }
        }, delay);
        timers.add(t);
    }

    public void stop(){
        if (timers.size() > 0) {
            for (Timer timer : timers) {
                timer.cancel();
            }
        }
    }

    private void internalPlay() {
        stop();
        for (Map.Entry<Integer, List<Frame>> f : frames.entrySet()) {
            if (f.getValue().size() > 0) {
                Timer t = new Timer();

                timers.add(t);

                for (final Frame frame : f.getValue()) {
                    t.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            frame.run();
                        }
                    }, frame.getWait());
                }
            }
        }
    }


    public void add(Frame frame) {
        add(0, frame);
    }

    public void add(Integer layer, Frame frame) {

        if (frames.get(layer) == null) {
            List<Frame> list = new ArrayList<>();

            list.add(frame);
            frames.put(layer, list);
        } else {
            frames.get(layer).add(frame);
        }
    }
}
