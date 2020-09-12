package ru.nikshlykov.donations.ui.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.nikshlykov.donations.R;
import ru.nikshlykov.donations.model.DonationData;
import ru.nikshlykov.donations.ui.OnFragmentInteractionListener;
import ru.nikshlykov.donations.viewmodels.MainViewModel;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    private OnFragmentInteractionListener onFragmentInteractionListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        onFragmentInteractionListener = (OnFragmentInteractionListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.fragment_main___button___create_donation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.data = new DonationData();
                NavDirections navDirections = MainFragmentDirections.actionNavMainToNavDonationType();
                onFragmentInteractionListener.onFragmentInteraction(navDirections);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel =  new ViewModelProvider((AppCompatActivity) requireActivity()).get(MainViewModel.class);
    }

}