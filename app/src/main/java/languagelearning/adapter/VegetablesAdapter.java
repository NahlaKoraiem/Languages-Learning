package ideanity.oceans.languagelearning.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ideanity.oceans.languagelearning.R;
import ideanity.oceans.languagelearning.RecyclerViewAction;
import ideanity.oceans.languagelearning.helpers.VegetablesHelper;

public class VegetablesAdapter extends RecyclerView.Adapter<VegetablesAdapter.ColorViewHolder>{
    ArrayList<VegetablesHelper> vegetable;
    private Context mContext;
    private RecyclerViewAction recyclerViewAction;

    public VegetablesAdapter(ArrayList<VegetablesHelper> vegetable, Context mContext, RecyclerViewAction recyclerViewAction) {
        this.vegetable = vegetable;
        this.mContext = mContext;
        this.recyclerViewAction = recyclerViewAction;
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_allvegetables, parent, false);
        ColorViewHolder colorViewHolder = new ColorViewHolder(view);
        return colorViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        final VegetablesHelper vegetablesHelper = vegetable.get(position);

        holder.title.setImageResource(vegetablesHelper.getImage());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewAction.onViewClicked(v.getId(), holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return vegetable.size();
    }

    public static class ColorViewHolder extends RecyclerView.ViewHolder {

        ImageView title;
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