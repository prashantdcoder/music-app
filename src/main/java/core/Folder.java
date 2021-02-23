package core;

import exception.InvalidPathException;
import operation.Creatable;

import java.io.File;

public class Folder implements Creatable {

    private String destinationPath;
    private String name;
    private boolean isCreated;
    private boolean isExist;
    private File folder;

    public Folder() {

    }

    public Folder(String name) {
        this.name = name;
    }

    public String getDestinationPath() {
        return destinationPath;
    }

    public void setDestinationPath(String destinationPath) {
        this.destinationPath = destinationPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCreated() {
        return isCreated;
    }

    public void setIsExist() {
        this.isExist = true;
    }

    public boolean isExist() {
        return isExist;
    }

    @Override
    public void create() {
        File folder = new File(destinationPath.concat(name));
        try {
            if (folder.exists()) {
                this.isExist = true;
                this.folder = folder;
            } else {
                this.isCreated = folder.mkdir();
                if (this.isCreated) {
                    this.folder = folder;
                    System.out.printf("Folder %s is created at location - %s", this.name, this.destinationPath);
                } else {
                    this.folder = null;
                    throw new InvalidPathException("Sorry! We are not able to create folder. Please provide correct path");
                }
            }
        } catch (InvalidPathException e) {
            System.out.println(e.getMessage());
        }
    }

    public File get() {
        return this.folder;
    }

    public String getPath() {
        return this.destinationPath + this.getName();
    }

}
