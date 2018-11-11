package com.example.rkjc.news_app_2;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class JsonUtils {


    public static ArrayList<NewsItem> parseNews(String newsJsonStr) throws JSONException {
        JSONObject newsJson = new JSONObject(newsJsonStr);

        JSONArray newsArray = newsJson.getJSONArray("articles");
        ArrayList<NewsItem> newsArrayList = new ArrayList<>();

        for(int i = 0; i<newsArray.length(); i++){

            JSONObject article = newsArray.getJSONObject(i);

            String title = article.getString("title");
            String desc = article.getString("description");
            String author = article.getString("author");
            String url = article.getString("url");
            String date = article.getString("publishedAt");

            NewsItem newItem = new NewsItem(title, author, url, desc, date);
            newsArrayList.add(newItem);
        }

        return newsArrayList;
    }
}


