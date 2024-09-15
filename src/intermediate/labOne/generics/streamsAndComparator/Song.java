package intermediate.labOne.generics.streamsAndComparator;

import java.util.Comparator;

public class Song implements Comparable<Song> {
    String title;
    String artist;
    String rating;
    String bpm;

    public Song(String bpm, String rating, String artist, String title) {
        this.bpm = bpm;
        this.rating = rating;
        this.artist = artist;
        this.title = title;
    }

    public String getBpm() {
        return bpm;
    }

    public String getRating() {
        return rating;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public int compareTo(Song o) {
        return this.title.compareTo(o.title);
    }

    public static class ArtistCompare<T> implements Comparator<T> {

        @Override
        public int compare(T o1, T o2) {
            return 0;
        }
    }
}
