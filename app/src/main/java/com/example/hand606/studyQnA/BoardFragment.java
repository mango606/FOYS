package com.example.hand606.studyQnA;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BoardFragment extends ToolBarFragment {
    private ActionBar actionBar;
    private TextView toolbarText;

    @NonNull
    public static BoardFragment newInstance() {
        return new BoardFragment();
    }

    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState ) {
        View view = inflater.inflate(R.layout.fragment_board, container, false);
        setToolbar();
        return view;
    }
}
