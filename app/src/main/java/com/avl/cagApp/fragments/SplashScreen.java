package com.avl.cagApp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.avl.cagApp.R;
import com.avl.cagApp.libs.MyLibUtil;
import com.avl.cagApp.model.vo.DeviceInfo;
import com.avl.cagApp.viewmodel.ShareViewModel;
import com.google.android.material.button.MaterialButton;

public class SplashScreen extends Fragment {

    private TextView tvRoomName;
    private MaterialButton btnPressStart;

    public static SplashScreen newInstance() {
        return new SplashScreen();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        tvRoomName = view.findViewById(R.id.room_name_tv);


        btnPressStart = view.findViewById(R.id.btn_press_start);
        btnPressStart.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_splashScreen_to_controlScreen);
        });

        view.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_splashScreen_to_controlScreen);
        });

        ShareViewModel shareViewModel = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);
        shareViewModel.deviceInfoByImei().observe(getViewLifecycleOwner(), deviceInfo -> {
            if (deviceInfo != null) {
                tvRoomName.setText(deviceInfo.getRoomName());
            }
        });

    }

}