package com.vazheninapps.chatapp;

import android.content.Context;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private static final int TYPE_MY_MESSAGE = 0;
    private static final int TYPE_OTHER_MESSAGE = 1;


    private List<Message> messages;
    private Context context;

    public MessageAdapter(Context context) {
        messages = new ArrayList<>();
        this.context = context;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewType == TYPE_MY_MESSAGE){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_message, parent, false);
        }else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_other_message, parent, false);
        }

        return new MessageViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        Message message = messages.get(position);
        String author = message.getAuthor();
        if (author != null && author.equals(PreferenceManager.getDefaultSharedPreferences(context).getString("author", "anonim"))) {
            return TYPE_MY_MESSAGE;
        } else {
            return TYPE_OTHER_MESSAGE;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = messages.get(position);
        holder.textViewAuthor.setText(message.getAuthor());
        if (message.getMessage() != null && !message.getMessage().isEmpty()) {
            holder.textViewMessage.setText(message.getMessage());
            holder.imageViewImage.setVisibility(View.GONE);
            holder.textViewMessage.setVisibility(View.VISIBLE);
        }
        if (message.getImageUrl() != null && !message.getImageUrl().isEmpty()) {
            holder.imageViewImage.setVisibility(View.VISIBLE);
            holder.textViewMessage.setVisibility(View.GONE);
            Picasso.get().load(message.getImageUrl()).into(holder.imageViewImage);


        }

    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class MessageViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewAuthor;
        private TextView textViewMessage;
        private ImageView imageViewImage;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
            textViewMessage = itemView.findViewById(R.id.textViewMessage);
            imageViewImage = itemView.findViewById(R.id.imageViewImage);
        }
    }
}
