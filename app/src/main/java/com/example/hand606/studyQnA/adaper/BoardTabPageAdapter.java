package com.example.hand606.studyQnA.adaper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.hand606.studyQnA.BoardAnonymousFragment;
import com.example.hand606.studyQnA.BoardClassEstimFragment;
import com.example.hand606.studyQnA.BoardLossFragment;
import com.example.hand606.studyQnA.BoardTradeFragment;


public class BoardTabPageAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    public BoardTabPageAdapter( FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem( int position) {

        switch (position) {
            case 0:
                return new BoardClassEstimFragment();

            case 1:
                return new BoardTradeFragment();

            case 2:
                return new BoardAnonymousFragment();

            case 3:
                return new BoardLossFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
