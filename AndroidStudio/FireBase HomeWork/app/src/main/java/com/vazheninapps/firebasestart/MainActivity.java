package com.vazheninapps.firebasestart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter adapter;
    private FirebaseFirestore db;
private ArrayList<User> users;

    private void init(){
        recyclerView = findViewById(R.id.recyclerViewUsers);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
        adapter = new UserAdapter();
        users = new ArrayList<>();
        db = FirebaseFirestore.getInstance();
        recyclerView.setAdapter(adapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        db.collection("users").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                users.clear();
                for (QueryDocumentSnapshot document : value) {
                    User user = new User();
                    user.setName((String)(document.get("name")));
                    user.setLastName((String)(document.get("lastName")));
                    user.setAge(Integer.parseInt(document.get("age").toString()));
                    user.setSex((String)(document.get("sex")));
                    System.out.println("TEST"+ user.toString());
                    users.add(user);
                }
                adapter.setUsers(users);
            }
        });



//        db.collection("users").add(user)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Log.d("TEST", "DocumentSnapshot added with ID: " + documentReference.getId());
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w("TEST", "Error adding document", e);
//                    }
//                });


//


//
    }

    public void onClickGoToCreateUserActivity(View view) {
        Intent intent = CreateUserActivity.createIntent(MainActivity.this);
        startActivity(intent);
    }
}