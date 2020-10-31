package com.example.navigation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.navigation.R;

public class SpecifyAmountFragment extends Fragment implements View.OnClickListener {

    NavController navController;
    private String mRecipient;
    private EditText mAmount;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        mRecipient = getArguments().getString("recipient");

        view.findViewById(R.id.cancel_btn).setOnClickListener(this);
        view.findViewById(R.id.send_btn).setOnClickListener(this);

        mAmount = view.findViewById(R.id.input_amount);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel_btn:
                getActivity().onBackPressed();
                break;
            case R.id.send_btn:
                String amount = mAmount.getText().toString();
                if (!TextUtils.isEmpty(amount)){
                    Bundle bundle = new Bundle();
                    try {
                        bundle.putInt("amount", Integer.parseInt(amount));
                        bundle.putString("recipient", mRecipient);
                        navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment);
                    } catch (NumberFormatException e) {
                        Log.i("INFO", e.getCause().getMessage());
                    }
                }
                break;
        }
    }
}