/* Structural pattern Facade
is a structural design pattern that provides a simplified interface to a library,
a framework, or any other complex set of classes.
 */

class VideoDecoder {
    fun decode(filePath: String): String {
        println("Decoding video from: $filePath")
        return "RawVideoData"
    }
}

class VideoFormatConverter {
    fun convert(videoData: String, format: String): String{
        println("Converting video: $videoData to format: $format")
        return "convertedVideo.$format"
    }
}

class VideoSaver {
    fun save(videoData: String, outPath: String) {
        println("Saving the converted video $videoData to: $outPath")
    }
}

class VideoConverterFacade {
    private val decoder = VideoDecoder()
    private val formatConverter = VideoFormatConverter()
    private val saver = VideoSaver()

    fun convertVideo (filePath: String, outPath: String, format: String) {
        println("Starting the convertion process...")
        val rawVideoData = decoder.decode(filePath)
        val convertedVideoData = formatConverter.convert(rawVideoData, format)
        saver.save(convertedVideoData, outPath)
        println("Conversion proccess completed successfully.")
    }
}


/* Example of use
fun main() {
    val videoConverter = VideoConverterFacade()
    videoConverter.convertVideo("users/videos","desktop/videos","mp4")
}
 */