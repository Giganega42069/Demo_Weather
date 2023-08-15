package sg.edu.rp.c346.id22004686.demoweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Weather> versionList;

    public CustomAdapter(Context context, int resource, ArrayList<Weather> objects){
        super(context,resource,objects);

        parent_context = context;
        layout_id = resource;
        versionList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView Area = rowView.findViewById(R.id.Area);
        TextView Forecast = rowView.findViewById(R.id.forecast);

        // Obtain the Android Version information based on the position
        Weather currentVersion = versionList.get(position);

        // Set values to the TextView to display the corresponding information
        Area.setText(currentVersion.getArea());
        Forecast.setText(currentVersion.getForecast());

        return rowView;
    }
}
