package com.myapp.lovetest_azuredragon3000.cauduyen.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ViewModelShareCauDuyen extends ViewModel {
    private final MutableLiveData<ArrayList<String>> selected = new MutableLiveData<>();

    public void select(ArrayList<String> item) {
        selected.setValue(item);
    }

    public LiveData<ArrayList<String>> getSelected() {
        return selected;
    }
}
