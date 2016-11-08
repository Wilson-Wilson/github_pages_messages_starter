package io.github.sultanofcardio.githubpagesmessages.adapters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.github.sultanofcardio.githubpagesmessages.R;
import io.github.sultanofcardio.githubpagesmessages.models.Message;


/**
 * @author sultanofcardio
 *
 * This class is an Adapter class. In the async.MessageTask.java class, we spoke of our app
 * having different threads. We will speak of this once more here as this code in the methods 
 * in this class also runs on a thread separate from the main thread. 
 *
 * The main idea of what this class does is to manage the data that is being displayed in 
 * the RecyclerView. Such data must reside in some kind of java List object. It has three 
 * abstract methods that will be called by the OS, which you must define:
 *
 * - onCreateViewHolder()
 *      This method is responsible for creating the view(s) that each individual item in the list 
 *      will be displayed as, and representing it as a java class called a ViewHolder (kind of 
 *      fitting isn't it?). This is the second of the three methods to be called by the OS.
 *
 * - onBindViewHolder()
 *      This is the last method to be called and at this point, you will be using your ViewHolder
 *      object to manipulate the view(s) it is holding (perhaps setting text in a TextView). This
 *      is the point at which we want to transfer the data from the list form, to the apropriate
 *      place in the view(s).
 *
 * - getItemCount()
 *      This is the first method to be called by the operating system and it returns a number to
 *      the OS. This number represent the number of items in the list and it uses that number to
 *      determine how many times to call these methods in succesion in order to populate the list.
 *      This also saves the OS from trying to do operations on an empty list.
 *
 *  This class has been written for you.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageHolder> {
    private List<Message> messages;

    public MessageAdapter(){
        messages = Message.listAll(Message.class);
    }

    @Override
    public MessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MessageHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_message, parent, false));
    }

    @Override
    public void onBindViewHolder(MessageHolder holder, int position) {
        Message message = messages.get(position);

        holder.name.setText(message.getName());
        holder.email.setText(message.getEmail());
        holder.message.setText(message.getMessage());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public void update(){
        this.messages = Message.listAll(Message.class);
        notifyDataSetChanged();
    }

    /**
     * This class represents an individual view in the list of views.
     *
     * This class has been written for you
     */
    class MessageHolder extends RecyclerView.ViewHolder{
        TextView name, email, message;

        public MessageHolder(final View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name_value);
            email = (TextView) itemView.findViewById(R.id.email_value);
            message = (TextView) itemView.findViewById(R.id.message_value);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + email.getText().toString()));
                    itemView.getContext().startActivity(intent);

                }
            });
        }
    }
}
