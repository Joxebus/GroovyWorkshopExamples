import com.nearsoft.groovy.example2.categories.*

class UsingCategories {

    static void main(String[] args) {
        String text
        use(FileReaderCategory) {
            text = "TextWithURLS.txt".getContent()
            println text
        }

        use(ExtractUrlFromText) {
            println "URLs found:"
            text.getUrlsFromText().each { url ->
                println url
            }
        }
    }
}
