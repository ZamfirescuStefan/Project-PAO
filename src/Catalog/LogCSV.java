package Catalog;

import java.io.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;

public class LogCSV {
    LogCSV () throws IOException {
        csvWriter = new FileWriter(
                "/Users/stefanzamfirescu/CollageProjects/Project-PAO/src/Catalog/CSV_file/Log.csv");
        csvWriter.append("Timestamp, Function called\n");
    }

    private static LogCSV log_instance = null;
    private static FileWriter csvWriter = null;
    public static LogCSV getInstance() throws IOException {
        if (log_instance == null)
            return new LogCSV();
        else
            return log_instance;
    }

    public static void Log(String message) throws IOException {
        Timestamp instant= Timestamp.from(Instant.now());
        csvWriter.append(instant + "," + message + "\n");
        csvWriter.flush();
    }
}
