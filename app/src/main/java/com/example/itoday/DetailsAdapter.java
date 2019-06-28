package com.example.itoday;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.ArrayList;


public class DetailsAdapter extends ArrayAdapter<Details> {
    public DetailsAdapter(Activity context, ArrayList<Details> details) {
        super(context, 0, details);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listView = convertView;
        if(listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main, parent, false);
        }

        Details currentPosition = getItem(position);

        return listView;

    }
}
