package OO;

import java.util.Comparator;

/**
 * Created by ZhangChaohui on 9/19/16.
 */
public class SuperParkingBoy extends ParkingBoyBase {

    public SuperParkingBoy(ParkingLot[] parkingLots) {
        super(parkingLots);
    }

    @Override
    protected Comparator<ParkingLot> getComparator() {
        return new Comparator<ParkingLot>() {
            public int compare(ParkingLot o1, ParkingLot o2) {
                return o1.getCapacityRate() - o2.getCapacityRate() > 0 ? -1 : 1;
            }
        };
    }

    protected ParkingLot getParkingLot() {
        return parkingLots.stream()
                .max((lot1, lot2) -> (lot1.getCapacityRate() - lot2.getCapacityRate() > 0 ? 1 : -1))
                .get();
    }
}
