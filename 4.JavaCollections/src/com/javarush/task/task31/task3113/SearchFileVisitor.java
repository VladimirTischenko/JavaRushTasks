package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Vladimir on 31.03.2017.
 */
public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private static int dirCount = -1;
    private static int filesCount = 0;
    private static long dirSize = 0;

    public static int getDirCount() {
        return dirCount;
    }

    public static int getFilesCount() {
        return filesCount;
    }

    public static long getDirSize() {
        return dirSize;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        dirCount ++;
        return super.preVisitDirectory(dir, attrs);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        filesCount++;
        dirSize += Files.size(file);
        return super.visitFile(file, attrs);
    }
}
