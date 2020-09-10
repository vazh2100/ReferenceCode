package com.vazheninapps.firebasestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class CreateUserActivity extends AppCompatActivity {
     private EditText editTextName;
     private EditText editTextLastName;
     private EditText editTextAge;
     private EditText editTextSex;


    private FirebaseFirestore db;

     private void init(){
         editTextName = findViewById(R.id.editTextName);
         editTextLastName = findViewById(R.id.editTextLastName);
         editTextAge = findViewById(R.id.editTextAge);
         editTextSex = findViewById(R.id.editTextSex);
         db = FirebaseFirestore.getInstance();
     }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        init();
    }

    public static Intent createIntent(Context context){
        Intent intent = new Intent(context, CreateUserActivity.class);
        return intent;
    }

    public void onClickCreateUser(View view) {


       String name = editTextName.getText().toString().trim();
       String lastName = editTextLastName.getText().toString().trim();
       String sex =  editTextSex.getText().toString().trim();

       if(!name.equals("") && !lastName.equals("") && !editTextAge.getText().toString().equals("") && !sex.equals("")){
           int age =   Integer.parseInt(editTextAge.getText().toString());
           User user = new User(name, lastName, age, sex);
           db.collection("users").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
               @Override
               public void onSuccess(DocumentReference documentReference) {

               }
           });
           Intent intent = new Intent(CreateUserActivity.this, MainActivity.class);
           startActivity(intent);

       } else   {
           Toast.makeText(CreateUserActivity.this, "Все поля должны быть заполнены!", Toast.LENGTH_SHORT).show();
       }


    }
}