package util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Utils {

    public static void deleteFolder(String directory_path){
        File file = new File(directory_path);
        try {
            if(file.exists())
                FileUtils.deleteDirectory(file);
        }
        catch (IOException io){
            io.printStackTrace();
        }
    }
}
