package com.example.itoday;

import org.json.JSONArray;
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
            JSONArray articles = jsonObject.getJSONArray("articles");

            for (int i=0; i<=articles.length(); i++){
                JSONObject currentPosition = articles.getJSONObject(i);
                String author = currentPosition.getString("author");
                String title = currentPosition.getString("title");
                String description = currentPosition.getString("description");
                String webUrl = currentPosition.getString("url");
                String imageUrl = currentPosition.getString("urlToImage");
                String publishedAt = currentPosition.getString("publishedAt");
                String content = currentPosition.getString("content");

                details.add(new Details(author, title, description, webUrl, imageUrl, publishedAt,content));
            }

            return details;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return details;

    }

}
