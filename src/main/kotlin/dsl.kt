
val store = movieStore {
    movie {
        name = "Welcome"
        releaseDate = Date(2018)
        actors = listOf("Alia")
    }
}


fun movieStore (predicate: MovieStore.()->MovieStore): MovieStore {
    return MovieStore().predicate()
}

class MovieStore {
    private val movies = mutableListOf<Film>()

    fun movie(predicate: Film.() -> Unit): MovieStore {
        val movie = Film()
        movie.predicate()
        movies.add(movie)
        return this
    }
}

class Film {
    var name = ""
    var releaseDate = Date(0)
    var actors = listOf<String>()
}