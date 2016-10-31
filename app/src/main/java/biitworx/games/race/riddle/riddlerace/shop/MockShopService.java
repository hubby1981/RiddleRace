package biitworx.games.race.riddle.riddlerace.shop;

import java.math.BigDecimal;

/**
 * Created by marce_000 on 30.10.2016.
 */
public class MockShopService implements ShopService {

    public static final String SKU_001 = "SKU001";
    public static final String SKU_002 = "SKU002";
    public static final String SKU_003 = "SKU003";


    @Override
    public boolean buy(String item) {
        if(item.equals(SKU_001)||item.equals(SKU_002)||item.equals(SKU_003)){
            return true;
        }
        return false;
    }

    @Override
    public BigDecimal price(String item) {
        if(item.equals(SKU_001)){
            return new BigDecimal(3.99);
        }
        if(item.equals(SKU_002)){
            return new BigDecimal(0.99);
        }
        if(item.equals(SKU_003)){
            return new BigDecimal(2.99);
        }
        return new BigDecimal(0);
    }

    @Override
    public Object get() {
        return null;
    }
}
