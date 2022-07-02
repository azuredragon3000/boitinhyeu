package com.myapp.lovetest_azuredragon3000.boitinhyeu.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.myapp.lovetest_azuredragon3000.login.model.ModelDataBoiTinhYeu;
import com.myapp.lovetest_azuredragon3000.databinding.FragmentBoiTinhYeuDes3Binding;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class FragmentBoiTinhYeuDes3 extends Fragment  {

    ModelDataBoiTinhYeu modelDataBoiTinhYeu;
    FragmentBoiTinhYeuDes3Binding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBoiTinhYeuDes3Binding.inflate(inflater,container,false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewModelShareInforBoiTinhYeu model = new ViewModelProvider(requireActivity()).get(ViewModelShareInforBoiTinhYeu.class);
        modelDataBoiTinhYeu = new ModelDataBoiTinhYeu(0,"","","");
        model.getSelected().observe(getViewLifecycleOwner(), item -> {
            // Update the UI.
            modelDataBoiTinhYeu.result = item.result;
            binding.tv.setText(modelDataBoiTinhYeu.result);
        });
    }

}