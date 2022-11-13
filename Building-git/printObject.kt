import java.io.File
import java.io.InputStream
import java.security.MessageDigest
import java.nio.file.Files
import java.nio.file.StandardCopyOption

fun readFileLineByLineUsingForEachLine(fileName: String) 
  = File(fileName).forEachLine { println(it) }

fun main(args: Array<String>) {
    
    val directory =  File("/Users/asus/Desktop/Sahaj/Assignment2/.mgit/objects")

    var flist = directory.list()
    var flag = 0
    var filename ="" 
    if (flist == null) {
        System.out.println("Empty directory.")
    }
    else {

        // Linear search in the array
        for (it in flist) {
           val tmp = it
            if (tmp==args[0]) {
                filename=it
                println(filename + " found")
                flag = 1
            }
        }
    }

    if (flag == 0) {
        println("File Not Found")
    }

    if(flag == 1)
    {
        readFileLineByLineUsingForEachLine(filename)
    }


}
