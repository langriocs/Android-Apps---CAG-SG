package com.avl.cagApp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.avl.cagApp.R;
import com.avl.cagApp.viewmodel.ControlScreenViewModel;
import com.avl.cagApp.viewmodel.ShareViewModel;
import com.google.android.material.button.MaterialButton;

public class ControlScreen extends Fragment {

    private ControlScreenViewModel mViewModel;
    private ShareViewModel mShareModel;
    private CountDownTimer warmupTimer;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(ControlScreenViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_control_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvRoomName = view.findViewById(R.id.room_name_tv);
        MaterialButton btnUSB1 = view.findViewById(R.id.btn_usb_1);
        MaterialButton btnUSB2 = view.findViewById(R.id.btn_usb_2);

        // Warmup UI components
        View layoutWarmup = view.findViewById(R.id.layoutWarmup);
        TextView txtWarmupCountdown = view.findViewById(R.id.txtWarmupCountdown);

        mShareModel = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);
        mShareModel.deviceInfoByImei().observe(getViewLifecycleOwner(),deviceInfo -> {
            if (deviceInfo != null) {
                tvRoomName.setText(deviceInfo.getRoomName());
            }
        });

        mViewModel.getIsSystemInitialized().observe(getViewLifecycleOwner(), isInitialized -> {
            if (!isInitialized) {
                startWarmup(layoutWarmup, txtWarmupCountdown);

            } else {
                layoutWarmup.setVisibility(View.GONE);
            }
        });
    }

    private void startWarmup(View layoutWarmup, TextView txtWarmupCountdown) {
        layoutWarmup.setVisibility(View.VISIBLE);

        if (warmupTimer != null) {
            warmupTimer.cancel();
        }

        warmupTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String secUntilFinished = (millisUntilFinished / 1000) + "s";
                txtWarmupCountdown.setText(secUntilFinished);
            }

            @Override
            public void onFinish() {
                mViewModel.setSystemInitialized(true);
                layoutWarmup.setVisibility(View.GONE);
            }
        }.start();
    }
}