package com.example.framentsmenu;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    FrameLayout frmHome;

    BottomNavigationView btmNav;

    ImageViewFragment imageViewFragment = new ImageViewFragment();
    FragmentoSpinner spinnerFragment = new FragmentoSpinner();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(imageViewFragment);

        frmHome = findViewById(R.id.frmHome);
        btmNav = findViewById(R.id.btmNav);

        btmNav.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.rick) {
                loadFragment(imageViewFragment);
                return true;
            } else if (item.getItemId() == R.id.spinner_1) {
                loadFragment(spinnerFragment);
                return true;
            }

            return false;
        });
    }

    public void loadFragment(Fragment fr) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frmHome, fr);
        transaction.commit();
    }
}