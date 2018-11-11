package com.example.rkjc.news_app_2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class NewsRecyclerViewAdapter  extends RecyclerView.Adapter<NewsRecyclerViewAdapter.NewsViewHolder> {


    Context mContext;
    ArrayList<NewsItem> mRepos;

    public NewsRecyclerViewAdapter(Context context, ArrayList<NewsItem> repos){
        this.mContext = context;
        this.mRepos = repos;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(R.layout.news_item, parent, shouldAttachToParentImmediately);
        NewsViewHolder viewHolder = new NewsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mRepos.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name;
        TextView url;

        public NewsViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.title);
            url = (TextView) itemView.findViewById(R.id.author);
            url = (TextView) itemView.findViewById(R.id.desc);
            url = (TextView) itemView.findViewById(R.id.url);
            url = (TextView) itemView.findViewById(R.id.date);
        }

        void bind(final int listIndex) {
            name.setText(mRepos.get(listIndex).getTitle());
            url.setText(mRepos.get(listIndex).getAuthor());
            url.setText(mRepos.get(listIndex).getDesc());
            url.setText(mRepos.get(listIndex).getUrl());
            url.setText(mRepos.get(listIndex).getDate());
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            String urlString = mRepos.get(getAdapterPosition()).getUrl();
            Intent intent = new Intent(mContext, WebActivity.class);
            intent.putExtra("urlString", urlString);
            mContext.startActivity(intent);
        }
    }

}
