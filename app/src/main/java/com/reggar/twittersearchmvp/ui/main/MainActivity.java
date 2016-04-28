package com.reggar.twittersearchmvp.ui.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.reggar.twittersearchmvp.R;
import com.reggar.twittersearchmvp.ReggarApplication;
import com.reggar.twittersearchmvp.models.Tweet;
import com.reggar.twittersearchmvp.ui.main.adapters.TweetAdapter;
import com.reggar.twittersearchmvp.ui.utils.SimpleDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import nucleus.factory.RequiresPresenter;
import nucleus.view.NucleusAppCompatActivity;

@RequiresPresenter(MainPresenter.class)
public class MainActivity extends NucleusAppCompatActivity<MainPresenter>
        implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.searchButton) ImageButton searchButton;
    @BindView(R.id.errorMessage) TextView errorMessage;
    @BindView(R.id.searchQuery) EditText searchQuery;
    @BindView(R.id.swipeRefresh) SwipeRefreshLayout swipeRefresh;

    private TweetAdapter tweetAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ReggarApplication.getAppComponent(this).inject(this);

        setSupportActionBar(toolbar);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        swipeRefresh.setOnRefreshListener(this);

        tweetAdapter = new TweetAdapter(new ArrayList<Tweet>(), this);

        recyclerView.setAdapter(tweetAdapter);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(
                getApplicationContext()
        ));
    }

    @Override
    public void onRefresh() {
        hideSoftKeyboard();
        errorMessage.setVisibility(View.GONE);
        getPresenter().refresh();
    }

    @OnEditorAction(R.id.searchQuery)
    boolean onKeyboardAction() {
        hideSoftKeyboard();
        errorMessage.setVisibility(View.GONE);
        getPresenter().search(searchQuery.getText().toString());
        return true;
    }

    @OnClick(R.id.searchButton)
    public void onSearchButtonClicked() {
        hideSoftKeyboard();
        errorMessage.setVisibility(View.GONE);
        swipeRefresh.setRefreshing(true);
        getPresenter().search(searchQuery.getText().toString());
    }

    public void hideSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    public void updateTweets(List<Tweet> newTweets) {
        swipeRefresh.setRefreshing(false);
        tweetAdapter.setTweets(newTweets);
        tweetAdapter.notifyDataSetChanged();
    }

    public void onNetworkError(Throwable throwable) {
        swipeRefresh.setRefreshing(false);
        tweetAdapter.clear();
        tweetAdapter.notifyDataSetChanged();
        errorMessage.setVisibility(View.VISIBLE);
    }
}
