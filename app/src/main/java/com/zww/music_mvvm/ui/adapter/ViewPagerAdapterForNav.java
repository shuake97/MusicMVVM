package com.zww.music_mvvm.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class ViewPagerAdapterForNav extends FragmentStateAdapter {
    private List<Fragment> mFragments;

    public ViewPagerAdapterForNav(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, List<Fragment> list) {
        super(fragmentManager, lifecycle);
        this.mFragments = list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getItemCount() {
        return mFragments.size();
    }

}
