# MyMovieApplication (TMDB Movie Application)

* This is a Movie Application which provides the information about the Upcoming Movies and NowPlaying Movies.

* This application is developed using rest API called TMDB(The Moviedb).

* App consist of 1 activity which displays two tabs using fragments they are:
1. Nowpalying Movies
2. Upcoming Movies

* Both Tabs displays the movie information using ListView.

* Each row displays:
1. Image
2. Movie Name
3. Movie Genres
4. Movie Popularity


* For displaying Images [`Glide`](https://github.com/bumptech/glide) has been used. It is an external library to display the images using url.

* Glide is a fast and efficient open source media management and image loading framework for Android that wraps media decoding, memory and disk caching, and resource pooling into a simple and easy to use interface. Glide supports fetching, decoding, and displaying video stills, images, and animated GIFs. Glide includes a flexible API that allows developers to plug in to almost any network stack. By default Glide uses a custom HttpUrlConnection based stack, but also includes utility libraries plug in to Google's Volley project or Square's OkHttp library instead. Glide's primary focus is on making scrolling any kind of a list of images as smooth and fast as possible, but Glide is also effective for almost any case where you need to fetch, resize, and display a remote image. [Content Courtesy: Glide](https://github.com/bumptech/glide).

* For handling the JSON data and to perform REST operations this application uses the [`Retrofit`](http://square.github.io/retrofit/). This is an API which makes HTTP API into a Java interface.

* This application uses the [The Moviedb API](https://www.themoviedb.org) to get the details from the database. This application consumes this API and displays the result to the user.

Developed By:
Varun
