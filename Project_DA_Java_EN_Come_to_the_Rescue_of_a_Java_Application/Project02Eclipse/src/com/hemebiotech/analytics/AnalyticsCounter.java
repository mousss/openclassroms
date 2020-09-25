package com.hemebiotech.analytics;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AnalyticsCounter {
    private static final String nameFile = "Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt";

    public static void main(String[] args) throws IOException {
        // out put file
        FileWriter writer = new FileWriter("result.out");
        try {
            //get file from  project
            File file = new File(nameFile);
            // check if file exist
            if (file.exists()) {
                // read all lines from file
                List<String> lines = Files.readAllLines(file.toPath());
                if (lines.size() > 0) {
                    System.out.println("Le nombre total des lines est " + lines.size());
                    Set<String> linesNonDouble = new TreeSet<>(lines);
                    System.out.println("Le nombre de symptomes est " + linesNonDouble.size());
                    //boucler sur set
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
                    writer.close();
                } else {
                    System.out.println("Le fichier est vide !!!!");
                }
            } else {
                System.out.println("Le fichier n'existe pas !!!!");
            }
        } catch (
                Exception e) {
            writer.flush();
            e.printStackTrace();
        }
    }
}
