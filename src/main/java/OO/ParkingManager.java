package OO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ZhangChaohui on 9/20/16.
 */
public class ParkingManager extends ParkingBoyBase {

    private List<ParkingBoyBase> parkingBoys;

    public ParkingManager(ParkingLot[] parkingLots) {
        super(parkingLots);
        parkingBoys=new ArrayList<>();
    }

    public Car park(Car car) throws NoAvailableSpaceException {
        if (parkingLots.stream().anyMatch(lot -> lot.canPark())) {
            return parkingLots.stream().filter(lot -> lot.canPark()).findFirst().get().park(car);
        }
        else if (parkingBoys.stream().anyMatch(boy -> boy.canPark())) {
            return parkingBoys.stream().filter(boy -> boy.canPark()).findFirst().get().park(car);
        }
        throw new NoAvailableSpaceException();
    }

    public Car pickUp(Car token) throws NotFoundCarException {
        if(parkingLots.stream().anyMatch(lot->lot.canPickUp(token))){
            return parkingLots.stream().filter(lot->lot.canPickUp(token)).findFirst().get().pickUp(token);
        }
        else if(parkingBoys.stream().anyMatch(boy -> boy.canPickUp(token))) {
            return parkingBoys.stream().filter(boy -> boy.canPickUp(token)).findFirst().get().pickUp(token);
        }
        throw new NotFoundCarException();
    }

    @Override
    protected Comparator<ParkingLot> getComparator() {
        return null;
    }

    public void setParkingBoys(ParkingBoyBase[] parkingBoys) {
        this.parkingBoys = Arrays.asList(parkingBoys == null ? new ParkingBoyBase[]{} : parkingBoys);
    }

    protected ParkingLot getParkingLot() {
        return parkingLots.stream().filter(parkingLot -> parkingLot.canPark()).findFirst().get();
    }
}
