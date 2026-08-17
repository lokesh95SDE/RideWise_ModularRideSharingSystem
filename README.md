# RideWise_ModularRideSharingSystem

| Method | Allowed current status | New status | Driver availability |
|---|---|---|---|
| `assignDriver(driver)` | `REQUESTED` | `ASSIGNED` | Becomes unavailable/reserved |
| `startRide()` | `ASSIGNED` | `IN_PROGRESS` | Stays unavailable |
| `completeRide()` | `IN_PROGRESS` | `COMPLETED` | Becomes available |
| `cancelRide()` | `REQUESTED` | `CANCELLED` | No driver to release |
| `cancelRide()` | `ASSIGNED` | `CANCELLED` | Becomes available again |


```mermaid
flowchart TB
    Main["Main (console UI)"] --> RS["RiderService"]
    Main --> DS["DriverService"]
    Main --> RDS["RideService"]

    RS --> Riders["Map<Integer, Rider>"]
    DS --> Drivers["Map<Integer, Driver>"]
    RDS --> Rides["Map<Integer, Ride>"]

    RDS --> RS
    RDS --> DS
    RDS -. "uses" .-> RMS["RideMatchingStrategy"]
    RDS -. "uses" .-> FS["FareStrategy"]

    RMS --> NDS["NearestDriverStrategy"]
    RMS --> LADS["LeastActiveDriverStrategy"]

    FS --> DFS["DefaultFareStrategy"]
    FS --> PHFS["PeakHourFareStrategy"]

    Rider --> Location
    Driver --> Location
    Driver --> VehicleType
    Ride --> Rider
    Ride --> Driver
    Ride --> RideStatus
    RDS --> Receipt["FareReceipt"]
```


```mermaid
stateDiagram-v2
    [*] --> REQUESTED: create Ride
    REQUESTED --> ASSIGNED: assignDriver
    ASSIGNED --> IN_PROGRESS: startRide
    IN_PROGRESS --> COMPLETED: completeRide
    REQUESTED --> CANCELLED: cancelRide
    ASSIGNED --> CANCELLED: cancelRide
    COMPLETED --> [*]
    CANCELLED --> [*]
```