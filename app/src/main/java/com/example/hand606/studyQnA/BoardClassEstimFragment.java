package com.example.hand606.studyQnA;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class BoardClassEstimFragment extends CommonBoardFragment {

    public BoardClassEstimFragment() {}

    @Override
    public DatabaseReference getRef() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        return databaseReference.child("질문");
    }

    @Override
    public String getPostType() {
        return "질문";
    }

}
