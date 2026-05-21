package com.example.online_shop;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.online_shop.databinding.ProductItemBinding;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    List<Product> list;

    public ProductAdapter(List<Product> list) {
        this.list = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ProductItemBinding binding;
        public ViewHolder(ProductItemBinding b) {
            super(b.getRoot());
            binding = b;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductItemBinding binding = ProductItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product p = list.get(position);
        holder.binding.productImage.setImageResource(p.getImage());
        holder.binding.productName.setText(p.getName());
        holder.binding.productPrice.setText(p.getPrice());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), ProductDetail.class);
            intent.putExtra("image", p.getImage());
            intent.putExtra("name", p.getName());
            intent.putExtra("price", p.getPrice());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}