package com.example.akshaydeshmukh.truckerappointment;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Akshay Deshmukh on 8/5/2017.
 */

public class InTransitTasksAdapter extends RecyclerView.Adapter<InTransitTasksViewHolder> {

    JSONArray jsonArray;

    public InTransitTasksAdapter(JSONArray jsonArray){
        this.jsonArray = jsonArray;
    }

    @Override
    public InTransitTasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.in_transit_task_list_item_layout, parent, false);

        return new InTransitTasksViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(InTransitTasksViewHolder holder, final int position) {
        try {
            holder.bindTask(jsonArray.getJSONObject(position));
            holder.getDoneButton().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        try {
                            TabbedActivity.completedTasksJSONArray.put(jsonArray.getJSONObject(position));
                            jsonArray.remove(position);
                            notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }
}
