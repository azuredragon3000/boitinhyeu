package com.myapp.lovetest_azuredragon3000.truyentinhyeu.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelShareTruyenTinhYeu extends ViewModel {
    private final MutableLiveData<Integer> selected = new MutableLiveData<>();

    public void select(Integer item) {
        selected.setValue(item);
    }

    public LiveData<Integer> getSelected() {
        return selected;
    }
}
