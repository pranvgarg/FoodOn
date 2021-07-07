package com.foodon.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.foodon.app.chefFoodPanel.ChefHomeFragment;
import com.foodon.app.chefFoodPanel.ChefOrderFragment;
import com.foodon.app.chefFoodPanel.ChefPendingOrderFragment;
import com.foodon.app.chefFoodPanel.ChefProfileFragment;
import com.foodon.app.SendNotification.Token;

import com.foodon.app.SendNotification.Token;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;


public class ChefFoodPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_food_panel__bottom_navigation);
        BottomNavigationView navigationView = findViewById(R.id.chef_bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
        UpdateToken();
        String name = getIntent().getStringExtra("PAGE");
        if (name != null) {
            if (name.equalsIgnoreCase("Orderpage")) {
                loadcheffragment(new ChefPendingOrderFragment());
            } else if (name.equalsIgnoreCase("Confirmpage")) {
                loadcheffragment(new ChefOrderFragment());
            } else if (name.equalsIgnoreCase("AcceptOrderpage")) {
                loadcheffragment(new ChefHomeFragment());
            } else if (name.equalsIgnoreCase("Deliveredpage")) {
                loadcheffragment(new ChefHomeFragment());
            }
        } else {
            loadcheffragment(new ChefHomeFragment());
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
            case R.id.chefHome:
                fragment=new ChefHomeFragment();
                break;
            case R.id.PendingOrders:
                fragment=new ChefPendingOrderFragment();
                break;
            case R.id.Orders:
                fragment=new ChefOrderFragment();
                break;
            case R.id.chefProfile:
                fragment=new ChefProfileFragment();
                break;
        }
        return loadcheffragment(fragment);
    }

    private boolean loadcheffragment(Fragment fragment) {

        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            return true;
        }
        return false;
    }
}