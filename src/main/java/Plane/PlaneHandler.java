package Plane;

import Comparators.PlaneComparatorByPlaneSpeedDistance;
import Comparators.PlaneComparatorBySpeedDistancePlane;
import Comparators.PlaneComparatorBySpeedPlaneDistance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PlaneHandler {
    private List<Plane> planeList = new ArrayList<Plane>();

    public PlaneHandler(List<Plane> planeList) {
        this.planeList = planeList;
    }

    public PlaneHandler(Plane... planes) {
        this.planeList.addAll(Arrays.asList(planes));
    }

    public List<Plane> getPlaneList() {
        return planeList;
    }

    public void out() {
        for (Plane plane : planeList) {
            System.out.println(plane);
        }
    }

    public void add(Plane plane) {
        this.planeList.add(plane);
    }

    public void add(Plane... planes) {
        this.planeList.addAll(Arrays.asList(planes));
    }

    public void add(List<Plane> planes) {
        this.planeList.addAll(planes);
    }

    public void sortList(Comparator<Plane> comparatorType) {
        this.planeList = this.planeList.stream()
                .sorted(comparatorType)
                .collect(Collectors.toList());
    }

    private void sortByPlaneSpeedDistance() {
        this.sortList(new PlaneComparatorByPlaneSpeedDistance());
    }

    private void sortBySpeedPlaneDistance() {
        this.sortList(new PlaneComparatorBySpeedPlaneDistance());
    }

    private void sortBySpeedDistancePlane() {
        this.sortList(new PlaneComparatorBySpeedDistancePlane());
    }

    public void sortFirstType() {
        this.sortByPlaneSpeedDistance();
    }

    public void sortSecondType() {
        this.sortBySpeedPlaneDistance();
    }

    public void sortThirdType() {
        this.sortBySpeedDistancePlane();
    }

    public  void  sortByCombobox(String value){
        switch (value) {
            case "Plane - Speed - Distance":
                this.sortFirstType();
                break;
            case "Speed - Plane - Distance":
                this.sortSecondType();
                break;
            case "Speed - Distance - Plane":
                this.sortThirdType();
                break;
            default:
                break;
        }
    }
}
