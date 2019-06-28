package com.example.itoday;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String YOUR_API_KEY = "2519726092a94d57b9046490e66ab407";
    //Change this With Your api key from newapi.org
    public String BASE_URL = "https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=" + YOUR_API_KEY;
    ArrayAdapter<Details> mAdapter;
    ArrayList<Details> details;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        mAdapter = new DetailsAdapter(this, new ArrayList<Details>());

        listView.setAdapter(mAdapter);

    }


    private class DetailsLoader extends AsyncTask<String, Void, ArrayList<Details>>{

        @Override
        protected ArrayList<Details> doInBackground(String... strings) {
            ArrayList<Details> result = QueryUtils.fetchData(BASE_URL);
            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<Details> details) {
            if(!mAdapter.isEmpty()){
                mAdapter.clear();
            }
            mAdapter.addAll(details);
        }
    }
}
