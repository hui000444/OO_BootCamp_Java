package OO;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ZhangChaohui on 9/22/16.
 */
public class ParkingDirectorFacts {
    @Test
    public void should_response_when_manager_have_one_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingManager parkingManager = new ParkingManager(new ParkingLot[]{parkingLot});

        ParkingDirector parkingDirector = new ParkingDirector(parkingManager);

        Assert.assertEquals("M 0 1", parkingDirector.printReport());
    }

    @Test
    public void should_response_when_manager_have_one_parking_lot_and_parked_one_car() throws NoAvailableSpaceException {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());
        ParkingManager parkingManager = new ParkingManager(new ParkingLot[]{parkingLot});

        ParkingDirector parkingDirector = new ParkingDirector(parkingManager);

        Assert.assertEquals("M 1 1", parkingDirector.printReport());
    }


    @Test
    public void should_response_when_manager_have_one_parking_boy_with_one_lot_parked_one_car() throws NoAvailableSpaceException {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());
        ParkingBoy parkingBoy=new ParkingBoy(new ParkingLot[]{parkingLot});
        ParkingManager parkingManager = new ParkingManager(new ParkingLot[]{parkingLot});

        ParkingDirector parkingDirector = new ParkingDirector(parkingManager);

        Assert.assertEquals("M 1 1", parkingDirector.printReport());
    }
}
