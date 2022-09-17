package com.mypackage;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Application has started... creating directories");
        DirectoryStructure directoryStructure = new DirectoryStructure();
        directoryStructure.createRequiredDirectories();
        while (true) {
            FilesFilter.filterJarFiles();
            FilesFilter.filterXmlFiles();
            FileModifier.updateContentOfCountFile();
        }
    }
}
