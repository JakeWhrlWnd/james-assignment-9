package com.coderscampus.assignment9.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@Service
public class RecipeService {

    public void read(String fileName) {
        try (Reader in = new FileReader(fileName)) {
            Iterable<CSVRecord> recipes = CSVFormat.EXCEL.parse(in);

            for (CSVRecord recipe : recipes) {

            }

        } catch (IOException e) {
            System.out.println("There was an issue reading the file, Issue " + e.getMessage());
        }

    }
}
