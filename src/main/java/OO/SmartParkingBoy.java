package OO;

import java.util.Comparator;

/**
 * Created by ZhangChaohui on 9/19/16.
 */
public class SmartParkingBoy extends ParkingBoyBase {

    public SmartParkingBoy(ParkingLot[] parkingLots) {
        super(parkingLots);
    }


    @Override
    protected Comparator<ParkingLot> getComparator() {
        return new Comparator<ParkingLot>() {
            public int compare(ParkingLot o1, ParkingLot o2) {
                return o1.getCapacity() - o2.getCapacity() > 0 ? -1 : 1;
            }
        };

    }

    protected ParkingLot getParkingLot() {
        return parkingLots.stream()
                .max((lot1, lot2) -> (lot1.getCapacity() - lot2.getCapacity() > 0 ? 1 : -1))
                .get();
    }
}
