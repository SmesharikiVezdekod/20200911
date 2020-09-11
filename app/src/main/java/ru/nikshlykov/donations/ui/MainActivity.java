package ru.nikshlykov.donations.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;

import android.os.Bundle;

import org.jetbrains.annotations.NotNull;

import ru.nikshlykov.donations.R;

import static androidx.navigation.Navigation.findNavController;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navController = findNavController(this, R.id.nav_host_fragment);
    }

    @Override
    public void onFragmentInteraction(@NotNull NavDirections navDirections) {
        navController.navigate(navDirections);
    }
}