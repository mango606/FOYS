package com.example.hand606.studyQnA;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class BoardLossFragment extends CommonBoardFragment {

    @Override
    public DatabaseReference getRef() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        return databaseReference.child("졸업생");
    }

    @Override
    public String getPostType() {
        return "졸업생";
    }

    public BoardLossFragment() {
    }
}