package com.mypackage;

import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class CreatedFileUtil {

    public static int getHourOfCreatedFile(BasicFileAttributes attr) {
        LocalDateTime localDateTime = attr.creationTime()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        return localDateTime.getHour();
    }

}
