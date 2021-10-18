package Files;

import Plane.Plane;
import Plane.PlaneHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    /*
     * Data fields
     */
    private PlaneHandler planeHandler;
    private List<String> filenames;
    private String pathToFile;

    public FileHandler(PlaneHandler planeHandler, List<String> filenames, String pathToFile) {
        this.planeHandler = planeHandler;
        this.filenames = filenames;
        this.pathToFile = pathToFile;
    }

    public FileHandler(PlaneHandler planeHandler, List<String> filenames) {
        this(planeHandler, filenames, "");
    }

    // private constructor to close access to empty constructor
    private FileHandler() {
    }

    public synchronized void addToList(Plane plane) {
        this.planeHandler.add(plane);
    }

    public void readFromFiles() {
        ArrayList<Thread> threads = new ArrayList<>();
        for (String filename : filenames) {
            threads.add(new Thread(new FileReaderThread(this, filename, this.pathToFile)));
        }
        for (Thread thread: threads) {
            thread.start();
        }
        for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Yay!");
            }
        }
    }

    /*
     * Getters and setters for data fields
     */

    public List<String> getFilename() {
        return filenames;
    }

    public void setFilename(List<String> filenames) {
        this.filenames = filenames;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public void writeToFile(){
        try (BufferedWriter writerHigher = new BufferedWriter(new FileWriter(this.pathToFile +  this.filenames.get(2)));
             BufferedWriter writerMiddle = new BufferedWriter(new FileWriter(this.pathToFile +  this.filenames.get(1)));
             BufferedWriter writerLower = new BufferedWriter(new FileWriter(this.pathToFile +  this.filenames.get(0)));){

            int index = 1;
            int speed;
            String toWrite;
            for (Plane tempPlane: this.planeHandler.getPlaneList()) {
                speed =tempPlane.getSpeed();
                toWrite = index++ + " " + tempPlane.toString() + "\n";
                if (speed > 900){
                    writerHigher.write(toWrite);
                }else if(speed < 800){
                    writerLower.write(toWrite);
                }else {
                    writerMiddle.write(toWrite);
                }
            }
            System.out.println("Wrote!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
