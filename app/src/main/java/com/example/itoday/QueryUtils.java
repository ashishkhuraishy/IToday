package com.example.itoday;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class QueryUtils {


    public ArrayList<Details> fetchData(String BASE_URL){

        URL url = createUrl(BASE_URL);
        String JsonResponse = makeHttpConnection(url);
        ArrayList<Details> details = readFromJson(JsonResponse);
        return details;
    }



    private URL createUrl(String base_url) {

        URL url = null;

        try {
            url = new URL(base_url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    private String makeHttpConnection(URL url) {

        String jsonResponse = "";
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(10000);
            urlConnection.connect();
            inputStream = urlConnection.getInputStream();
            jsonResponse = readFromStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonResponse;
    }



    private String readFromStream(InputStream inputStream) throws IOException {

        StringBuilder output = new StringBuilder();
        if(inputStream != null){
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            String line = bufferedReader.readLine();
            while (line != null){
                output.append(line);
                line = bufferedReader.readLine();
            }
        }

        return output.toString();
    }

    private ArrayList<Details> readFromJson(String jsonResponse) {

        ArrayList<Details> details = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


}
