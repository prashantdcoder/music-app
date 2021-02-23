package core;

import dto.SongDTO;
import enums.FolderType;

import java.io.File;
import java.util.Optional;

public class Song {

    private String basePath;

    public Song(String basePath) {
        this.basePath = basePath;
    }

    public boolean renameTo(SongDTO songDTO, FolderType folderType) {
        try {
            Optional<File> newFolder = generateFolder(folderType == FolderType.ARTIST ? songDTO.getArtist() : songDTO.getAlbum());
            if (newFolder.isPresent()) {
                File newFile = new File(newFolder.get().getPath() + "/" + songDTO.getTitleWithExtension());
                return songDTO.getOriginalFile().renameTo(newFile);
            }
            return false;
        } catch (NullPointerException exception) {
            return false;
        }
    }

    private Optional<File> generateFolder(String name) {
        Folder folder = new Folder();
        folder.setDestinationPath(basePath);
        folder.setName(name);
        folder.create();
        return Optional.of(folder.get());
    }
}
