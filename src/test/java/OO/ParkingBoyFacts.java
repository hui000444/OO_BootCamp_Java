package OO;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ZhangChaohui on 9/19/16.
 */
public class ParkingBoyFacts {
    @Test
    public void should_be_able_to_pick_out_the_same_car_successfully_after_park_a_car() throws NoAvailableSpaceException, NotFoundCarException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot[]{parkingLot});

        Car token = parkingBoy.park(car);

        Assert.assertEquals(car, parkingLot.pickUp(token));
    }

    @Test(expected = NoAvailableSpaceException.class)
    public void should_fail_to_park_when_parking_lot_is_full() throws NoAvailableSpaceException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot[]{parkingLot});

        parkingBoy.park(car);

        parkingBoy.park(car);
    }

    @Test
    public void should_be_able_to_park_after_picked_a_car_from_a_full_parking_lot() throws NoAvailableSpaceException, NotFoundCarException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot[]{parkingLot});
        Car token = parkingBoy.park(car);
        parkingBoy.pickUp(token);

        Car newCar = new Car();
        Car newToken = parkingBoy.park(newCar);

        Assert.assertEquals(newCar, parkingBoy.pickUp(newToken));
    }

    @Test(expected = NotFoundCarException.class)
    public void should_fail_to_pick_a_car_for_a_second_time() throws NoAvailableSpaceException, NotFoundCarException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot[]{parkingLot});
        Car token = parkingBoy.park(car);

        parkingBoy.pickUp(token);

        parkingBoy.pickUp(token);
    }

    @Test
    public void should_be_able_to_pick_out_the_car_when_parking_boy_manage_two_parking_lots() throws NoAvailableSpaceException, NotFoundCarException {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot[]{parkingLot, parkingLot2});

        Car token = parkingBoy.park(car);

        Assert.assertEquals(car, parkingBoy.pickUp(token));
    }

}
