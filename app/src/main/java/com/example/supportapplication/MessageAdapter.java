package com.example.supportapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.supportapplication.models.Message;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class MessageAdapter extends ArrayAdapter<Message> {

    private static final int VIEW_TYPE_SENT = 0;
    private static final int VIEW_TYPE_RECEIVED = 1;

    public MessageAdapter(Context context, List<Message> messages) {
        super(context, 0, messages);
    }

    @Override
    public int getItemViewType(int position) {
        Message message = getItem(position);
        String currentUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        return message.getSender().equals(currentUserId) ? VIEW_TYPE_SENT : VIEW_TYPE_RECEIVED;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message message = getItem(position);
        int viewType = getItemViewType(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            if (viewType == VIEW_TYPE_SENT) {
                convertView = inflater.inflate(R.layout.item_message_sent, parent, false);
            } else {
                convertView = inflater.inflate(R.layout.item_message_received, parent, false);
            }
        }

        TextView messageTextView = convertView.findViewById(R.id.messageTextView);
        TextView messageTimeTextView = convertView.findViewById(R.id.messageTimeTextView);

        messageTextView.setText(message.getText());
        messageTimeTextView.setText(message.getFormattedTime());

        return convertView;
    }
}
