package ge.core.managers;

import java.io.File;

public class JSONReader {

    public JSONReader() {


    }

    public void ReadJson(String filename) {

        ClassLoader classLoader = JSONReader.class.getClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());

        
    }
}
