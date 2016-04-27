package com.reggar.twittersearchmvp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rob on 26/04/2016.
 */
public class TwitterUser {
    @SerializedName("name") String userName;
    @SerializedName("profile_background_image_url_https") String imageUrl;

    /**
     *
     * @return The username of the Twitter User
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @return The URL of the avatar (SSL)
     */
    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TwitterUser that = (TwitterUser) o;

        if (userName != null ? !userName.equals(that.userName) : that.userName != null)
            return false;
        return imageUrl != null ? imageUrl.equals(that.imageUrl) : that.imageUrl == null;

    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TwitterUser{" +
                "userName='" + userName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
