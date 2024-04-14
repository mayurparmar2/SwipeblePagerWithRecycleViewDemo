package com.demo.example.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.example.R;
import com.demo.example.State;

import java.util.ArrayList;
import java.util.List;

public class Adapter_Contacts extends BaseAdapter implements Filterable {
    private Context context;
    private List<State> listContacts;
    List<State> mStringFilterList;
    private LayoutInflater inflater;
    ValueFilter valueFilter;


    public Adapter_Contacts(Context context, List<State> listContacts) {
        this.context = context;
        this.listContacts = listContacts;
        mStringFilterList = listContacts;
    }


    @Override
    public int getCount() {
        return listContacts.size();
    }

    @Override
    public Object getItem(int i) {
        return listContacts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null)
            view = inflater.inflate(R.layout.item_state, null);

        State bean_contacts = listContacts.get(i);
        TextView txtName = (TextView) view.findViewById(R.id.stateName);
        txtName.setText(bean_contacts.getName());

//        //Getting views
//        ImageView img = (ImageView) view.findViewById(R.id.imgContact);
//        TextView txtName = (TextView) view.findViewById(R.id.txtNam);
//        TextView txtStatus = (TextView) view.findViewById(R.id.stats);
//
//        Bean_Contacts bean_contacts = listContacts.get(i);
//        String name = bean_contacts.getName();
//        Log.e("NameAdapter", name);
//        String url = bean_contacts.getUrl();
//        Log.e("URLAdapter", url);
//        String extension = bean_contacts.getExtension();
//        String status = bean_contacts.getStatus();
//
//        apiConfiguration = new ApiConfiguration();
//        String api = apiConfiguration.getApi();
//        String absoluteURL = api + "/" + url + "." + extension;
//        Log.e("AbsoluteURLAdapter", absoluteURL);
//
//        Picasso.with(context).load(absoluteURL).error(R.drawable.default_avatar).into(img); //Loading image into the circular Image view using Picasso
//        txtName.setText(name);
//        txtStatus.setText(status);

        return view;
    }

    @Override
    public Filter getFilter() {
        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    private class ValueFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            String str = constraint.toString().toUpperCase();
            Log.e("constraint", str);
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                ArrayList<State> filterList = new ArrayList<State>();
                for (int i = 0; i < mStringFilterList.size(); i++) {
                    if ((mStringFilterList.get(i).getName().toUpperCase())
                            .contains(constraint.toString().toUpperCase())) {
                        State bean_contacts = mStringFilterList.get(i);
                        filterList.add(bean_contacts);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = mStringFilterList.size();
                results.values = mStringFilterList;
            }
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listContacts = (ArrayList<State>) results.values;
            notifyDataSetChanged();
        }
    }

}