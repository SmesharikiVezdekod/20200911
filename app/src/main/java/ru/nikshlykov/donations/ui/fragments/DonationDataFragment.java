package ru.nikshlykov.donations.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;

import ru.nikshlykov.donations.R;
import ru.nikshlykov.donations.databinding.FragmentDonationDataBinding;
import ru.nikshlykov.donations.model.DonationData;
import ru.nikshlykov.donations.ui.OnFragmentInteractionListener;
import ru.nikshlykov.donations.viewmodels.MainViewModel;

public class DonationDataFragment extends Fragment {

    private OnFragmentInteractionListener onFragmentInteractionListener;
    private MainViewModel mViewModel;
    private FragmentDonationDataBinding viewBinding;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        onFragmentInteractionListener = (OnFragmentInteractionListener) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewBinding = FragmentDonationDataBinding.inflate(inflater, container, false);
        return viewBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider((AppCompatActivity) requireActivity()).get(MainViewModel.class);

        viewBinding.feeTitleEditText.setText(mViewModel.data.getTitle());
        viewBinding.feeSumEditText.setText(String.valueOf(mViewModel.data.getSumRubles()));
        viewBinding.feeAimEditText.setText(mViewModel.data.getAim());
        viewBinding.feeDescriptionEditText.setText(mViewModel.data.getDescription());
        viewBinding.feeAccountEditText.setText(mViewModel.data.getMoneyReceivingAccount());
        viewBinding.feeAuthorEditText.setText(mViewModel.data.getAuthor());

        viewBinding.fragmentDonationDataButtonNextOrCreateDonation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections navDirection = null;

                if (mViewModel.data.getType() == DonationData.TYPE_ONE_TIME) {
                    navDirection = DonationDataFragmentDirections.actionNavDonationDataToNavDonationOptionData();
                } else if (mViewModel.data.getType() == DonationData.TYPE_REPETITIVE) {
                    navDirection = DonationDataFragmentDirections.actionNavDonationDataToNavDonationPreview();
                }

                if (navDirection != null) {
                    mViewModel.data.setTitle(viewBinding.feeTitleEditText.getText().toString());
                    mViewModel.data.setSumRubles(Double.parseDouble(viewBinding.feeSumEditText.getText().toString()));
                    mViewModel.data.setAim(viewBinding.feeAimEditText.getText().toString());
                    mViewModel.data.setDescription(viewBinding.feeDescriptionEditText.getText().toString());
                    mViewModel.data.setMoneyReceivingAccount(viewBinding.feeAccountEditText.getText().toString());

                    if (mViewModel.data.getType() == DonationData.TYPE_REPETITIVE) {
                        mViewModel.data.setAuthor(viewBinding.feeAuthorEditText.getText().toString());
                    }

                    onFragmentInteractionListener.onFragmentInteraction(navDirection);
                }
            }
        });

        if (mViewModel.data.getType() == DonationData.TYPE_REPETITIVE) {
            viewBinding.fragmentDonationDataButtonNextOrCreateDonation.setText(getString(R.string.create_donation));
            viewBinding.fragmentDonationLinearLayoutAuthor.setVisibility(View.VISIBLE);
        }
    }
}
