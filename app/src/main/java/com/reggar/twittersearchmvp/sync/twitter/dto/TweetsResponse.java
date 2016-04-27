package com.reggar.twittersearchmvp.sync.twitter.dto;

import com.google.gson.annotations.SerializedName;
import com.reggar.twittersearchmvp.models.Tweet;

import java.util.List;

public class TweetsResponse {
    @SerializedName("statuses") public List<Tweet> tweets;
}
