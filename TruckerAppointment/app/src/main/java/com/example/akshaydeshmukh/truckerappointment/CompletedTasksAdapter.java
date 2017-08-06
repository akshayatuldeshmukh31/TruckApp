package com.example.akshaydeshmukh.truckerappointment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Akshay Deshmukh on 8/5/2017.
 */

public class CompletedTasksAdapter extends RecyclerView.Adapter<CompletedTasksViewHolder>{

    JSONArray jsonArray;

    public CompletedTasksAdapter(JSONArray jsonArray){
        this.jsonArray = jsonArray;
    }

    @Override
    public CompletedTasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.completed_task_list_item_layout, parent, false);

        return new CompletedTasksViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(CompletedTasksViewHolder holder, int position) {
        try {
            holder.bindTask(jsonArray.getJSONObject(position));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }
}
