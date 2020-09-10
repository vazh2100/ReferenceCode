package com.vazheninapps.notes2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewNotes;
    private final ArrayList<Note> notes = new ArrayList<>();
    private NotesAdapter adapter;
    private NotesDBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewNotes = findViewById(R.id.recyclerViewNotes);
        adapter = new NotesAdapter(notes);
        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this));
        dbHelper = new NotesDBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        for (Note note : notes) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(NotesContract.NotesEntry.COLUMN_TITLE, note.getTitle());
            contentValues.put(NotesContract.NotesEntry.COLUMN_DESCRIPTION, note.getDescription());
            contentValues.put(NotesContract.NotesEntry.COLUMN_DAY_OF_WEEK, note.getDayOfWeek());
            contentValues.put(NotesContract.NotesEntry.COLUMN_PRIORITY, note.getPriority());
            database.insert(NotesContract.NotesEntry.TABLE_NAME, null, contentValues);
/}

        getData();
        recyclerViewNotes.setAdapter(adapter);
        adapter.setOnNoteClickListener(new NotesAdapter.OnNoteClickListener() {
            @Override
            public void onNoteClick(int position) {
                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNoteLongClick(int position) {
                remove(position);

            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                remove(viewHolder.getAdapterPosition());

            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerViewNotes);


    }

    private void remove(int position) {
        Note note = adapter.getNotes().get(position);


    }

    public void onClickAddNote(View view) {
        Intent intent = new Intent(this, AddNoteActivity.class);
        startActivity(intent);

    }

    private void getData() {


    }

}
