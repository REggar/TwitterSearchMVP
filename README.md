# Twitter Search MVP
[![Build Status](https://travis-ci.org/REggar/TwitterSearchMVP.svg?branch=master)](https://travis-ci.org/REggar/TwitterSearchMVP)

Twitter Search MVP is a simple Android application for searching Twitter. Simply enter your desired hashtag and the Twitter REST API will be queried and the results will be displayed.

This was created as a test of MVP, OAuth and Twitter RESTful API. This application uses application-only authentication where the application itself is authenticated against Twitter as opposed to individual users.

## Getting Started
1. Clone repository
2. Visit https://dev.twitter.com/oauth/overview/application-owner-access-tokens and generate an OAuth access token.
3. Copy keys.example.gradle to key.gradle
4. Replace CONSUMER_KEY, CONSUMER_SECRET, TOKEN, & TOKEN_SECRET with your personal keys as generated from Twitter.

## Libraries
* [Dagger 2](http://google.github.io/dagger/)
* [Butter Knife](http://jakewharton.github.io/butterknife/)
* [Retrofit](http://square.github.io/retrofit/)
* [Signpost](https://github.com/mttkay/signpost)
* [okhttp-signpost](https://github.com/pakerfeldt/okhttp-signpost)
* [RxJava](https://github.com/ReactiveX/RxJava)
* [RxAndroid](https://github.com/ReactiveX/RxAndroid)
* [Glide](https://github.com/bumptech/glide)
* [Nucleus](https://github.com/konmik/nucleus)

## Limitations
* Twitter Search MVP targets Android 4.0.3+ (API 15) as this is a good trade-off between device support while still allowing the latest SDK features.