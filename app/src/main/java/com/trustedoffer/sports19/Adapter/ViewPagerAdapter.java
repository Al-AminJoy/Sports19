package com.trustedoffer.sports19.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.trustedoffer.sports19.Fragment.HighlightsFragment;
import com.trustedoffer.sports19.Fragment.UnofficialVideoFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private int TabNum;

    public ViewPagerAdapter(FragmentManager fm, int tabNum) {
        super(fm);
        TabNum = tabNum;
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return new HighlightsFragment();
        } else if (i == 1) {
            return new UnofficialVideoFragment();
        } else {
            return null;
        }

    }

    @Override
    public int getCount() {
        return TabNum;
    }
}
