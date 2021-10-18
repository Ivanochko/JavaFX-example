package Comparators;

import Plane.Plane;

import java.util.Comparator;

public class PlaneComparatorByPlaneSpeedDistance implements Comparator<Plane> {
    @Override
    public int compare(Plane plane1, Plane plane2) {
        int result = plane1.getPlane().compareTo(plane2.getPlane());
        if (result != 0) {
            return result;
        } else {
            result = plane2.getSpeed() - plane1.getSpeed();
            if (result != 0) {
                return result;
            } else {
                return Double.compare(plane2.getDistance(), plane1.getDistance());
            }
        }
    }
}
