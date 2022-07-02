package com.myapp.lovetest_azuredragon3000.boitinhyeu.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.myapp.lovetest_azuredragon3000.login.model.ModelDataBoiTinhYeu;

public class ViewModelShareInforBoiTinhYeu extends ViewModel {
    private final MutableLiveData<ModelDataBoiTinhYeu> selected = new MutableLiveData<ModelDataBoiTinhYeu>();
    public void select(ModelDataBoiTinhYeu item) {
        selected.setValue(item);
    }
    public LiveData<ModelDataBoiTinhYeu> getSelected() {
        return selected;
    }
}
