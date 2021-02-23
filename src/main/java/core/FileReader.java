package core;

import exception.InvalidPathException;
import operation.Reader;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FileReader implements Reader {

    private String source;
    private List<File> files;

    public FileReader(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public void read() throws InvalidPathException {
        File directory = new File(source);
        if (!directory.exists()) {
            throw new InvalidPathException("No such directory exists");
        }
        this.files = Arrays.asList(Objects.requireNonNull(directory.listFiles()));
    }

    public List<File> getFiles() {
        return this.files;
    }

}
