package com.vazheninapps.notes2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class AddNoteActivity extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextDescription;
    private Spinner spinnerDaysOfWeek;
    private RadioGroup radioGroupPriority;

    private MainViewModel viewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);


        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        spinnerDaysOfWeek = findViewById(R.id.spinnerDaysOfWeek);
        radioGroupPriority = findViewById(R.id.radioGroupPriority);

    }

    public void onClickSaveNote(View view) {
        String title = editTextTitle.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        int dayOfWeek = spinnerDaysOfWeek.getSelectedItemPosition();
        int radiobuttonId = radioGroupPriority.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radiobuttonId);
        int priority = Integer.parseInt(radioButton.getText().toString());

        if (isFill(title, description)){
            Note note = new Note(title,  description, dayOfWeek, priority);
            viewModel.insertNote(note);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(this, R.string.warning_fill_fields, Toast.LENGTH_SHORT).show();}
    }

    private boolean isFill (String title, String description) {
        return !title.isEmpty() && !description.isEmpty();
    }
}
