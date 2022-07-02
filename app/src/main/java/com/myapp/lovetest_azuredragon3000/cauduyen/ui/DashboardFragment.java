package com.myapp.lovetest_azuredragon3000.cauduyen.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.myapp.lovetest_azuredragon3000.cauduyen.data.AdapterCauDuyen;
import com.myapp.lovetest_azuredragon3000.databinding.FragmentDashboardBinding;
import com.myapp.lovetest_azuredragon3000.cauduyen.data.ViewModelShareCauDuyen;

public class DashboardFragment extends Fragment {

    private AdapterCauDuyen mCauDuyenAdapter;
    private FragmentDashboardBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewModelShareCauDuyen model = new ViewModelProvider(requireActivity()).get(ViewModelShareCauDuyen.class);
        model.getSelected().observe(getViewLifecycleOwner(), item -> {
            mCauDuyenAdapter = new AdapterCauDuyen(getContext(), item);
            binding.recyclerHero.setAdapter(mCauDuyenAdapter);
            binding.recyclerHero.setLayoutManager(new LinearLayoutManager(getContext()));
        });
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}