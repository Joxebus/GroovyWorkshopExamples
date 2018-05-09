#!/usr/bin/env groovy

if(!args){
    throw new RuntimeException("This script requires the 'URL' and 'location to save'")
}

File file = new File(args[0])
String url = args[1]

class FileBinaryDownload {

    // Overload operator <<
    def static leftShift(File file, URL url){
        url.withInputStream {is->
            file.withOutputStream {os->
                def bs = new BufferedOutputStream( os )
                bs << is
            }
            println "finish to write the file $file"
        }
    }

}


use(FileBinaryDownload){
    println "Trying to download $url"
    file << url.toURL()
}
