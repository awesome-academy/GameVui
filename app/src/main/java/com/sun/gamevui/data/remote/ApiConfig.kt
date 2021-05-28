package com.sun.gamevui.data.remote

object ApiConfig {
    //getGenres: https://api.rawg.io/api/genres?key=
    //getPopularGamesForPlatform: https://api.rawg.io/api/games?parent_platforms=&key=
    //getGameByGenreForPlatform: https://api.rawg.io/api/games?genres=&parent_platforms=&key=
    const val BASE_URL = "https://api.rawg.io/api/"
    const val BASE_KEY = "key"
    const val BASE_GAME = "games"
    const val BASE_PC = "1"
    const val BASE_PS = "2"
    const val BASE_XBOX = "3"
    const val BASE_PARENT_PLATFORM = "parent_platforms"
    const val BASE_GENRE = "genres"
}
