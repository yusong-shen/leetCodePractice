package systemDesign;
import java.util.*;

/**
 * Definition of Trip:
 * public class Trip {
 *     public int id; // trip's id, primary key
 *     public int driver_id, rider_id; // foreign key
 *     public double lat, lng; // pick up location
 *     public Trip(int rider_id, double lat, double lng);
 * }
 * Definition of Helper
 * class Helper {
 *     public static double get_distance(double lat1, double lng1,
                                         double lat2, double lng2) {
 *         // return distance between (lat1, lng1) and (lat2, lng2)
 *     }
 * };
 */
 
class Location {
    public double lat, lng;
    public Location(double _lat, double _lng) {
        lat = _lat;
        lng = _lng;
    }
}

public class MiniUber {
    
    Map<Integer, Trip> driver2Trip;
    // the available drivers' location
    Map<Integer, Location> driver2Location;
        
    public MiniUber() {
        // initialize your data structure here.
        driver2Trip = new HashMap<Integer, Trip>();
        driver2Location = new HashMap<Integer, Location>();
    }

    // @param driver_id an integer
    // @param lat, lng driver's location
    // return matched trip information if there have matched rider or null
    public Trip report(int driver_id, double lat, double lng) {
        // Write your code here
        // return matched trip information if there have matched
        if (driver2Trip.containsKey(driver_id)) {
            return driver2Trip.get(driver_id);
        }
        // otherwise, report the current location and return null
        if (driver2Location.containsKey(driver_id)) {
            driver2Location.get(driver_id).lat = lat;
            driver2Location.get(driver_id).lng = lng;
        } else {
            driver2Location.put(driver_id, new Location(lat, lng));
        }
        return null;
    }

    // @param rider_id an integer
    // @param lat, lng rider's location
    // return a trip
    public Trip request(int rider_id, double lat, double lng) {
        // Write your code here
        // 1) create a trip with rider's information.
        Trip trip = new Trip(rider_id, lat, lng);
        // 2) find a closest driver
        int driver_id = -1;
        double minDist = -1;
        for (Map.Entry<Integer, Location> entry : driver2Location.entrySet()) {
            int driver = entry.getKey();
            Location loc = entry.getValue();
            double dist = Helper.get_distance(lat, lng, loc.lat, loc.lng);
            if (minDist < 0 || minDist > dist) {
                minDist = dist;
                driver_id = driver;
            }
        }
        // mark this driver not available.
        if (driver_id != -1) {
            driver2Location.remove(driver_id);
        }        
        // 3) fill driver_id into this trip.
        trip.driver_id = driver_id;
        driver2Trip.put(driver_id, trip);
        // 4) return trip
        return trip;
    }
}