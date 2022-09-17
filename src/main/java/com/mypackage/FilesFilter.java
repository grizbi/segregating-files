package com.mypackage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class FilesFilter {
    private static final String JAR_EXTENSION = ".jar";
    private static final String XML_EXTENSION = ".xml";
    private static final String SOURCE_LOCATION = DirectoryStructure.HOME_PATH.toString();
    private static final String TARGET_LOCATION_DEV = DirectoryStructure.DEV_PATH.toString();
    private static final String TARGET_LOCATION_TEST = DirectoryStructure.TEST_PATH.toString();
    private static int DEV_COUNT = 0;
    public static String FINAL_DEV_COUNT = "DEV count : " + DEV_COUNT;
    private static int TEST_COUNT = 0;
    public static String FINAL_TEST_COUNT = "TEST count : " + TEST_COUNT;


    public static void filterJarFiles() throws IOException {
        File[] allFiles = new File(DirectoryStructure.HOME_PATH.toString()).listFiles();
        for (File file : allFiles) {
            if (file.isFile() && file.getName().endsWith(JAR_EXTENSION)) {
                BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                if (CreatedFileUtil.getHourOfCreatedFile(attr) % 2 == 0) {
                    Files.move(Paths.get(SOURCE_LOCATION + "/" + file.getName()), Paths.get(TARGET_LOCATION_DEV + "/" + file.getName()), StandardCopyOption.REPLACE_EXISTING);
                    DEV_COUNT++;
                    FINAL_DEV_COUNT = "DEV count : " + DEV_COUNT;
                } else if (CreatedFileUtil.getHourOfCreatedFile(attr) % 2 != 0) {
                    Files.move(Paths.get(SOURCE_LOCATION + "/" + file.getName()), Paths.get(TARGET_LOCATION_TEST + "/" + file.getName()), StandardCopyOption.REPLACE_EXISTING);
                    TEST_COUNT++;
                    FINAL_TEST_COUNT = "TEST count : " + TEST_COUNT;
                }
            }
        }
    }

    public static void filterXmlFiles() throws IOException {
        File[] allFiles = new File(DirectoryStructure.HOME_PATH.toString()).listFiles();
        for (File file : allFiles) {
            if (file.isFile() && file.getName().endsWith(XML_EXTENSION)) {
                Files.move(Paths.get(SOURCE_LOCATION + "/" + file.getName()), Paths.get(TARGET_LOCATION_DEV + "/" + file.getName()), StandardCopyOption.REPLACE_EXISTING);
                DEV_COUNT++;
                FINAL_DEV_COUNT = "DEV count : " + DEV_COUNT;
            }
        }
    }
}
