package com.colanconnon.fishtrackerandroid;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by colanconnon on 7/19/15.
 */
public class FishCatchesAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<FishCatch> fishCatches;

    public FishCatchesAdapter(Context context, ArrayList<FishCatch> fishCatches) {
        this.fishCatches = fishCatches;
        this.context = context;
    }

    @Override
    public int getCount() {
        return fishCatches.size();
    }

    @Override
    public Object getItem(int position) {
        return fishCatches.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.fish_catch_item, null);
        }

        TextView fishCatchTxt = (TextView) view.findViewById(R.id.NameTxt);

        return view;
    }
}
