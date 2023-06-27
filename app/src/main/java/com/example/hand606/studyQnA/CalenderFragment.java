package com.example.hand606.studyQnA;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CalenderFragment extends ToolBarFragment {

    @NonNull
    public static CalenderFragment newInstance() {
        return new CalenderFragment();
    }

    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState ) {
        View view = inflater.inflate(R.layout.fragment_calender, container, false);
        setToolbar();
       return view;
    }

}
