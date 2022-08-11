package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class MoveFiles {
    public static void moveFiles (String source, String destination) throws IOException{
        FileFilter txtFilterer = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return !file.getName().endsWith(".txt");
            }
        };
        FileUtils.copyDirectory(new File(source), new File(destination), txtFilterer);
        FileUtils.cleanDirectory(new File(source));
    }
}
