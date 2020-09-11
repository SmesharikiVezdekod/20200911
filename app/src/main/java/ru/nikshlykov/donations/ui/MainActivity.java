package ru.nikshlykov.donations.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import ru.nikshlykov.donations.R;
import ru.nikshlykov.donations.ui.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow();
        }
    }
}