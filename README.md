# Twitter Search MVP
Twitter Search MVP is a simple Android application for searching Twitter. Simple enter in your desired hashtag and the Twitter REST API will be queries and results will be displayed.

This was created as a test of MVP, OAuth and Twitter RESTful API. This application uses application-only authentication where the application itself is authenticated against Twitter as opposed to individual users.

## Getting Started
1) Clone repository
2) Visit https://dev.twitter.com/oauth/overview/application-owner-access-tokens and generate an OAuth access token.
2) Copy keys.example.gradle to key.gradle
3) Replace CONSUMER_KEY, CONSUMER_SECRET, TOKEN, & TOKEN_SECRET with your personal keys as generated from Twitter.

## Limitations
- Twitter Search MVP targets Android 4.0.3+ (API 15) as this is a good trade-off between device support while still allowing the latest SDK features.