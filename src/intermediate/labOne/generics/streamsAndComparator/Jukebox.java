package intermediate.labOne.generics.streamsAndComparator;

import java.util.ArrayList;

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

    // use stream api and comparator for filtering and sorting
    private void getSongs() {
        songList.stream()
                .filter(song -> song instanceof Song)
                .sorted(new Song.ArtistCompare<>())
                .forEach(out::println);
    }

    public void addSong(T line) {
       songList.add(line);
    }
}
