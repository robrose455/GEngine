package ge.prismrhythm.songs;

import ge.core.managers.SceneManager;
import ge.prismrhythm.logic.NoteFactory;
import ge.prismrhythm.logic.commands.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.sound.sampled.Clip;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class FurEliseNightmare extends Song {

    ArrayList<String> colors = new ArrayList<>();
    ArrayList<Integer> times = new ArrayList<>();
    int noteCount;
    int beat = 200;
    int buffer = 1050;

    public FurEliseNightmare(SceneManager sm, LoadedClip c, String name, NoteFactory nf) {
        super(sm, c,name,nf);
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

        for(int i = 0; i < colors.size(); i++) {
            color = colors.get(i);
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
                    noteCount--;
                } else {
                    TimeUnit.MILLISECONDS.sleep(5000);
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