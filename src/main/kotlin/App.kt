import java.time.Duration

fun main(args: Array<String>) {
    val fileName = "src/main/resources/word-count.txt"
    println(countWordsFromFile(fileName))
    println(giveOccurenceForEachWord(readFile(fileName)))
    println("Movies for Actor Akshay Kumar: " + MoviesStore().getMoviesForActor("Akshay Kumar"))
    println("Movies Relased in 2018: "+ MoviesStore().getMoviesReleasedInYear(2018))
    println("Movies for Actress Juhi:" + MoviesStore().getMoviesForActress("Juhi"))
    println("Movies of duration greate than 100 mins: "+MoviesStore().getMovieswithDurationGreater(100))


    val movie = Movie.create(Date(2018), actor = "ishu", actress = "ishu", duration = Duration.ofMinutes(180))

    val(_, actor) = movie
    println(actor)
    val moviesStore: MoviesStore.Companion = MoviesStore
        moviesStore.create(movie)
    println(moviesStore)
}