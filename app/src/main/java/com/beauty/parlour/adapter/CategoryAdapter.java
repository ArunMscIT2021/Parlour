package com.beauty.parlour.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beauty.parlour.R;
import com.beauty.parlour.model.Category;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    Activity activity;
    ArrayList<Category> categories;


    public CategoryAdapter(ArrayList<Category> categories, Activity activity) {
        this.categories = categories;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.category_lyt, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvCategoryName.setText(categories.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCategoryName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCategoryName = itemView.findViewById(R.id.tv_category_name);


        }
    }
}
