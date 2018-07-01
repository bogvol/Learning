package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class FileEventLogger extends AbstractLogger {

    private File file;

//    @Value("${events.file:target/events_log.txt}")
    private String fileName;

//    public FileEventLogger() {
//    }

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

//    @PostConstruct
    public void init() throws IOException {
        this.file = new File(fileName);
        if (file.exists() && !file.canWrite()) {
            throw new IllegalArgumentException("Can't write to file " + fileName);
        } else if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                throw new IllegalArgumentException("Can't create file", e);
            }
        }
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString() + "\n", true);
        } catch (IOException e) {
            System.out.println("Oops. Something wrong with saving to file");
        }
    }

}
