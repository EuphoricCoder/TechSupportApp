package com.example.supportapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.supportapplication.R;
import com.example.supportapplication.models.StatusChange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class StatusHistoryAdapter extends ArrayAdapter<StatusChange> {

    public StatusHistoryAdapter(Context context, List<StatusChange> statusChanges) {
        super(context, 0, statusChanges);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        StatusChange statusChange = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_status_change, parent, false);
        }

        TextView statusTextView = convertView.findViewById(R.id.statusTextView);
        TextView changedByTextView = convertView.findViewById(R.id.changedByTextView);
        TextView timestampTextView = convertView.findViewById(R.id.timestampTextView);

        statusTextView.setText(statusChange.getStatus());
        changedByTextView.setText(statusChange.getChangedBy());
        timestampTextView.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(statusChange.getTimestamp())));

        return convertView;
    }
}

