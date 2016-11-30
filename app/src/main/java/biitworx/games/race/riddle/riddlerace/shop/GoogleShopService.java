package biitworx.games.race.riddle.riddlerace.shop;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

import com.android.vending.billing.IInAppBillingService;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import biitworx.games.race.riddle.riddlerace.MainMenu;
import biitworx.games.race.riddle.riddlerace.MainView;

/**
 * Created by marcel.weissgerber on 30.11.2016.
 */

public class GoogleShopService implements ShopService<IInAppBillingService> {
    private IInAppBillingService apiService;
    public ServiceConnection serviceConnection;

    public GoogleShopService() {
        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                apiService = IInAppBillingService.Stub.asInterface(service);

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                apiService = null;
                serviceConnection = null;
            }
        };

    }

    @Override
    public boolean buy(String item) {
        return false;
    }

    @Override
    public String price(String item) {
        Bundle query = new Bundle();
        ArrayList<String> list = new ArrayList<>();
        list.add("noads");
        list.add(item);


        query.putStringArrayList("ITEM_ID_LIST", list);
        try {
            if (get() != null) {
                Bundle details = get().getSkuDetails(3, MainMenu.myName, "inapp", query);
                if (details != null) {
                    int code = details.getInt("RESPONSE_CODE");
                    if (code == 0) {
                        ArrayList<String> products = details.getStringArrayList("DETAILS_LIST");
                        if (products != null && products.size() > 0) {
                            try {
                                JSONObject jsonObject = new JSONObject(products.get(0));
                                String price = jsonObject.getString("price");
                                return price;
                            } catch (JSONException e) {

                            }
                        }
                    }
                }
            }

        } catch (RemoteException e) {

        }
        return "0";
    }

    @Override
    public IInAppBillingService get() {
        return apiService;
    }
}
