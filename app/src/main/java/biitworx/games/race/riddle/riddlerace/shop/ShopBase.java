package biitworx.games.race.riddle.riddlerace.shop;

import android.graphics.Shader;

import java.util.concurrent.Callable;

/**
 * Created by marce_000 on 30.10.2016.
 */
public class ShopBase<Api> implements Shop {

    private ShopService<Api> service;

    public ShopBase(ShopService<Api> service) {
        this.service = service;
    }

    @Override
    public Callable<Boolean> buyItem(final String item) {
        return new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return service.buy(item);
            }
        };
    }
}
