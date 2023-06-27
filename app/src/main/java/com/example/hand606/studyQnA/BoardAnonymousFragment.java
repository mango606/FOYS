package com.example.hand606.studyQnA;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BoardAnonymousFragment extends CommonBoardFragment {

    public BoardAnonymousFragment() {
    }

    @Override
    public DatabaseReference getRef() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        return databaseReference.child("익명");
    }

    @Override
    public String getPostType() {
        return "익명";
    }
}
