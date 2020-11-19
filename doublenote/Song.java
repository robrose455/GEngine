package ge.doublenote;

public class Song {

    String filePath;
    String name;

    public Song(String filePath, String name) {

        //Will Store Sprite Track at Later Point
        this.filePath = filePath;
        this.name = name;

    }

    public String getFilePath() {
        return filePath;
    }

    public String getName() {
        return name;
    }
}
