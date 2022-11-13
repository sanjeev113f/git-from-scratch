import java.io.File
import java.io.InputStream
import java.security.MessageDigest
import java.nio.file.Files
import java.nio.file.StandardCopyOption



fun String.toSHA1(): String {
    val bytes = MessageDigest.getInstance("SHA-1").digest(this.toByteArray())
    return bytes.toHex()    
}

fun ByteArray.toHex(): String {
    return joinToString("") { "%02x".format(it) }   
}

fun readFileAsTextUsingInputStream(fileName: String)
  = File(fileName).inputStream().readBytes().toString(Charsets.UTF_8)


fun copyFile(src: File, dest: File) {
    Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING)
}

fun main(args: Array<String>) {
    
    val directory =  File("/Users/asus/Desktop/Sahaj/Assignment2")

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
                filename=tmp
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
        var filedata=readFileAsTextUsingInputStream(filename)
        var hashdata=filedata.toSHA1()
        File(".mgit/objects/$hashdata").mkdir()
        var src=File("/Users/asus/Desktop/Sahaj/Assignment2/$filename")
        var des=File(".mgit/objects/$hashdata")
        copyFile(src,des)

    }


}
