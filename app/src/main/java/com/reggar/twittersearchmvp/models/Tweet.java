package com.reggar.twittersearchmvp.models;

import com.google.gson.annotations.SerializedName;

public class Tweet {
    @SerializedName("user") TwitterUser user;
    @SerializedName("text") String body;

    /**
     *
     * @return The TwitterUser of the user who sent the tweet
     */
    public TwitterUser getUser() {
        return user;
    }

    /**
     *
     * @return The body of tweet
     */
    public String getBody() {
        return body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tweet tweet = (Tweet) o;

        if (user != null ? !user.equals(tweet.user) : tweet.user != null) return false;
        return body != null ? body.equals(tweet.body) : tweet.body == null;

    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "user=" + user +
                ", body='" + body + '\'' +
                '}';
    }
}
