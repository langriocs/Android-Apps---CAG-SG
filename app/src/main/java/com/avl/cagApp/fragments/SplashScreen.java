package com.avl.cagApp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.avl.cagApp.R;
import com.avl.cagApp.libs.MyLibUtil;
import com.google.android.material.button.MaterialButton;

public class SplashScreen extends Fragment {

    private MaterialButton btnPressStart;

    public static SplashScreen newInstance() {
        return new SplashScreen();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnPressStart = view.findViewById(R.id.btn_press_start);
        btnPressStart.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_splashScreen_to_controlScreen);
        });

        view.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_splashScreen_to_controlScreen);
        });

         = MyLibUtil.getDeviceId(requireContext());
    }

}