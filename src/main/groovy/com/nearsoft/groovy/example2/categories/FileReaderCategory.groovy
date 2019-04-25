package com.nearsoft.groovy.example2.categories

class FileReaderCategory {

    static String getContent(String filename, String src){
        new File("${src?:'src/main/resources/'}$filename").text
    }
}
