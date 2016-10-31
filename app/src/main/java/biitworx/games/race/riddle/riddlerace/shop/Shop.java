package biitworx.games.race.riddle.riddlerace.shop;

import java.util.concurrent.Callable;

/**
 * Created by marce_000 on 30.10.2016.
 */
public interface Shop {

    Callable buyItem(String item);
}
