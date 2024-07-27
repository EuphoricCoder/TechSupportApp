package com.example.supportapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.supportapplication.R;
import com.example.supportapplication.models.SupportTask;

import java.util.List;

public class TaskAdapter extends ArrayAdapter<SupportTask> {

    public TaskAdapter(Context context, List<SupportTask> tasks) {
        super(context, 0, tasks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SupportTask task = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_task, parent, false);
        }

        TextView titleTextView = convertView.findViewById(R.id.taskTitle);
        TextView statusTextView = convertView.findViewById(R.id.taskStatus);
        TextView descriptionTextView = convertView.findViewById(R.id.taskDescription);

        titleTextView.setText(task.getTitle());
        statusTextView.setText(task.getStatus());
        descriptionTextView.setText(task.getDescription());

        return convertView;
    }
}
