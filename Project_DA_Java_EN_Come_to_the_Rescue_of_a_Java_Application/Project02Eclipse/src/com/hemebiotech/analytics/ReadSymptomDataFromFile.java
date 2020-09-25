package com.hemebiotech.analytics;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

/**
 * Simple brute force implementation
 */
public class ReadSymptomDataFromFile implements ISymptomReader {


    @Override
    public List<String> GetSymptoms() {
        List<String> lines = null;
        try {
            //get file from  project
            File file = new File(getNameFileSymptoms());
            // check if file exist
            if (file.exists()) {
                lines = Files.readAllLines(file.toPath());
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    @Override
    public String getNameFileSymptoms() throws IOException {
        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        if (rootPath != null) {

            String appConfigPath = rootPath + "/resources/application.properties";

            Properties appProps = new Properties();
            appProps.load(new FileInputStream(appConfigPath));
            return appProps.getProperty("name.input.file");
        } else {
            return "";
        }
    }

    @Override
    public Set<String> getDistinctSymptoms(List<String> list) {
        return new TreeSet<>(list);
    }


}


