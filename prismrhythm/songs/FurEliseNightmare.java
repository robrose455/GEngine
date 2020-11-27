package ge.prismrhythm.songs;

import ge.core.managers.SceneManager;
import ge.prismrhythm.logic.NoteFactory;
import ge.prismrhythm.logic.commands.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class FurEliseNightmare extends Song {

    ArrayList<String> colors = new ArrayList<>();
    ArrayList<Integer> times = new ArrayList<>();
    int noteCount;
    int beat = 200;
    int buffer = 1050;

    public FurEliseNightmare(SceneManager sm, String filePath, String name, NoteFactory nf) {
        super(sm, filePath,name,nf);
        LoadNotes();
    }

    @Override
    public void LoadNotes() {

        try {

            InputStream in = this.getClass().getResourceAsStream("/resources/notes/furelisenightmare.json");
            JSONTokener t = new JSONTokener(in);
            JSONObject obj = new JSONObject(t);
            JSONArray notes = obj.getJSONArray("notes");

            int time;

            for (int i = notes.length() - 1; i > -1; i--) {
                String color = notes.getJSONObject(i).getString("color");
                String type = notes.getJSONObject(i).getString("type");

                time = 0;

                if(type.equals("Q")) {
                    System.out.println("Hit this");
                    time = beat;
                } else if (type.equals("H")) {
                    time = beat * 2;
                } else if (type.equals("W")) {
                    time = beat * 4;
                } else if (type.equals("E")) {
                    time = beat / 2;
                } else if (type.equals("S")) {
                    time = beat / 4;
                } else if (type.equals("QE")) {
                    time = beat + (beat / 2);
                } else if (type.equals("C")) {
                    time = 1;
                } else if (type.equals("TT")) {
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
            //System.out.println("Hitting This");
            switch (color) {
                case "R" -> {
                    NoteCommand rc = new RedNoteCommand(nf);
                    noteQueue.add(rc);
                }
                case "O" -> {
                    NoteCommand oc = new OrangeNoteCommand(nf);
                    noteQueue.add(oc);
                }
                case "Y" -> {
                    NoteCommand yc = new YellowNoteCommand(nf);
                    noteQueue.add(yc);
                }
                case "W" -> {
                    NoteCommand wc = new WhiteNoteCommand(nf);
                    noteQueue.add(wc);
                }
                case "P" -> {
                    NoteCommand pc = new PurpleNoteCommand(nf);
                    noteQueue.add(pc);
                }
                case "B" -> {
                    NoteCommand bc = new BlueNoteCommand(nf);
                    noteQueue.add(bc);
                }
                case "L" -> {
                    NoteCommand lc = new LBlueNoteCommand(nf);
                    noteQueue.add(lc);
                }
                case "G" -> {
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
                    TimeUnit.MILLISECONDS.sleep(7000);
                    songEnded = true;
                    running = false;
                }


            }
        }

        catch(InterruptedException ex)

        {
            Thread.currentThread().interrupt();
        }
    }
}