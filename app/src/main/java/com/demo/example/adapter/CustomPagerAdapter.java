package com.demo.example.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.demo.example.R;
import com.demo.example.State;

import java.util.ArrayList;
import java.util.List;

public class CustomPagerAdapter extends PagerAdapter {

    private Context context;
    private List<State> itemList; // Original list
    private List<State> filteredList; // Filtered list

    public CustomPagerAdapter(Context context, List<State> itemList) {
        this.context = context;
        this.itemList = itemList;
        this.filteredList = new ArrayList<>(itemList); // Start with full list
    }

    @Override
    public int getCount() {
        return filteredList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_state, container, false);

        // Bind data to views
        TextView nameTextView = itemView.findViewById(R.id.stateName);
        nameTextView.setText(filteredList.get(position).getName());

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    // Method to filter data by name
//    public void filterByName(String query) {
//        filteredList.clear();
//        if (query.isEmpty()) {
//            filteredList.addAll(itemList); // If query is empty, show all items
//        } else {
//            query = query.toLowerCase();
//            for (State item : itemList) {
//                if (item.getName().toLowerCase().contains(query)) {
//                    filteredList.add(item);
//                }
//            }
//        }
//        notifyDataSetChanged(); // Notify adapter of data change
//    }

    // Method to filter data by name
    public void filterByName(String query) {
        Log.d("Filter", "Filtering with query: " + query);
        filteredList.clear();
        if (query.isEmpty()) {
            filteredList.addAll(itemList); // If query is empty, show all items
        } else {
            query = query.toLowerCase();
            for (State item : itemList) {
                if (item.getName().toLowerCase().contains(query)) {
                    filteredList.add(item);
                }
            }
        }
        notifyDataSetChanged(); // Notify adapter of data change
        Log.d("Filter", "Filtered list size: " + filteredList.size());
    }

}
