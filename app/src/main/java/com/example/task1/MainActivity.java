package com.example.task1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    Button goToTextWatcherFragment, goToRecyclerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToTextWatcherFragment = findViewById(R.id.buttonGoToTextWatcherFragment);
        goToRecyclerFragment = findViewById(R.id.buttonGoToRecyclerFragment);
        goToTextWatcherFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                TextWatcherFragment textWatcherFragment = new TextWatcherFragment();
                transaction.replace(R.id.container, textWatcherFragment).addToBackStack(null)
                        .commit();
            }
        });
        goToRecyclerFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerFragment recyclerFragment = new RecyclerFragment();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.container, recyclerFragment).commit();
            }
        });


    }
}