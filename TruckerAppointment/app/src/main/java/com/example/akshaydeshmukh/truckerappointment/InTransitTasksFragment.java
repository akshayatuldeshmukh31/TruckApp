package com.example.akshaydeshmukh.truckerappointment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Akshay Deshmukh on 8/5/2017.
 */

public class InTransitTasksFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private InTransitTasksAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.in_transit_tasks_fragment, container, false);

        mRecyclerView = view.findViewById(R.id.recycler_view_in_transit);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mAdapter = new InTransitTasksAdapter(TabbedActivity.inTransitTasksJsonArray);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }
}
