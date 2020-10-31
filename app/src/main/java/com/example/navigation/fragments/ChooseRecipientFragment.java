package com.example.navigation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.navigation.R;


public class ChooseRecipientFragment extends Fragment implements View.OnClickListener{

    NavController navController;
    private EditText mRecipientInput;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.next_btn).setOnClickListener(this);
        view.findViewById(R.id.cancel_btn).setOnClickListener(this);
        navController = Navigation.findNavController(view);
        mRecipientInput = view.findViewById(R.id.input_recipient);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.next_btn:
                String recipient = this.mRecipientInput.getText().toString();
                if (!TextUtils.isEmpty(recipient)){
                    Bundle bundle = new Bundle();
                    bundle.putString("recipient", recipient);
                    navController.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment, bundle);
                }
                break;
            case R.id.cancel_btn:
                getActivity().onBackPressed();
                break;
        }

    }
}