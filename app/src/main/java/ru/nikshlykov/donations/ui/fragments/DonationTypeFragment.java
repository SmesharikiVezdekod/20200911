package ru.nikshlykov.donations.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;

import java.util.Objects;

import ru.nikshlykov.donations.R;
import ru.nikshlykov.donations.model.DonationData;
import ru.nikshlykov.donations.ui.OnFragmentInteractionListener;
import ru.nikshlykov.donations.viewmodels.MainViewModel;

public class DonationTypeFragment extends Fragment {

    private OnFragmentInteractionListener onFragmentInteractionListener;
    private MainViewModel mViewModel;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        onFragmentInteractionListener = (OnFragmentInteractionListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_donation_type, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.fragment_donation_type___button___create_target_donation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.data.setType(DonationData.TYPE_ONE_TIME);
                NavDirections navDirections = DonationTypeFragmentDirections.actionNavDonationTypeToNavRegularDonationFlow()
                        .setDonationType(getString(R.string.donation_type_target));
                onFragmentInteractionListener.onFragmentInteraction(navDirections);
            }
        });
        view.findViewById(R.id.fragment_donation_type___button___create_regular_donation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.data.setType(DonationData.TYPE_REPETITIVE);
                NavDirections navDirections = DonationTypeFragmentDirections.actionNavDonationTypeToNavRegularDonationFlow()
                        .setDonationType(getString(R.string.donation_type_regular));
                onFragmentInteractionListener.onFragmentInteraction(navDirections);
            }
        });

        showButton();
    }

    private void showButton() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider((AppCompatActivity) requireActivity()).get(MainViewModel.class);
    }
}
