package com.example.akshaydeshmukh.truckerappointment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Akshay Deshmukh on 8/5/2017.
 */

public class CompletedTasksViewHolder extends RecyclerView.ViewHolder {

    private TextView companyName, containerId, date, pickupTime, mtoId, origin, destination;
    private ImageView type;

    public CompletedTasksViewHolder(View v) {
        super(v);

        companyName = (TextView) v.findViewById(R.id.completed_company_name);
        containerId = (TextView) v.findViewById(R.id.completed_container_id_name);
        date = (TextView) v.findViewById(R.id.completed_date_name);
        pickupTime = (TextView) v.findViewById(R.id.completed_pickup_name);
        mtoId = (TextView) v.findViewById(R.id.completed_mto_name);
        origin = (TextView) v.findViewById(R.id.completed_origin_name);
        destination = (TextView) v.findViewById(R.id.completed_destination_name);
        type = (ImageView) v.findViewById(R.id.completed_tasks_type);
    }

    public void bindTask(JSONObject jsonObject){
        try {
            companyName.setText(jsonObject.getString("company"));
            containerId.setText(jsonObject.getString("containerId"));
            date.setText(jsonObject.getString("date"));
            pickupTime.setText(jsonObject.getString("pickupTime"));
            mtoId.setText(jsonObject.getString("mtoId"));
            origin.setText(jsonObject.getString("origin"));
            destination.setText(jsonObject.getString("destination"));

            if(jsonObject.getString("type").equals("Import")){
                type.setImageResource(R.drawable.import_icon);
            } else {
                type.setImageResource(R.drawable.export_icon);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
