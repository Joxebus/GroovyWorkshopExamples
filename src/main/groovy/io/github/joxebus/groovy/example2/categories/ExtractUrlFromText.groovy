package io.github.joxebus.groovy.example2.categories

class ExtractUrlFromText {

    private static String regex = 'http://[-A-Za-z0-9./_-]*[-A-Za-z0-9._-]'

    static List getUrlsFromText(String text){
        (text =~ regex).collect()
    }
}
