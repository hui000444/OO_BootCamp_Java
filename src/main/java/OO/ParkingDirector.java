package OO;

/**
 * Created by ZhangChaohui on 9/22/16.
 */
public class ParkingDirector {
    private ParkingManager parkingManager;

    public ParkingDirector(ParkingManager parkingManager) {
        this.parkingManager = parkingManager;
    }

    public String printReport() {
        int lotsCount = 0;
        int carCount = 0;
        //parkingManager.parkingLots.stream().forEach();
        for (ParkingLot parkingLot :
                parkingManager.parkingLots) {
            lotsCount += parkingLot.getLotsCount();
            carCount += parkingLot.getCarCount();
        }
        return "M " + carCount + " " + lotsCount;
    }
}
