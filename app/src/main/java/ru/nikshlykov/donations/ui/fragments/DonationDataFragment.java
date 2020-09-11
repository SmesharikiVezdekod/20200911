package ru.nikshlykov.donations.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;

import ru.nikshlykov.donations.R;
import ru.nikshlykov.donations.ui.OnFragmentInteractionListener;

public class DonationDataFragment extends Fragment {

    private OnFragmentInteractionListener onFragmentInteractionListener;

    private String donationType;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        onFragmentInteractionListener = (OnFragmentInteractionListener) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DonationDataFragmentArgs fragmentArgs = DonationDataFragmentArgs.fromBundle(getArguments());
        donationType = fragmentArgs.getDonationType();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_donation_data, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavDirections navDirections = null;

        Button nextOrCreateDonationButton = view.findViewById(R.id.fragment_donation_data___button___next_or_create_donation);
        //TODO Прописать текст на кнопке через ресурсы.

        if (donationType.equals(getString(R.string.donation_type_target))) {
            navDirections = DonationDataFragmentDirections.actionNavDonationDataToNavDonationOptionData();
        } else if (donationType.equals(getString(R.string.donation_type_regular))) {
            navDirections = DonationDataFragmentDirections.actionNavDonationDataToNavDonationPreview();
        }
        final NavDirections finalNavDirections = navDirections;
        nextOrCreateDonationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (finalNavDirections != null) {
                    onFragmentInteractionListener.onFragmentInteraction(finalNavDirections);
                }
            }
        });
    }
}
