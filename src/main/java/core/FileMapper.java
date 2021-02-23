package core;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import dto.SongDTO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileMapper {

    private List<File> files;
    private List<SongDTO> songDTOList;


    public FileMapper(List<File> files) {
        this.files = files;
        this.songDTOList = new ArrayList<>();
    }

    public void mapAsDTO() {
        try {
            for (File file : files) {
                Mp3File songFile = new Mp3File(file.getPath());
                if (songFile.hasId3v2Tag()) {
                    ID3v2 songTag = songFile.getId3v2Tag();
                    songDTOList.add(new SongDTO(file, songTag));
                }
            }
        } catch (IOException | UnsupportedTagException | InvalidDataException exception) {
            System.out.println("Exceptions: " + exception.getMessage());
        }
    }

    public List<SongDTO> getSongDTOList() {
        return this.songDTOList;
    }
}
