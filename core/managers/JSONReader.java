package ge.core.managers;

import org.json.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JSONReader {

    public JSONReader() { }

    public void ReadJson(String filename, ArrayList<String> colors, ArrayList<Integer> times) {

        try {

            String text = Files.readString(Paths.get(filename));
            JSONObject obj = new JSONObject(text);
            JSONArray notes = obj.getJSONArray("notes");

            for (int i = 0; i < notes.length(); i++) {
                String color = notes.getJSONObject(i).getString("color");
                int time = notes.getJSONObject(i).getInt("length");

                colors.add(color);
                System.out.println(color);

                times.add(time);
                System.out.println(time);

            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }
}
