package com.scurtis.stockify.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Author: Steve Curtis
 * Date: Mar 10, 2020
 **/

public class JsonReader {

    public String readFile(String fileName) {
        String results = "";
        try {
            results = String.join("", Files.readAllLines(Paths.get(fileName)));
        } catch (IOException ioException) {
            // Eat the exception
        }
        return results;
    }

}
