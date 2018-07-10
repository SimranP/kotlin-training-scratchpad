import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class HelloWorldUnitTest : FunSpec() {

    init {
        test("should return hello world"){
            val helloWorld = helloWorld()
            helloWorld shouldBe "Hello World"
        }
    }
}

class readFileUnitTest : FunSpec() {
    init {
        test("should return content of given file path"){
            val content = readFile("src/test/resources/test.txt")
            content shouldBe "I am a test content"
        }
    }
}

class wordCountUnitTest : FunSpec() {
    init {
        test("should return content of given file path"){
            val count = countWords("a b c")
            count shouldBe 3
        }
    }
}

class giveOccurenceForEachWordUnitTest : FunSpec() {
    init {
        test("should return content of given file path"){
            var expected = HashMap<String, Int>()
            expected.put("a", 2)
            expected.put("b", 1)
            expected.put("c", 1)
            val wordsMap = giveOccurenceForEachWord("a a b c")
            wordsMap shouldBe expected
        }
    }
}