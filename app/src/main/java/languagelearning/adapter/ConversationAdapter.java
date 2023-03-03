package ideanity.oceans.languagelearning.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ideanity.oceans.languagelearning.R;
import ideanity.oceans.languagelearning.RecyclerViewAction;
import ideanity.oceans.languagelearning.helpers.ConversationHelper;


public class ConversationAdapter extends RecyclerView.Adapter<ConversationAdapter.ColorViewHolder>{
    ArrayList<ConversationHelper> conversation;
    private Context mContext;
    private RecyclerViewAction recyclerViewAction;

    public ConversationAdapter(ArrayList<ConversationHelper> conversation, Context mContext, RecyclerViewAction recyclerViewAction) {
        this.conversation = conversation;
        this.mContext = mContext;
        this.recyclerViewAction = recyclerViewAction;
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.iterm_allconversation, parent, false);
        ColorViewHolder colorViewHolder = new ColorViewHolder(view);
        return colorViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        final ConversationHelper greetingHelper = conversation.get(position);

        holder.title.setText(greetingHelper.getTitle());
        if (holder.title.getText().toString().equals("What is your name?")) {
            holder.title.setTextColor(Color.parseColor("#9c27b0"));
        }
        if (holder.title.getText().toString().equals("How old are you?")) {
            holder.title.setTextColor(Color.parseColor("#4caf50"));
        }
        if (holder.title.getText().toString().equals("Where are you living?")) {
            holder.title.setTextColor(Color.parseColor("#9c27b0"));
        }
        if (holder.title.getText().toString().equals("How are you?")) {
            holder.title.setTextColor(Color.parseColor("#4caf50"));
        }
        if (holder.title.getText().toString().equals("What is your nationality?")) {
            holder.title.setTextColor(Color.parseColor("#2196f3"));
        }
        if (holder.title.getText().toString().equals("How is the weather?")) {
            holder.title.setTextColor(Color.parseColor("#2196f3"));
        }



        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewAction.onViewClicked(v.getId(), holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return conversation.size();
    }

    public static class ColorViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        public View layout;
        CardView container;

        public ColorViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView;

            //Hooks
            title = itemView.findViewById(R.id.content);

        }


    }


}