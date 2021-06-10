package com.sun.gamevui.data.remote

object ApiConfig {

    /**
     *get Genres
     *https://api.rawg.io/api/genres?key=
     *get Popular Games For Platform
     *https://api.rawg.io/api/games?parent_platforms=&key=
     *get Game By Genre For Platform
     *https://api.rawg.io/api/games?genres=&parent_platforms=&key=
     *get Game By Name
     *https://api.rawg.io/api/games?search=&key=
     *get Game Detail
     *https://api.rawg.io/api/games/id?key=
     *get Screenshots
     *https://api.rawg.io/api/games/id/screenshots?key=
     */

    const val BASE_URL = "https://api.rawg.io/api/"
    const val BASE_KEY = "key"
    const val BASE_GAME = "games"
    const val BASE_PC = "1"
    const val BASE_PS = "2"
    const val BASE_XBOX = "3"
    const val BASE_PARENT_PLATFORM = "parent_platforms"
    const val BASE_GENRE = "genres"
    const val BASE_SEARCH = "search"
    const val BASE_PUBLISHERS = "publishers"
    const val BASE_DEVELOPER = "developers"
    const val BASE_RSS = "https://gamek.vn/"
    const val BASE_ENDPOINT_RSS = "thi-truong.rss"
}
