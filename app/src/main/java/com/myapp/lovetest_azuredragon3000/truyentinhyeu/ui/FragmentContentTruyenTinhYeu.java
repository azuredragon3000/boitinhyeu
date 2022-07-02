package com.myapp.lovetest_azuredragon3000.truyentinhyeu.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.myapp.lovetest_azuredragon3000.truyentinhyeu.model.ModelTruyenTinhYeu;
import com.myapp.lovetest_azuredragon3000.common.DatabaseTruyenTinhYeu;
import com.myapp.lovetest_azuredragon3000.databinding.FragmentContentTruyentinhyeuBinding;
import com.myapp.lovetest_azuredragon3000.common.SubApp;
import com.myapp.lovetest_azuredragon3000.truyentinhyeu.model.ViewModelShareTruyenTinhYeu;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class FragmentContentTruyenTinhYeu extends Fragment {

    FragmentContentTruyentinhyeuBinding binding;
    ViewModelShareTruyenTinhYeu modelShareTruyenTinhYeu;
    DatabaseTruyenTinhYeu databaseTruyenTinhYeu;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseTruyenTinhYeu = ((SubApp) getActivity().getApplication()).getDatabaseTruyenTinhYeu();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        modelShareTruyenTinhYeu = new ViewModelProvider(requireActivity()).get(ViewModelShareTruyenTinhYeu.class);

        modelShareTruyenTinhYeu.getSelected().observe(getViewLifecycleOwner(), item -> {
            // get content data
            ModelTruyenTinhYeu m_content = databaseTruyenTinhYeu.getContent(item+1);

            binding.content.setText(m_content.content);
            binding.title.setText(m_content.title);
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentContentTruyentinhyeuBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        return root;
    }
}