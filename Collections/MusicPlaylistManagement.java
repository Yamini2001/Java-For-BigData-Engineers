
package Collections;

import java.util.LinkedList;
import java.util.ListIterator;

class Song {
    int songId;
    String songTitle;
    String artistName;

    public Song(int songId, String songTitle, String artistName) {
        this.songId = songId;
        this.songTitle = songTitle;
        this.artistName = artistName;
    }

    public void displaySong() {
        System.out.println("Song ID: " + songId);
        System.out.println("Song Title: " + songTitle);
        System.out.println("Artist Name: " + artistName);
        System.out.println("--------------------------");
    }
}

public class MusicPlaylistManagement {

    public static void main(String[] args) {

        LinkedList<Song> playlist = new LinkedList<>();

        // 1. Add songs at the beginning and end
        playlist.addFirst(new Song(101, "Kesariya", "Arijit Singh"));
        playlist.addLast(new Song(102, "Tum Hi Ho", "Arijit Singh"));
        playlist.addLast(new Song(103, "Perfect", "Ed Sheeran"));
        playlist.addFirst(new Song(104, "Shape of You", "Ed Sheeran"));

        // 2. Display all songs
        System.out.println("ALL SONGS IN PLAYLIST:");

        for (Song song : playlist) {
            song.displaySong();
        }

        // 3. Remove a song using its song ID
        int searchId = 102;
        boolean found = false;

        for (int i = 0; i < playlist.size(); i++) {
            if (playlist.get(i).songId == searchId) {
                playlist.remove(i);
                found = true;
                System.out.println("Song removed successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Song not found.");
        }

        // 4. Display the first and last songs
        System.out.println("\nFIRST AND LAST SONGS:");

        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else {
            System.out.println("First song:");
            playlist.getFirst().displaySong();

            System.out.println("Last song:");
            playlist.getLast().displaySong();
        }

        // 5. Navigate to the next and previous songs
        System.out.println("PLAYLIST NAVIGATION:");

        ListIterator<Song> iterator = playlist.listIterator();

        if (iterator.hasNext()) {
            System.out.println("Next song:");
            iterator.next().displaySong();
        }

        if (iterator.hasNext()) {
            System.out.println("Next song:");
            iterator.next().displaySong();
        }

        if (iterator.hasPrevious()) {
            System.out.println("Previous song:");
            iterator.previous().displaySong();
        }

        // 6. Display the updated playlist
        System.out.println("UPDATED PLAYLIST:");

        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else {
            for (Song song : playlist) {
                song.displaySong();
            }
        }

        System.out.println("Total songs: " + playlist.size());
    }
}
