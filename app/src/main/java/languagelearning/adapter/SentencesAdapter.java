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
import ideanity.oceans.languagelearning.helpers.SentencesHelper;


public class SentencesAdapter extends RecyclerView.Adapter<SentencesAdapter.ColorViewHolder>{
    ArrayList<SentencesHelper> sentence;
    private Context mContext;
    private RecyclerViewAction recyclerViewAction;

    public SentencesAdapter(ArrayList<SentencesHelper> sentence, Context mContext, RecyclerViewAction recyclerViewAction) {
        this.sentence = sentence;
        this.mContext = mContext;
        this.recyclerViewAction = recyclerViewAction;
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_allsentences, parent, false);
        ColorViewHolder colorViewHolder = new ColorViewHolder(view);
        return colorViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        final SentencesHelper sentencesHelper = sentence.get(position);

        holder.title.setText(sentencesHelper.getTitle());
        if (holder.title.getText().toString().equals("Hello i am Sara")) {
            holder.title.setTextColor(Color.parseColor("#9c27b0"));
        }
        if (holder.title.getText().toString().equals("I love cats")) {
            holder.title.setTextColor(Color.parseColor("#4caf50"));
        }
        if (holder.title.getText().toString().equals("I am playing Judo")) {
            holder.title.setTextColor(Color.parseColor("#9c27b0"));
        }
        if (holder.title.getText().toString().equals("I live in Cairo")) {
            holder.title.setTextColor(Color.parseColor("#4caf50"));
        }
        if (holder.title.getText().toString().equals("Swimming is good")) {
            holder.title.setTextColor(Color.parseColor("#2196f3"));
        }
        if (holder.title.getText().toString().equals("I am baking a cake")) {
            holder.title.setTextColor(Color.parseColor("#2196f3"));
        }
        if (holder.title.getText().toString().equals("Do you want to play?")) {
            holder.title.setTextColor(Color.parseColor("#ec407a"));
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
        return sentence.size();
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