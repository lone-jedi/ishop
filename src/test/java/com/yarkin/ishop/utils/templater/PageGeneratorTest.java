package com.yarkin.ishop.utils.templater;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class PageGeneratorTest {
    private static final String PATH_TO_RESOURCES = "src/test/resources";

    @BeforeAll
    public static void initialize() throws IOException {
        File resourceDirectory = new File(PATH_TO_RESOURCES);
        resourceDirectory.mkdirs();

        File htmlFile = new File(resourceDirectory, "test.html");
        htmlFile.createNewFile();

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(htmlFile))
        )) {
            writer.write("<html><head></head><body><h1>Test Servlet</h1></body></html>");
        }
    }

}