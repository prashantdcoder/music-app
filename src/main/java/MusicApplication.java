import core.FileMapper;
import core.FileReader;
import core.Song;
import dto.SongDTO;
import enums.FolderType;
import exception.InvalidPathException;

import java.util.List;

public class MusicApplication {

    private static final String BASE_PATH = "<FOLDER_PATH>";

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader(BASE_PATH + "<FOLDER_NAME>");
            fileReader.read();
            FileMapper fileMapper = new FileMapper(fileReader.getFiles());
            fileMapper.mapAsDTO();

            List<SongDTO> songDTOList = fileMapper.getSongDTOList();
            Song song = new Song(BASE_PATH);

            for (SongDTO songDTO : songDTOList) {
                if (song.renameTo(songDTO, FolderType.ALBUM)) {
                    System.out.println(songDTO.getTitleWithExtension() + " renamed and moved");
                } else {
                    System.out.println(songDTO.getTitleWithExtension() + " cant be renamed");
                }
            }

        } catch (InvalidPathException e) {
            System.out.println(e.getMessage());
        }

    }

}
