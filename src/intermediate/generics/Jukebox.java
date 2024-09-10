package intermediate.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.lang.System.out;


public class Jukebox<T extends Comparable<T>> {
    ArrayList<T> songList = new ArrayList<>();

    public static void main(String...args){
        var stringJukebox = new Jukebox<String>();
        stringJukebox.addSong("Just give me a reason");
        stringJukebox.getSongs();

        var songBox = new Jukebox<Song>();
        songBox.addSong(new Song("Someone Like you", "Adele", "4.9/5", "Romance"));
        songBox.getSongs();
    }

    private void go() {
       getSongs();
        out.println(songList);
        Collections.sort(songList);
        out.println(songList);
        var artistCompare = new Song.ArtistCompare<>();
    }

    private void getSongs() {
        var iterator = songList.iterator();
        while(iterator.hasNext()){
            var song = iterator.next();
            out.println(song);
        }
    }

    public void addSong(T line) {
       songList.add(line);
    }
}
