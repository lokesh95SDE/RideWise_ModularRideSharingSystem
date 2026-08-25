import Entity.*;
import Service.DriverService;
import Service.RideService;
import Service.RiderService;
import Strategy.DefaultFareStrategy;
import Strategy.FareStrategy;
import Strategy.NearestDriverStrategy;

import java.math.BigDecimal;

public class Main {


//1. Add Rider
//2. Add Driver
//3. View Available Drivers
//4. Request Ride
//5. Start Ride
//6. Complete Ride
//7. Cancel Ride
//8. View Rides
//9. Exit

    public static void main(String[] args)
    {

        DefaultFareStrategy fareStrategy = new DefaultFareStrategy();
        NearestDriverStrategy rideMatchingStrategy = new NearestDriverStrategy();
        DriverService driverService = new DriverService();
        RiderService riderService = new RiderService();
        RideService rideService =new RideService(fareStrategy,rideMatchingStrategy,driverService,riderService);
// Rider 2 Reference Point: Tambaram / Mudichur (12.8000, 80.1000)

// 1. Nearby (~3 km away - Chromepet area)
        Driver driver1 = new Driver(1, "John Doe", "+1234567890", new Location(12.8241, 80.1362), VehicleType.BIKE);
// 2. Medium Distance (~12 km away - Airport / Guindy area)
        Driver driver2 = new Driver(2, "Arun Kumar", "+1234567891", new Location(12.9815, 80.1636), VehicleType.BIKE);
// 3. A Bit Farther (~20 km away - NIOT / Velachery area)
        Driver driver3 = new Driver(3, "Priya Sharma", "+1234567892", new Location(12.9575, 80.2132), VehicleType.BIKE);
// 4. Long Distance (~30 km away - T. Nagar / Central Chennai)
        Driver driver4 = new Driver(4, "Karthik Raj", "+1234567893", new Location(13.0418, 80.2341), VehicleType.BIKE);
// 5. Very Long Distance (~40 km away - Chennai Central / Parrys area)
        Driver driver5 = new Driver(5, "Suresh Patel", "+1234567894", new Location(13.0827, 80.2707), VehicleType.BIKE);

        Rider rider2 = new Rider(1, "Jane Smith", "+0987654321", new Location(12.8, 80.1));

        driverService.registerDriver(driver1);
        driverService.registerDriver(driver2);
        driverService.registerDriver(driver3);
        driverService.registerDriver(driver4);
        driverService.registerDriver(driver5);
        riderService.registerRider(rider2);

        System.out.println(driverService.getAvailableDrivers());
        rideService.requestRide(rider2.getRiderId(), 10.0);
        System.out.println(driverService.getAvailableDrivers());
        rideService.startRide(1);
        rideService.completeRide(1);


    }

}
