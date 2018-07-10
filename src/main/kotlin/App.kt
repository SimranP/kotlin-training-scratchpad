fun main(args: Array<String>) {
    val fileName = "src/main/resources/word-count.txt"
    println(countWordsFromFile(fileName))
    println(giveOccurenceForEachWord(readFile(fileName)))
}