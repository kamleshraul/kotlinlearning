package com.codekam.enums

enum class DownloadState{
    Idel,
    Starting,
    InProgress,
    Error,
    Success;
}

fun completion(error:String?,list:List<String>?){
    error?.let { println("Got error : $error ")}
    list?.let {println("Got list with ${list.size} item")}
}

fun progress(state:DownloadState) = when(state){
    DownloadState.Idel ->  println("Download has not yet started")
    DownloadState.Starting -> println("Download starting....")
    DownloadState.InProgress -> println("Download is in progress.")
    DownloadState.Error -> println("Error in Donwloading !!!!.")
    DownloadState.Success -> println("!!!Finished downloading successfully!!!!.")
}

class Downloader{
    fun downloadData(url:String
                     ,progress:(DownloadState)->Unit
                     ,completion:(String,List<String>)->Unit):Unit{
        progress(DownloadState.Idel)
        completion("error",null)
    }
}

fun main() {
    val progressFunction= ::progress
    val completionFunction= :: completion
    Downloader().downloadData("foo.java",progressFunction,completionFunction)
}