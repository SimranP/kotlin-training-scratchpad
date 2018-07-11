import java.time.Duration

data class Film(val imdbId: Int,
             val releaseDate: Date,
             val actors: List<String>,
             val actresses: List<String>,
             val genres: List<Genre>,
             val title: String,
             val director: String,
             val duration: Duration)


class Movie(
             val releaseDate: Date,
             val actors: List<String>,
             val actresses: List<String>,
             val genres: List<Genre>,
             val duration: Duration) {
    companion object {
        fun create(releaseDate: Date, actor: String, actress: String , duration: Duration, genre: Genre = Genre.DRAMA):
                Movie = Movie(
                releaseDate = releaseDate,
                actors = listOf(actor),
                actresses = listOf(actress),
                genres = listOf(genre),
                duration = duration)
    }

    operator fun component1() =
        releaseDate

    operator fun component2() =
        actors

    operator fun component3() =
        actresses

    operator fun component4() =
        genres

    operator fun component5() =
        duration
}

class MoviesStore(val movies: List<Movie> = mutableListOf()){
    companion object {
        fun create(movie: Movie) : MoviesStore = MoviesStore(listOf(movie))
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

    operator fun component1() =
            movies[0]

    operator fun component2() =
            movies[1]

    operator fun component3() =
            movies[2]

    operator fun component4() =
            movies[3]

    operator fun component5() =
            movies[4]
}


class Date(val year: Int)