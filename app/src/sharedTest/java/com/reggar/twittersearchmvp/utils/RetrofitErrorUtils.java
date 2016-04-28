package com.reggar.twittersearchmvp.utils;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;

public class RetrofitErrorUtils {
    public static HttpException createHttp(int responseCode) {
        Response response = Response.error(responseCode, ResponseBody.create(MediaType.parse(""), ""));
        return new HttpException(response);
    }

    public static IOException createConversion() {
        return new IOException();
    }
}
