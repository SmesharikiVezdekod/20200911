package ru.nikshlykov.donations.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;

import ru.nikshlykov.donations.R;
import ru.nikshlykov.donations.ui.OnFragmentInteractionListener;

public class DonationOptionDataFragment extends Fragment {

    private OnFragmentInteractionListener onFragmentInteractionListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        onFragmentInteractionListener = (OnFragmentInteractionListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_donation_option_data, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.fragment_donation_option_data___button___next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections navDirections = DonationOptionDataFragmentDirections.actionNavDonationOptionDataToNavDonationPreview();
                onFragmentInteractionListener.onFragmentInteraction(navDirections);
            }
        });

        final ViewGroup datePickerContainer = view.findViewById(R.id.date_container);

        RadioButton fullSumRadioButton = view.findViewById(R.id.deadline_full_sum_radio);
        fullSumRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    datePickerContainer.setVisibility(View.GONE);
                } else {
                    datePickerContainer.setVisibility(View.VISIBLE);
                }
            }
        });

        fullSumRadioButton.setChecked(true);
    }
}
