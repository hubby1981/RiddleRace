package biitworx.games.race.riddle.riddlerace.shop;

import java.math.BigDecimal;

/**
 * Created by marce_000 on 30.10.2016.
 */
public interface ShopService<Api> {

    boolean buy(String item);
    BigDecimal price(String item);
    Api get();
}
