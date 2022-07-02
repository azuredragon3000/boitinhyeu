package com.myapp.lovetest_azuredragon3000.cauduyen.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.myapp.lovetest_azuredragon3000.cauduyen.ActivityCauDuyen;
import com.myapp.lovetest_azuredragon3000.cauduyen.data.ViewModelShareCauDuyen;
import com.myapp.lovetest_azuredragon3000.common.FunctionCommon;
import com.myapp.lovetest_azuredragon3000.common.SubApp;
import com.myapp.lovetest_azuredragon3000.databinding.FragmentHomeBinding;
import com.myapp.lovetest_azuredragon3000.ngontinh.model.ModelDanhNgon;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ViewModelShareCauDuyen model;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        model = new ViewModelProvider(requireActivity()).get(ViewModelShareCauDuyen.class);

        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.xinxam.setOnClickListener(v->{
            // move to other fragment
            //String t = queryRandomData();
            List<ModelDanhNgon> modelDanhNgonList = ((SubApp) getActivity().getApplication()).getDatabaseTuviManager2().getDanhNgon();
            int random = FunctionCommon.getRandom(modelDanhNgonList.size(),0);
            String s_input = modelDanhNgonList.get(random).getContent();
            ((ActivityCauDuyen)getActivity()).list_item.add((String)s_input);
            binding.ctXinxam.setText((String)s_input);
            ArrayList<String> e = ((ActivityCauDuyen)getActivity()).list_item;
            model.select(e);

            /*List<ModelDanhNgon> modelDanhNgonList = ((SubApp) getActivity().getApplication()).getDatabaseTuviManager2().getDanhNgon();
            int random = FunctionCommon.getRandom(modelDanhNgonList.size(),0);
            String s_input = modelDanhNgonList.get(random).getContent();
            // Create an English-German translator:
            TranslatorOptions options =
                    new TranslatorOptions.Builder()
                            .setSourceLanguage(TranslateLanguage.VIETNAMESE)
                            .setTargetLanguage(TranslateLanguage.ENGLISH)
                            .build();
            final Translator englishGermanTranslator =
                    Translation.getClient(options);


            DownloadConditions conditions = new DownloadConditions.Builder()
                    .requireWifi()
                    .build();
            englishGermanTranslator.downloadModelIfNeeded(conditions)
                    .addOnSuccessListener(
                            new OnSuccessListener() {
                                @Override
                                public void onSuccess(Object o) {


                                    englishGermanTranslator.translate(s_input)
                                            .addOnSuccessListener(
                                                    new OnSuccessListener() {
                                                        @Override
                                                        public void onSuccess(Object o) {
                                                            ((ActivityCauDuyen)getActivity()).list_item.add((String)o);
                                                            binding.ctXinxam.setText((String)o);
                                                            ArrayList<String> e = ((ActivityCauDuyen)getActivity()).list_item;
                                                            model.select(e);
                                                        }


                                                    })
                                            .addOnFailureListener(
                                                    new OnFailureListener() {
                                                        @Override
                                                        public void onFailure(@NonNull Exception e) {
                                                            // Error.
                                                            // ...
                                                        }
                                                    });


                                }
                            })
                    .addOnFailureListener(
                            new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    // Model couldn’t be downloaded or other internal error.
                                    // ...
                                }
                            });*/



        });
    }

    /*private String queryRandomData() {
        List<ModelDanhNgon> modelDanhNgonList = ((SubApp) getActivity().getApplication()).getDatabaseTuviManager2().getDanhNgon();
        int random = FunctionCommon.getRandom(modelDanhNgonList.size(),0);

        // Create an English-German translator:
        TranslatorOptions options =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.GERMAN)
                        .build();
        final Translator englishGermanTranslator =
                Translation.getClient(options);

        return modelDanhNgonList.get(random).getContent();
    }*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}