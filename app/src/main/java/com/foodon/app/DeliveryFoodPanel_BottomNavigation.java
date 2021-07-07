package com.foodon.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.foodon.app.deliveryFoodPanel.DeliveryPendingOrderFragment;
import com.foodon.app.deliveryFoodPanel.DeliveryShipOrderFragment;

import com.foodon.app.R;
import com.foodon.app.SendNotification.Token;

import com.foodon.app.deliveryFoodPanel.DeliveryPendingOrderFragment;
import com.foodon.app.deliveryFoodPanel.DeliveryShipOrderFragment;
import com.foodon.app.SendNotification.Token;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;


public class  DeliveryFoodPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_food_panel__bottom_navigation);
        BottomNavigationView navigationView = findViewById(R.id.delivery_bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);

        UpdateToken();
        String name = getIntent().getStringExtra("PAGE");
        if (name != null) {
            if (name.equalsIgnoreCase("DeliveryOrderpage"))
            {
                loaddeliveryfragment(new DeliveryPendingOrderFragment());
            }

        } else {
            loaddeliveryfragment(new DeliveryPendingOrderFragment());
        }

    }

    private void UpdateToken() {

        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String refreshToken = FirebaseInstanceId.getInstance().getToken();
        Token token = new Token(refreshToken);
        FirebaseDatabase.getInstance("https://foodon-1393f-default-rtdb.firebaseio.com/").getReference("Tokens").child(firebaseUser.getUid()).setValue(token);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.shiporders:
                fragment=new DeliveryShipOrderFragment();
                break;
        }
        switch (item.getItemId()){
            case R.id.pendingorders:
                fragment=new DeliveryPendingOrderFragment();
                break;
        }
        return loaddeliveryfragment(fragment);
    }

    private boolean loaddeliveryfragment(Fragment fragment) {
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            return true;
        }
        return false;
    }
}
