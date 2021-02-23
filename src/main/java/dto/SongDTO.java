package dto;

import com.mpatric.mp3agic.ID3v2;

import java.io.File;

public class SongDTO {

    private final File originalFile;
    private String title;
    private String artist;
    private String album;
    private static final String extension = ".mp3";

    public SongDTO(File originalFile, ID3v2 songTag) {
        this.title = songTag.getTitle();
        this.album = songTag.getAlbum();
        this.artist = songTag.getArtist();

        this.originalFile = originalFile;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public File getOriginalFile() {
        return originalFile;
    }

    public String getTitleWithExtension() {
        return title.concat(extension);
    }
}
