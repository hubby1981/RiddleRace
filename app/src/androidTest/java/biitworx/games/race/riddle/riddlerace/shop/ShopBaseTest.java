package biitworx.games.race.riddle.riddlerace.shop;

import java.math.BigDecimal;


import org.junit.*;
/**
 * Created by marce_000 on 31.10.2016.
 */

public class ShopBaseTest {

    @Test
    public void testBuyItem() throws Exception {

        ShopBase<MockShopService> shop = new ShopBase<>(new MockShopService());

        Assert.assertNotSame("Price not same", new BigDecimal(1.99), shop.buyItem("SKU_001"));
    }
}