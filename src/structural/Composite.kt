package structural/* Structural pattern Composite */

interface MovieComponent {
    fun play(): String
    fun stop(): String
}

class Movie(private val name: String) : MovieComponent {
    override fun play(): String {
        return "Playing movie: $name\n"
    }

    override fun stop(): String {
        return "Stopping movie: $name\n"
    }
}

class Playlist(private val name: String) : MovieComponent {
    private val movieComponents = mutableListOf<MovieComponent>()

    fun add(movieComponent: MovieComponent) {
        movieComponents.add(movieComponent)
    }

    override fun play(): String {
        val result = StringBuilder()
        result.append("Playing playlist: $name\n")
        for (movieComponent in movieComponents) {
            result.append(movieComponent.play())
        }
        return result.toString()
    }

    override fun stop(): String {
        val result = StringBuilder()
        result.append("Stopping playlist: $name\n")
        for (movieComponent in movieComponents) {
            result.append(movieComponent.stop())
        }
        return result.toString()
    }
}


/* Example of use */

/*
val actionMoviesPlayList = structural.Playlist("Action Movies")
    actionMoviesPlayList.add(structural.Movie("The Matrix"))
    actionMoviesPlayList.add(structural.Movie("Die Hard"))

    val comicMoviesPlayList = structural.Playlist("Comic Movies")
    comicMoviesPlayList.add(structural.Movie("The Hangover"))
    comicMoviesPlayList.add(structural.Movie("Bridesmaids"))

    val allPlaylists = structural.Playlist("All Playlists")
    allPlaylists.add(actionMoviesPlayList)
    allPlaylists.add(comicMoviesPlayList)

    val playResult = allPlaylists.play().also(::println)

    val stopResult = allPlaylists.stop().also(::println)
 */