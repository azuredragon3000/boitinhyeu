package com.myapp.lovetest_azuredragon3000.congiap12.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.myapp.lovetest_azuredragon3000.congiap12.ui.FragmentMan;
import com.myapp.lovetest_azuredragon3000.congiap12.ui.FragmentWoman;


public class AdapterViewPager extends FragmentStatePagerAdapter {
    public AdapterViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FragmentMan();
                break;
            case 1:
                fragment = new FragmentWoman();
                break;
            default:
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
