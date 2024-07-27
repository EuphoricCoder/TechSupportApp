package com.example.supportapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.supportapplication.R;
import com.example.supportapplication.models.ChecklistItem;

import java.util.List;

public class ChecklistAdapter extends ArrayAdapter<ChecklistItem> {

    public ChecklistAdapter(Context context, List<ChecklistItem> checklistItems) {
        super(context, 0, checklistItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChecklistItem checklistItem = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_checklist, parent, false);
        }

        TextView descriptionTextView = convertView.findViewById(R.id.checklistItemDescription);
        CheckBox checkBox = convertView.findViewById(R.id.checklistItemCheckbox);

        descriptionTextView.setText(checklistItem.  getDescription());
        checkBox.setChecked(checklistItem.isChecked());

        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> checklistItem.setChecked(isChecked));

        return convertView;
    }
}
