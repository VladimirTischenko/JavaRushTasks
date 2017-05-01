package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> fileNamePartList = new ArrayList<>(Arrays.asList(args));
        String resultFileName = fileNamePartList.get(0);
        fileNamePartList.remove(0);
        Collections.sort(fileNamePartList);
        try (FileOutputStream fos = new FileOutputStream(resultFileName)) {
            File tempFile = File.createTempFile("tmp", ".zip");
            FileOutputStream tempFos = new FileOutputStream(tempFile);
            for (String fileNamePart : fileNamePartList) {
                FileInputStream fis = new FileInputStream(fileNamePart);
                byte[] buffer = new byte[fis.available()];
                int readBytes = fis.read(buffer, 0, fis.available());
                tempFos.write(buffer, 0, readBytes);
                fis.close();
            }
            ZipInputStream zis = new ZipInputStream(new FileInputStream(tempFile));
            ZipEntry ze;
            byte[] buffer = new byte[2048];
            while ((ze = zis.getNextEntry()) != null) {
                int len = 0;
                while ((len = zis.read(buffer)) > 0)
                {
                    fos.write(buffer, 0, len);
                }
            }
            zis.close();
            fos.close();
            tempFile.deleteOnExit();
        } catch (IOException e) {
        }
    }
}
