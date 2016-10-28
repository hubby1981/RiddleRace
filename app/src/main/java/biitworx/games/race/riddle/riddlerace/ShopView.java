package biitworx.games.race.riddle.riddlerace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ShopView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_view);


        ShopMenuView shop = (ShopMenuView)findViewById(R.id.shop);
        shop.shop = this;
    }

    public void update(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                findViewById(R.id.shop).invalidate();
            }
        });
    }
}
