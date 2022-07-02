package com.myapp.lovetest_azuredragon3000.truyentinhyeu.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.myapp.lovetest_azuredragon3000.truyentinhyeu.ActivityTruyenTinhYeu;
import com.myapp.lovetest_azuredragon3000.common.Constant;
import com.myapp.lovetest_azuredragon3000.common.DatabaseTruyenTinhYeu;
import com.myapp.lovetest_azuredragon3000.common.FirebaseUtiti;
import com.myapp.lovetest_azuredragon3000.R;
import com.myapp.lovetest_azuredragon3000.common.SubApp;
import com.myapp.lovetest_azuredragon3000.truyentinhyeu.model.ViewModelShareTruyenTinhYeu;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class FragmentListViewTruyenTinhYeu extends ListFragment {

    View view;
    ViewModelShareTruyenTinhYeu modelShareTruyenTinhYeu;
    DatabaseTruyenTinhYeu databaseTruyenTinhYeu;
    FirebaseUtiti firebaseUtiti;
    AppCompatActivity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseTruyenTinhYeu = ((SubApp) getActivity().getApplication()).getDatabaseTruyenTinhYeu();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String[] listItem = databaseTruyenTinhYeu.getListTitle();
        View view = inflater.inflate(R.layout.fragment_list_view_truyen_tinh_yeu, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(), R.layout.support_simple_spinner_dropdown_item, listItem);
        setListAdapter(adapter);
        this.view = view;
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activity = (ActivityTruyenTinhYeu)getActivity();
        firebaseUtiti = ((SubApp)activity.getApplication()).getDatabaseFirebase();
        modelShareTruyenTinhYeu = new ViewModelProvider(requireActivity()).get(ViewModelShareTruyenTinhYeu.class);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        firebaseUtiti.updateDB("truyentinhyeucount", Constant.APPNAME);
        firebaseUtiti.updateDB2("truyentinhyeucontent",Constant.APPNAME,position+"");
        NavDirections action =
                FragmentListViewTruyenTinhYeuDirections.actionFragmentListViewTruyenTinhYeuToFragmentContentTruyenTinhYeu();
        modelShareTruyenTinhYeu.select(position);
        Navigation.findNavController(view).navigate(action);
    }
}