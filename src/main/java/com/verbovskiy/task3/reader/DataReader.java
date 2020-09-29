package com.verbovskiy.task3.reader;

import com.verbovskiy.task3.exception.TaskException;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private static Logger logger = LogManager.getLogger(DataReader.class);

    public List<String> readFileData(String fileName) {
        List<String> lines = new ArrayList<>();
        try {
            lines  = Files.readAllLines(Paths.get(fileName));
            logger.log(Level.INFO,"file was successfully read!");

        } catch (IOException e) {
            logger.log(Level.FATAL,"Error while reading file!", e);
        }
        return lines;
    }
}
