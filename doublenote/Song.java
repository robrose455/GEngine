package ge.doublenote;

public class Song {

    String filePath;
    String name;
    NoteFactory nf;

    public Song(String filePath, String name, NoteFactory nf) {

        //Will Store Sprite Track at Later Point
        this.filePath = filePath;
        this.name = name;
        this.nf = nf;

    }

    public String getFilePath() {
        return filePath;
    }

    public String getName() {
        return name;
    }

    public NoteFactory getNoteFactory() {
        return nf;
    }

    public void SpawnNotes() {

    }
}
