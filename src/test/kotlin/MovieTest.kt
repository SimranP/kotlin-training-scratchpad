import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec
import java.time.Duration

class MoviesStoreTest: FunSpec(){
    val movie1 = Movie(releaseDate = Date(2018),
            actors = listOf("Akshay Kumar"),
            actresses = listOf("Katrina"),
            duration = Duration.ofMinutes(90),
            genres = listOf(Genre.COMEDY)

    )
    val movie2 = Movie(releaseDate = Date(2010),
            actors = listOf("Akshay Kumar"),
            actresses = listOf("Katrina"),
            duration = Duration.ofMinutes(320),
            genres = listOf(Genre.COMEDY)

    )
    val movie3 = Movie(releaseDate = Date(2013),
            actors = listOf("Akshay Kumar"),
            actresses = listOf("Katrina"),
            duration = Duration.ofMinutes(120),
            genres = listOf(Genre.WESTERN)

    )
    val movie4 = Movie(releaseDate = Date(2018),
            actors = listOf("Akshay Kumar"),
            actresses = listOf("Katrina"),
            duration = Duration.ofMinutes(180),
            genres = listOf(Genre.HORROR)

    )
    val movie5 = Movie(releaseDate = Date(2010),
            actors = listOf("A Kumar"),
            actresses = listOf("Juhi"),
            duration = Duration.ofMinutes(100),
            genres = listOf(Genre.DOCUMENTARY)

    )
    val movies  = listOf(
            movie1,
            movie2,
            movie3,
            movie4,
            movie5)

    init {
        test("should give expected list of movies"){
            val store = MoviesStore(movies)
            store.getMoviesForActor("Akshay Kumar") shouldBe listOf(movie1, movie2, movie3, movie4)
        }

        test("should give expected list of movies with actress"){
            val store = MoviesStore(movies)
            store.getMoviesForActress("Juhi") shouldBe listOf(movie5)
        }

        test("should give expected list of movies with given year"){
            val store = MoviesStore(movies)
            store.getMoviesReleasedInYear(2018) shouldBe listOf(movie1, movie4)
        }

        test("should give expected list of movies with given duration"){
            val store = MoviesStore(movies)
            store.getMovieswithDurationGreater(180) shouldBe listOf(movie2)
        }

        test("should give expected list of movies with given duration using lambda"){
            val store = MoviesStore(movies)
            val moviesStore = store.getStoreWithMovies { it.duration > Duration.ofMinutes(180) }
            moviesStore shouldBe MoviesStore(listOf(movie2))
        }

        test("should give expected list of movies with given year using lambda"){
            val store = MoviesStore(movies)
            val moviesStore = store.getStoreWithMovies { it.releaseDate == Date(2018) }
            moviesStore shouldBe MoviesStore(listOf(movie1, movie4))
        }
    }
}