package OO;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ZhangChaohui on 9/19/16.
 */
public abstract class ParkingBoyBase {
    protected List<ParkingLot> parkingLots;

    public ParkingBoyBase(ParkingLot[] parkingLots) {
        this.parkingLots = Arrays.asList(parkingLots == null ? new ParkingLot[]{} : parkingLots);
    }

    public Car pickUp(Car token) throws NotFoundCarException {
        for (ParkingLot parkingLot : parkingLots) {
            try {
                return parkingLot.pickUp(token);
            } catch (NotFoundCarException ex) {
                continue;
            }
        }
        throw new NotFoundCarException();
    }

    public Car park(Car car) throws NoAvailableSpaceException {
        if(parkingLots.stream().anyMatch(parkingLot -> parkingLot.canPark())){
            return getParkingLot().park(car);
        }
        throw new NoAvailableSpaceException();
    }

    protected abstract ParkingLot getParkingLot();


    protected boolean canPark() {
        return parkingLots != null
                && parkingLots.size() > 0
                && parkingLots.stream().anyMatch(lot -> lot.canPark());
    }

    public boolean canPickUp(Car token) {
        return parkingLots != null
                && parkingLots.size() > 0
                && parkingLots.stream().anyMatch(lot -> lot.canPickUp(token));
    }
}
