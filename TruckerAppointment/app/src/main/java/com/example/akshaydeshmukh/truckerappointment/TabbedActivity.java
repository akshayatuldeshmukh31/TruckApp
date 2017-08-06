package com.example.akshaydeshmukh.truckerappointment;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TabbedActivity extends AppCompatActivity {

    private android.support.v4.app.FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    public static JSONArray upcomingTasksJsonArray = new JSONArray();
    public static JSONArray inTransitTasksJsonArray = new JSONArray();
    public static JSONArray completedTasksJSONArray = new JSONArray();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_upcoming:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.content, new UpcomingTasksFragment());
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_in_transit:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.content, new InTransitTasksFragment());
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_completed:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.content, new CompletedTasksFragment());
                    fragmentTransaction.commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fragmentManager = getSupportFragmentManager();

        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject();
            jsonObject.put("company", "Walmart");
            jsonObject.put("containerId", "12345600");
            jsonObject.put("date", "08-10-2017");
            jsonObject.put("pickupTime", "1100");
            jsonObject.put("mtoId", "5");
            jsonObject.put("origin", "Walmart, Culver City");
            jsonObject.put("destination", "LA Port");
            jsonObject.put("type", "Export");

            upcomingTasksJsonArray.put(jsonObject);

            jsonObject = new JSONObject();
            jsonObject.put("company", "Drayage Trucking, CA");
            jsonObject.put("containerId", "12945600");
            jsonObject.put("date", "08-15-2017");
            jsonObject.put("pickupTime", "2304");
            jsonObject.put("mtoId", "2");
            jsonObject.put("origin", "LA Port");
            jsonObject.put("destination", "Macy's");
            jsonObject.put("type", "Import");

            upcomingTasksJsonArray.put(jsonObject);

            jsonObject = new JSONObject();
            jsonObject.put("company", "Best Buy");
            jsonObject.put("containerId", "89945600");
            jsonObject.put("date", "08-16-2017");
            jsonObject.put("pickupTime", "2001");
            jsonObject.put("mtoId", "1");
            jsonObject.put("origin", "Best Buy, Santa Monica");
            jsonObject.put("destination", "LA Port");
            jsonObject.put("type", "Export");

            upcomingTasksJsonArray.put(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, new UpcomingTasksFragment());
        fragmentTransaction.commit();
    }

}
