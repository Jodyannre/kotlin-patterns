/* Structural pattern - Adapter */
/* Allows objects with incompatible interfaces to collaborate*/


interface AdvancedMediaPlayer{
    fun playVlc(fileName: String)
    fun playMp4(fileName: String)
}

class VlcPlayer : AdvancedMediaPlayer{
    override fun playVlc(fileName: String) {
        println("Playing $fileName")
    }

    override fun playMp4(fileName: String) {
        println("Format not supported")
    }
}

class Mp4Player : AdvancedMediaPlayer{
    override fun playVlc(fileName: String) {
        println("Format not supported")
    }

    override fun playMp4(fileName: String) {
        println("Playing $fileName")
    }
}

interface MediaPlayer{
    fun play(audioType: String, fileName: String)
}

class MediaAdapter(audioType: String) : MediaPlayer{
    var advancedMediaPlayer: AdvancedMediaPlayer? = null

    init {
        if (audioType == "vlc") this.advancedMediaPlayer = VlcPlayer()
        else if (audioType == "mp4") this.advancedMediaPlayer = Mp4Player()
    }
    override fun play(audioType: String, fileName: String) {
        if (audioType=="vlc") advancedMediaPlayer?.playVlc("$fileName.$audioType")
        else if (audioType=="mp4") advancedMediaPlayer?.playMp4("$fileName.$audioType")
    }
}

/* Original

class AudioPlayer : MediaPlayer{
    override fun play(audioType: String, fileName: String) {
        if (audioType == "mp3") println("Playing $fileName")
        else println("Format not supported")
    }
}

*/

class AudioPlayer: MediaPlayer{
    private var mediaAdapter: MediaAdapter? = null

    override fun play(audioType: String, fileName: String) {
        if (audioType == "mp3") println("Playing $fileName.$audioType")
        else if (audioType == "mp4" || audioType == "vlc") {
            mediaAdapter = MediaAdapter(audioType)
            mediaAdapter?.play(audioType, fileName)
        }
        else println("Format not supported")
    }
}


/* Example of use
    val reproductor = AudioPlayer()
    reproductor.play("mp4","It's my life")

 */