package org.example.uitests.utils;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MyFilesUtils {
    public static File generateLoremFile() throws IOException {
        Faker faker = new Faker();
        List<String> words = faker.lorem().words(100);
        File generatedFile = new File("files", RandomStringUtils.randomAlphabetic(10) + ".txt");
        FileUtils.writeLines(generatedFile, words);
        return generatedFile;
    }

    public static File waitTillFileIsLoaded(File file) throws InterruptedException {
        int count = 0;
        while (count != 60) {
            if (!file.exists()) {
                Thread.sleep(1000);
                count++;
            } else {
                break;
            }
        }

        count = 0;
        while (count < 60) {
            long lengthBefore = file.length();
            Thread.sleep(1000);
            long lengthAfter = file.length();
            if (lengthBefore == lengthAfter) {
                return file;
            } else {
                count++;
            }
        }
        return null;
    }

    public static void clearFilesFolder() {
        createOrCleanDirectory("files");
    }
    public static void clearScreenshotsFolder() {
        createOrCleanDirectory("screenshots");
    }

    public static void createOrCleanDirectory(String dirName) {
        File fileDir = new File(dirName);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        } else {
            try {
                FileUtils.cleanDirectory(fileDir);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        generateLoremFile();
    }
}