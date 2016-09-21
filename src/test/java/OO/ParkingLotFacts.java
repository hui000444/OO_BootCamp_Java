package OO;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ZhangChaohui on 9/19/16.
 */
public class ParkingLotFacts {

    @Test
    public void should_be_able_to_pick_out_the_same_car_successfully_after_park_a_car() throws NoAvailableSpaceException, NotFoundCarException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();

        Car token = parkingLot.park(car);

        Assert.assertEquals(car, parkingLot.pickUp(token));
    }

    @Test(expected = NoAvailableSpaceException.class)
    public void should_fail_to_park_when_parking_lot_is_full() throws NoAvailableSpaceException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();

        parkingLot.park(car);

        parkingLot.park(car);
    }

    @Test
    public void should_be_able_to_park_after_picked_a_car_from_a_full_parking_lot() throws NoAvailableSpaceException, NotFoundCarException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Car token = parkingLot.park(car);
        parkingLot.pickUp(token);

        Car newCar = new Car();
        Car newToken = parkingLot.park(newCar);

        Assert.assertEquals(newCar, parkingLot.pickUp(newToken));
    }

    @Test(expected = NotFoundCarException.class)
    public void should_fail_to_pick_a_car_for_a_second_time() throws NoAvailableSpaceException, NotFoundCarException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Car token = parkingLot.park(car);

        parkingLot.pickUp(token);

        parkingLot.pickUp(token);
    }

    @Test
    public void should_be_able_to_pick_out_the_sencond_car_when_parking_lot_has_two_position() throws NoAvailableSpaceException, NotFoundCarException {
        ParkingLot parkingLot = new ParkingLot(2);
        Car car = new Car();
        Car secondCar = new Car();

        Car token = parkingLot.park(car);
        Car secondToken = parkingLot.park(secondCar);

        Assert.assertEquals(secondCar, parkingLot.pickUp(secondToken));
    }

}
