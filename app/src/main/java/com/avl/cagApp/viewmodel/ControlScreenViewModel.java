package com.avl.cagApp.viewmodel;

import androidx.lifecycle.ViewModel;

import com.avl.cagApp.libs.TCPClient;

public class ControlScreenViewModel extends ViewModel {

    private final TCPClient tcpClient;

    public ControlScreenViewModel () {
        return new TCPClient();
    }
}
