package com.example.supportapplication;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.supportapplication.adapters.StatusHistoryAdapter;
import com.example.supportapplication.models.StatusChange;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class StatusHistoryActivity extends AppCompatActivity {

    private ListView statusHistoryListView;
    private List<StatusChange> statusChangeList;
    private StatusHistoryAdapter statusHistoryAdapter;
    private DatabaseReference statusHistoryReference;
    private String taskId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_history);

        statusHistoryListView = findViewById(R.id.statusHistoryListView);
        statusChangeList = new ArrayList<>();
        statusHistoryAdapter = new StatusHistoryAdapter(this, statusChangeList);
        statusHistoryListView.setAdapter(statusHistoryAdapter);

        taskId = getIntent().getStringExtra("taskId");
        if (taskId == null || taskId.isEmpty()) {
            Toast.makeText(this, "Invalid task ID", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        statusHistoryReference = FirebaseDatabase.getInstance().getReference("statusHistory").child(taskId);
        loadStatusChanges();
    }

    private void loadStatusChanges() {
        statusHistoryReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                statusChangeList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    StatusChange statusChange = snapshot.getValue(StatusChange.class);
                    if (statusChange != null) {
                        statusChangeList.add(statusChange);
                    }
                }
                statusHistoryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(StatusHistoryActivity.this, "Failed to load status history", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
