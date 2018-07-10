import java.io.File

fun helloWorld() = "Hello World"

fun readFile(fileName: String): String{
    return File(fileName).readText(Charsets.UTF_8)
}
fun countWords(text: String): Int{
    return getWords(text).size
}

fun getWords(text: String) = text.split("\n")
        .flatMap { it.split(" ") }
        .filter { it.isNotBlank() }

fun countWordsFromFile(path: String): Int {
    return countWords(readFile(path))
}

fun giveOccurenceForEachWord(text: String): Map<String, Int> {
//    var wordsMap = HashMap<String, Int>()
//    for(word in getWords(text)) {
//        wordsMap[word]?.let {
//            wordsMap[word] = it + 1
//        }
//        if (wordsMap[word] == null)
//            wordsMap[word] = 1
//    }
//
//    return wordsMap
    return getWords(text).groupingBy { it }.eachCount()
}