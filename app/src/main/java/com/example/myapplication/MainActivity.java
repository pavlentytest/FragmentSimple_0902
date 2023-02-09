package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn1, btn2;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        fm = getSupportFragmentManager();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button) {
            loadFragment(new RootFragment());
        } else {
            loadFragment(new ResultFragment());
        }
    }

    public void loadFragment(Fragment f) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, f);
        fragmentTransaction.commit();

    }

}