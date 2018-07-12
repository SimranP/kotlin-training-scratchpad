import java.io.BufferedReader
import java.io.FileReader

fun readCSV(fileName: String): MutableList<String> {
    val imdbIds = mutableListOf<String>()
    val fileReader = BufferedReader(FileReader(fileName))
    val header = fileReader.readLine()
    val index = header.split(",").indexOf("imdbID")
    var line = fileReader.readLine()
    try {
        while (line != null) {
            val tokens = line.split(",")
            if (tokens.isNotEmpty()) {
                imdbIds.add(tokens[index])
            }
            line = fileReader.readLine()
        }
    }catch (e: Exception){
        fileReader.close()
    }

    return imdbIds
}