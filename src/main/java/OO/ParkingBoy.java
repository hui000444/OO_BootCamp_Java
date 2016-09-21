package OO;

import java.util.Comparator;

/**
 * Created by ZhangChaohui on 9/19/16.
 */
public class ParkingBoy extends ParkingBoyBase {

    public ParkingBoy(ParkingLot[] parkingLots) {
        super(parkingLots);
    }

    @Override
    protected Comparator<ParkingLot> getComparator() {
        return new Comparator<ParkingLot>() {
            public int compare(ParkingLot o1, ParkingLot o2) {
                return o1.canPark() ? 1 : -1;
            }
        };
    }

    protected ParkingLot getParkingLot() {
        return parkingLots.stream().filter(parkingLot -> parkingLot.canPark()).findFirst().get();
    }
}
