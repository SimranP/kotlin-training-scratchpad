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
    var releaseDate = Date(0.toString())
    var actors = listOf<String>()
}