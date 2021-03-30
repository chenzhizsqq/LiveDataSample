package com.test.livedatasample;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<String> text;

    public LiveData<String> getText() {
        if (text == null) {
            text = new MutableLiveData<>();
        }
        return text;
    }

    public void onClick(View view) {
        text.setValue("time: " + System.currentTimeMillis());
    }
}