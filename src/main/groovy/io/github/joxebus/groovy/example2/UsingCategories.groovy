package io.github.joxebus.groovy.example2


import io.github.joxebus.groovy.example2.categories.ExtractUrlFromText
import io.github.joxebus.groovy.example2.categories.FileReaderCategory

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
