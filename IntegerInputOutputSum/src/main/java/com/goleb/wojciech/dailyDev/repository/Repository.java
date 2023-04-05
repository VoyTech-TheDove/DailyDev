package com.goleb.wojciech.dailyDev.repository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

public class Repository {
    private boolean fileExist(String fileName) {
        File file = new File(fileName);
        return file.isFile();
    }
    public String readTXTToString (String fileName){
        if(fileExist(fileName)) {
            Path path = Path.of(fileName);
            try {
                return Files.readString(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
    public void printTXTToFile(String txt, String fileName) {
        try {
            PrintWriter out = new PrintWriter(fileName);
            out.println(txt);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("cannot print to file");
        }
    }
    public void saveObjectToFile(String fileName, Object object) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.close();
        } catch (IOException e) {
            System.out.println("IOException while saving the log");
        }
    }

    public Object loadObjectFromFile(String fileName) {
        if (fileExist(fileName)) {
            try {
                FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Object newObject= ois.readObject();
                ois.close();
                return newObject;
            } catch (Exception e) {
                System.out.println("error while loading the file");
            }
        } else {
            System.out.println(fileName + " not found");
        }
        return null;
    }
}
