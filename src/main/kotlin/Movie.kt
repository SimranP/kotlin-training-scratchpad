import java.time.Duration

//data class Film(val imdbId: Int,
//             val releaseDate: Date,
//             val actors: List<String>,
//             val actresses: List<String>,
//             val genres: List<Genre>,
//             val title: String,
//             val director: String,
//             val duration: Duration)


data class Movie(
             val name: String = "Gumnaam",
             val releaseDate: Date,
             val actors: List<String>,
             val actresses: List<String> = listOf(),
             val genres: List<Genre> = listOf(Genre.DRAMA),
             val duration: Duration = Duration.ofMinutes(100)) {
    companion object {
        fun create(releaseDate: Date, actor: String, actress: String , duration: Duration, genre: Genre = Genre.DRAMA):
                Movie = Movie(
                releaseDate = releaseDate,
                actors = listOf(actor),
                actresses = listOf(actress),
                genres = listOf(genre),
                duration = duration)
    }
    operator fun compareTo(movie: Movie): Int = if(this.duration.toMinutes() > movie.duration.toMinutes()) 1 else -1
}

class MoviesStore(val movies: MutableList<Movie> = mutableListOf()){
    companion object {
        fun create(movie: Movie) : MoviesStore = MoviesStore(mutableListOf(movie))
    }

    fun getMoviesReleasedInYear(year: Int): List<Movie> {
        return movies.filter { it.releaseDate.year == year }
    }

    fun getMovieswithDurationGreater(durationInMins: Long): List<Movie> {
        return movies.filter { it.duration > Duration.ofMinutes(durationInMins) }
    }

    fun getMoviesForActor(actor: String): List<Movie> {
        return movies.filter { it.actors.contains(actor) }
    }

    fun getMoviesForActress(actor: String): List<Movie> {

        return movies.filter { it.actresses.contains(actor) }
    }

    inline fun getStoreWithMovies(predicate: (Movie) -> Boolean): MoviesStore{
        val movies = mutableListOf<Movie>()
        this.movies.asSequence().forEach { predicate(it) && movies.add(it) }
        return MoviesStore(movies)
    }

    operator fun contains(movie: Movie): Boolean =
        movies.contains(movie)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MoviesStore

        if (movies != other.movies) return false

        return true
    }

    override fun hashCode(): Int {
        return movies.hashCode()
    }


}


data class Date(val year: Int)