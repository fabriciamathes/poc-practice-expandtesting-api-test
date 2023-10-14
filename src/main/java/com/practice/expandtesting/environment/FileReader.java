package com.practice.expandtesting.environment;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import static com.practice.expandtesting.environment.Environment.getEnvironment;
import static java.nio.file.Files.newInputStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileReader {
    private static final Logger LOGGER = LogManager.getLogger(FileReader.class);
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");

    public static InputStream readFile() {
        InputStream input = null;
        String path = "src"
                + FILE_SEPARATOR
                + "main"
                + FILE_SEPARATOR
                + "resources"
                + FILE_SEPARATOR
                + "dados-ambiente"
                + FILE_SEPARATOR
                + getEnvironment()
                + FILE_SEPARATOR
                + "application.properties";
        try {
            input = newInputStream(Path.of(path));
        } catch (IOException e) {
            LOGGER.error("File not found", e);
        }
        return input;
    }
}
