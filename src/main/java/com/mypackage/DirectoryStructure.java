package com.mypackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStructure {

    public static final Path HOME_PATH = Paths.get("C:/home");
    public static final Path DEV_PATH = Paths.get("C:/dev");
    public static final Path TEST_PATH = Paths.get("C:/test");


    public void createRequiredDirectories() throws IOException {
        Files.createDirectories(HOME_PATH);
        Files.createDirectories(DEV_PATH);
        Files.createDirectories(TEST_PATH);
    }
}
