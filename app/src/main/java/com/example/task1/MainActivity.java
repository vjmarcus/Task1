package com.example.task1;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.task1.ui.DefaultFragment;
import com.example.task1.ui.RecyclerFragment;
import com.example.task1.ui.TextWatcherFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private Button goToTextWatcherFragmentButton;
    private Button goToRecyclerFragmentButton;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        initButtons();
        initDrawer();
        loadDefaultFragment();

        goToTextWatcherFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new TextWatcherFragment());
            }
        });
        goToRecyclerFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new RecyclerFragment());
            }
        });
    }

    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    private void loadDefaultFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.container, new DefaultFragment()).commit();
    }

    private void initDrawer() {
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment).commit();
    }

    private void initButtons() {
        goToTextWatcherFragmentButton = findViewById(R.id.buttonGoToTextWatcherFragment);
        goToRecyclerFragmentButton = findViewById(R.id.buttonGoToRecyclerFragment);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                replaceFragment(new DefaultFragment());
                break;
            case R.id.item2:
                replaceFragment(new TextWatcherFragment());
                break;
            case R.id.item3:
                replaceFragment(new RecyclerFragment());
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}