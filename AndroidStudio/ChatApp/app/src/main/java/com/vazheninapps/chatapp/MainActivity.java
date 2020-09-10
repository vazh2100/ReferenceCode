package com.vazheninapps.chatapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.api.LogDescriptor;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 1000;
    private static final int RC_GET_IMAGE = 1001;
    private RecyclerView recyclerViewMessages;
    private MessageAdapter adapter;
    private EditText editTextMessage;
    private ImageView imageViewSend;
    private ImageView imageViewAddImage;

    private SharedPreferences preferences;
    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    private FirebaseStorage storage;
    private StorageReference storageRef;


    private void init() {
        editTextMessage = findViewById(R.id.editTextTextMessage);
        imageViewSend = findViewById(R.id.imageViewSend);
        recyclerViewMessages = findViewById(R.id.recyclerViewMessages);
        imageViewAddImage = findViewById(R.id.imageViewAddImage);
        recyclerViewMessages.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MessageAdapter(this);
        recyclerViewMessages.setAdapter(adapter);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        imageViewSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(editTextMessage.getText().toString().trim(), null);
            }
        });
        imageViewAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/jpeg");
                intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                startActivityForResult(intent, RC_GET_IMAGE);

            }
        });
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();

        if (mAuth.getCurrentUser() != null) {
            preferences.edit().putString("author", mAuth.getCurrentUser().getEmail()).apply();
        } else {
            signOut();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        db.collection("messages").orderBy("date").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if (value != null) {

                    List<Message> messages = value.toObjects(Message.class);
                    adapter.setMessages(messages);
                    recyclerViewMessages.scrollToPosition(adapter.getItemCount() - 1);
                }
            }
        });
    }

    private void sendMessage(String textOfMessage,String imageUrl) {

        String author = preferences.getString("author", "anonim");
        if (textOfMessage != null && !textOfMessage.isEmpty()) {

            db.collection("messages").add(new Message(author, textOfMessage, System.currentTimeMillis(), null))
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            editTextMessage.setText("");
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("TEST", e.getMessage());
                            Toast.makeText(MainActivity.this, "Сообщение не отправлено", Toast.LENGTH_SHORT).show();
                        }
                    });

            recyclerViewMessages.scrollToPosition(adapter.getItemCount() - 1);
        } else  if (imageUrl != null && !imageUrl.isEmpty()){
            db.collection("messages").add(new Message(author, null, System.currentTimeMillis(), imageUrl))
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            editTextMessage.setText("");
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("TEST", e.getMessage());
                            Toast.makeText(MainActivity.this, "Сообщение не отправлено", Toast.LENGTH_SHORT).show();
                        }
                    });

            recyclerViewMessages.scrollToPosition(adapter.getItemCount() - 1);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item_out) {
            mAuth.signOut();
            signOut();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_GET_IMAGE && resultCode == RESULT_OK) {
            if (data != null) {
                Uri uri = data.getData();
                if (uri != null) {
                    final StorageReference referenceToImage = storageRef.child("images/" + uri.getLastPathSegment());
                    referenceToImage.putFile(uri).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                        @Override
                        public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                            if (!task.isSuccessful()) {
                                throw task.getException();
                            }

                            // Continue with the task to get the download URL
                            return referenceToImage.getDownloadUrl();
                        }
                    }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                        @Override
                        public void onComplete(@NonNull Task<Uri> task) {
                            if (task.isSuccessful()) {
                                Uri downloadUri = task.getResult();
                                if(downloadUri!=null){
                                    sendMessage(null, downloadUri.toString());
                                }
                            } else {
                                // Handle failures
                                // ...
                            }
                        }
                    });
                }
            }
        }

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                FirebaseUser user = mAuth.getCurrentUser();
                if (user != null) {
                    Toast.makeText(this, user.getEmail(), Toast.LENGTH_SHORT).show();
                    preferences.edit().putString("author", mAuth.getCurrentUser().getEmail()).apply();
                }

            } else {
                if (response != null) {
                    Toast.makeText(this, response.getError().toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void signOut() {
        AuthUI.getInstance().signOut(this).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()) {
                    List<AuthUI.IdpConfig> providers = Arrays.asList(
                            new AuthUI.IdpConfig.EmailBuilder().build(),
                            new AuthUI.IdpConfig.GoogleBuilder().build());

                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setAvailableProviders(providers)
                                    .build(),
                            RC_SIGN_IN);
                }

            }
        });


    }
}