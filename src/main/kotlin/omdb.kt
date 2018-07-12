import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking
import org.json.JSONObject

fun getOMDBdata(imdbIDs: MutableList<String>): List<Movie> {
    return imdbIDs.map {   Movie.create(getOMDBValue(it)) }
}

fun getOMDBDataAsync(imdbIDs: MutableList<String>): List<Movie> {
    val deferred = imdbIDs.map { imdbID ->
        async {
            getOMDBValue(imdbID)
        }
    }

    val movies = runBlocking { deferred.map { Movie.create(it.await()) } }
    return movies
}

fun getOMDBValue(imdbID: String): JSONObject {
    return khttp.get("http://www.omdbapi.com/?i=${imdbID}&apikey=9d3fc311").jsonObject
}