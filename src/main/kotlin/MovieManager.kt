import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val imdbIDs = readCSV("src/main/resources/movies-data.csv")
    val measureTimeMillis = measureTimeMillis {  getOMDBdata(imdbIDs = imdbIDs)  }
    println("Sync time  - ${measureTimeMillis}")
    val startTime  = System.currentTimeMillis()
    val movies: List<Movie> = getOMDBDataAsync(imdbIDs = imdbIDs)
    val time2 = System.currentTimeMillis() - startTime
    println("Async time  - ${time2}")
    println(movies)

}