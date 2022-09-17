package com.mypackage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileModifier {

    private static File FILE_NAME = new File("C:/home/count.txt");

    public static void updateContentOfCountFile() throws IOException {
        String toWrite = FilesFilter.FINAL_DEV_COUNT + "\n" + FilesFilter.FINAL_TEST_COUNT;
        FileOutputStream fos = new FileOutputStream(FILE_NAME, false);
        fos.write(toWrite.getBytes());
        fos.close();
    }


}
