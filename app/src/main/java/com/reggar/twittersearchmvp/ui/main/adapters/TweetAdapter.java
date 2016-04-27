package com.reggar.twittersearchmvp.ui.main.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.reggar.twittersearchmvp.R;
import com.reggar.twittersearchmvp.models.Tweet;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder> {

    Context context;
    List<Tweet> tweets;

    public TweetAdapter(List<Tweet> tweets, Context context) {
        this.tweets = tweets;
        this.context = context;
    }

    public void setTweets(List<Tweet> newTweets) {
        tweets = newTweets;
    }

    public void clear() {
        tweets = new ArrayList<Tweet>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tweet_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Tweet tweet = tweets.get(position);
        holder.title.setText(tweet.getUser().getUserName());
        holder.message.setText(tweet.getBody());
        Glide.with(context)
                .load(tweet.getUser().getImageUrl())
                .centerCrop()
                .into(holder.userImage);

    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title) TextView title;
        @BindView(R.id.message) TextView message;
        @BindView(R.id.userImage) ImageView userImage;

        public ViewHolder(final View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
