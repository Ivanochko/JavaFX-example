package Plane;

public class Plane /* implements Comparable<Plane>*/ {
    /*
    * Data fields
    */
    private String plane;
    private int speed;
    private double distance;

    // full constructor for all fields of dat
    public Plane(String plane, int speed, double distance) {
        this.plane = plane;
        this.speed = speed;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return this.plane + " " + this.speed + " " + this.distance;
    }

//    @Override
//    public int compareTo(Plane plane) {
//        int result = this.plane.compareTo(plane.plane);
//        if (result != 0) {
//            return result;
//        } else {
//            result = this.speed - plane.speed;
//            if (result != 0) {
//                return result;
//            } else {
//                return Double.compare(this.distance, plane.distance);
//            }
//        }
//    }

    /*
     * setters for data
     */

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public int getSpeed() {
        return speed;
    }

    /*
     * getters for data
     */

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
