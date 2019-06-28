package com.example.itoday;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class DetailsAdapter extends ArrayAdapter<Details> {
    public DetailsAdapter(Activity context, ArrayList<Details> details) {
        super(context, 0, details);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_item, parent, false);
        }

        Details currentPosition = getItem(position);

        TextView titleTextView = listItemView.findViewById(R.id.titleText);
        titleTextView.setText(currentPosition.getmTitle());

        TextView authorTextView = listItemView.findViewById(R.id.authorText);
        authorTextView.setText(currentPosition.getmAuthor());

        return listItemView;

    }
}
