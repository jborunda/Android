package com.example.rkjc.news_app_2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    URL url;
    Menu menu;
    String jsonString;
    RecyclerView rv;
    //Implement the menu item in your activity
    //so that it executes the AsyncTask.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = (Menu) findViewById(R.id.get_news);
        rv = (RecyclerView)findViewById(R.id.news_recyclerview);

        rv.setLayoutManager(new LinearLayoutManager(this));

        NewsQueryTask task = new NewsQueryTask();
        task.execute();
    }


    //Extend and implement a subclass of AsyncTask,
    public class NewsQueryTask extends AsyncTask<URL, Void, String> {
        URL newsRequestUrl = NetworkUtils.buildUrl();
        //ArrayList result = new ArrayList();
        String jsonString;



        @Override
        protected String doInBackground(URL... urls) {


            try {
                jsonString = NetworkUtils.getResponseFromHttpUrl(newsRequestUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                jsonString = JsonUtils.parseNews(jsonString);
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return jsonString;
        }

}
}
