package ge.doublenote.songs;

import ge.core.managers.SceneManager;
import ge.doublenote.logic.NoteFactory;
import ge.doublenote.logic.commands.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Hotmk extends Song {

    ArrayList<String> colors = new ArrayList<>();
    ArrayList<Integer> times = new ArrayList<>();
    int noteCount;
    int beat = 500;
    int buffer = 1500;

    public Hotmk(SceneManager sm, String filePath, String name, NoteFactory nf) throws IOException {
        super(sm,filePath,name,nf);
        LoadNotes();
    }

    @Override
    public void LoadNotes() throws IOException {
        try {

            InputStream in = this.getClass().getResourceAsStream("/resources/notes/hotmk.json");
            JSONTokener t = new JSONTokener(in);
            JSONObject obj = new JSONObject(t);
            JSONArray notes = obj.getJSONArray("notes");

            int time;

            for (int i = notes.length() - 1; i > -1; i--) {
                String color = notes.getJSONObject(i).getString("color");
                String type = notes.getJSONObject(i).getString("type");

                time = 0;

                if(type.equals("Quarter")) {
                    System.out.println("Hit this");
                    time = beat;
                } else if (type.equals("Half")) {
                    time = beat * 2;
                } else if (type.equals("Whole")) {
                    time = beat * 4;
                } else if (type.equals("Eighth")) {
                    time = beat / 2;
                } else if (type.equals("Sixteenth")) {
                    time = beat / 4;
                } else if (type.equals("Quarter + Eighth")) {
                    time = beat + (beat / 2);
                } else if (type.equals("Chord")) {
                    time = 1;
                } else if (type.equals("32")) {
                    time = beat / 8;
                }

                colors.add(color);
                times.add(time);

            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        String color;
        int time;

        for(int i = 0; i < colors.size(); i++) {
            color = colors.get(i);
            time = times.get(i);
            System.out.println("Colors: [" + i + "] " + color + ": " + time);
            switch (color) {
                case "Red" -> {
                    NoteCommand rc = new RedNoteCommand(nf);
                    noteQueue.add(rc);
                }
                case "Orange" -> {
                    NoteCommand oc = new OrangeNoteCommand(nf);
                    noteQueue.add(oc);
                }
                case "Yellow" -> {
                    NoteCommand yc = new YellowNoteCommand(nf);
                    noteQueue.add(yc);
                }
                case "White" -> {
                    NoteCommand wc = new WhiteNoteCommand(nf);
                    noteQueue.add(wc);
                }
                case "Purple" -> {
                    NoteCommand pc = new PurpleNoteCommand(nf);
                    noteQueue.add(pc);
                }
                case "Blue" -> {
                    NoteCommand bc = new BlueNoteCommand(nf);
                    noteQueue.add(bc);
                }
                case "LBlue" -> {
                    NoteCommand lc = new LBlueNoteCommand(nf);
                    noteQueue.add(lc);
                }
                case "Green" -> {
                    NoteCommand gc = new GreenNoteCommand(nf);
                    noteQueue.add(gc);
                }
            }

        }

        noteCount = noteQueue.size() - 1;
        System.out.println(noteCount);
        System.out.println(times.get(noteCount));
    }

    @Override
    public void SpawnNotes() {

        try {

            TimeUnit.MILLISECONDS.sleep(buffer);

            while(running) {

                if(noteQueue.size() != 0) {
                    NoteCommand n = noteQueue.pop();
                    n.execute();
                    TimeUnit.MILLISECONDS.sleep(times.get(noteCount));
                    System.out.println("Current Time Buffer: " + times.get(noteCount));
                    System.out.println(noteCount);
                    noteCount--;
                } else {
                    songEnded = true;
                }

                if(sm.getKeyManager().t()) {
                    running = false;
                    LoadNotes();
                }
            }
        }

        catch(InterruptedException | IOException ex)

        {
            Thread.currentThread().interrupt();
        }
    }
}
