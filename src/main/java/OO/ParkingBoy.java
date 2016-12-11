package OO;

import java.util.Comparator;

/**
 * Created by ZhangChaohui on 9/19/16.
 */
public class ParkingBoy extends ParkingBoyBase {

    public ParkingBoy(ParkingLot[] parkingLots) {
        super(parkingLots);
    }


    protected ParkingLot getParkingLot() {
        return parkingLots.stream().filter(parkingLot -> parkingLot.canPark()).findFirst().get();
    }
}
