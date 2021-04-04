package com.example.mylab12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> implements Filterable {
    List<String> titles;
    List<Integer> images;
    List<String> Fooditems;
    LayoutInflater inflater;

    public Adapter(Context ctx, List<String> titles, List<Integer> images)
    {
        this.titles=titles;
        this.images=images;
        this.inflater=LayoutInflater.from(ctx);

        this.Fooditems=new ArrayList<>(titles);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.custom_grid_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(titles.get(position));
        holder.gridIcon.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<String> filteredList=new ArrayList<>();
            if(constraint.toString().isEmpty())
            {
                filteredList.addAll(Fooditems);
            }
            else
            {
                for (String items: Fooditems)
                {
                    if(items.toLowerCase().contains(constraint.toString().toLowerCase()))
                    {
                        filteredList.add(items);
                    }
                }
            }

            FilterResults filterResults=new FilterResults();
            filterResults.values=filteredList;
            return filterResults;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            titles.clear();
            titles.addAll((Collection<? extends String>) results.values);
            notifyDataSetChanged();
        }
    };
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        ImageView gridIcon;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            title = itemView.findViewById(R.id.textView2);
            gridIcon = itemView.findViewById(R.id.imageView2);

            String text=titles.toString();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Clicked " + getAdapterPosition() + "Item", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
