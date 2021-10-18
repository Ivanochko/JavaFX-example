package Files;

import Plane.Plane;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderThread implements Runnable {
    FileHandler fileHandler;
    String filename;
    String pathToFile;

    public FileReaderThread(FileHandler fileHandler, String filename, String pathToFile) {
        this.fileHandler = fileHandler;
        this.filename = filename;
        this.pathToFile = pathToFile;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(this.pathToFile + this.filename))) {
            String line;

            Plane tempPlane;

            while ((line = reader.readLine()) != null) {
                tempPlane = this.createPlaneFromLine(line);
                this.fileHandler.addToList(tempPlane);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!!");
        } catch (IOException e) {
            System.out.println("Something goes wrong!");
        }
    }

    private Plane createPlaneFromLine(String line) {
        String[] dates = line.split(" ");
        String plane = dates[1];
        int speed = Integer.parseInt(dates[2]);
        double distance = Double.parseDouble(dates[3]);
        return new Plane(plane, speed, distance);
    }
}
