package utility;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private String filename;
    private File file;


    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    @Override
    public void logEvent(Event event) {
        file=new File(filename);
        try {
            FileUtils.writeStringToFile(file, event.getMsg());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        this.file = new File (filename);
        file.canWrite();
    }
}
