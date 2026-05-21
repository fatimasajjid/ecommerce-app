package com.example.online_shop;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.online_shop.databinding.BrandItemBinding;
import java.util.List;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.ViewHolder> {

    private final List<Brand> list;

    public BrandAdapter(List<Brand> list) {
        this.list = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        BrandItemBinding binding;
        public ViewHolder(BrandItemBinding b) {
            super(b.getRoot());
            this.binding = b;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BrandItemBinding binding = BrandItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Brand brand = list.get(position);
        holder.binding.brandImage.setImageResource(brand.getImage());
        holder.binding.brandName.setText(brand.getName());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), BrandProductsActivity.class);
            intent.putExtra("brandName", brand.getName());
            intent.putExtra("brandImage", brand.getImage());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }
}