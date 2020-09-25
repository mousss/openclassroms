package com.hemebiotech.analytics;

import java.io.*;
import java.util.List;
import java.util.Set;

public class AnalyticsCounter extends ReadSymptomDataFromFile {






    public static void main(String[] args) throws IOException {

        FileWriter writer = new FileWriter("result.out");

        ReadSymptomDataFromFile   readSymptomDataFromFile = new AnalyticsCounter();

        List<String> lines =  readSymptomDataFromFile.GetSymptoms();

        Set<String> linesNonDouble = readSymptomDataFromFile.getDistinctSymptoms(lines);

        for (String lineNonDoublee : linesNonDouble) {
            String sym = "";
            int count = 0;
            for (String line : lines) {
                if (line.equals(lineNonDoublee)) {
                    sym = lineNonDoublee;
                    count++;
                }
            }
            System.out.println("total " + sym + " est : " + count);
            writer.write(sym + " : " + count + "\n");
        }


    }


}
