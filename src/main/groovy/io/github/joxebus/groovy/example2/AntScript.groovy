#!/usr/bin/env groovy
package io.github.joxebus.groovy.example2

version = '2.2.0'
release = '2.11-2.2.0'
url = "http://apache.claz.org/kafka/${version}/kafka_${release}.tgz"
tempDir = "/Users/obautista/Downloads"
destDir = "/Users/obautista/Documents/workspace-public/GroovyWorkshopExamples/src/main/resources/download"

def ant = new AntBuilder()

println "Downloading sources"
ant.get(src: url, dest: tempDir)

println "Decompressing file"
ant.untar(
        src: "$tempDir/kafka_${release}.tgz",
        dest: destDir,
        compression:"gzip", overwrite:true
)
