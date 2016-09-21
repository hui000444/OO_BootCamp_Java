package OO;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ZhangChaohui on 9/20/16.
 */
public class ParkingManagerFacts {
    @Test
    public void should_be_able_to_pick_out_the_same_car_successfully_after_park_a_car() throws NoAvailableSpaceException, NotFoundCarException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        ParkingManager parkingManager = new ParkingManager(new ParkingLot[]{parkingLot});

        Car token = parkingManager.park(car);

        Assert.assertEquals(car, parkingLot.pickUp(token));
    }

    @Test(expected = NoAvailableSpaceException.class)
    public void should_fail_to_park_when_parking_lot_is_full() throws NoAvailableSpaceException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        ParkingManager parkingManager = new ParkingManager(new ParkingLot[]{parkingLot});

        parkingManager.park(car);

        parkingManager.park(car);
    }

    @Test
    public void should_be_able_to_park_after_picked_a_car_from_a_full_parking_lot() throws NoAvailableSpaceException, NotFoundCarException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        ParkingManager parkingManager = new ParkingManager(new ParkingLot[]{parkingLot});
        Car token = parkingManager.park(car);
        parkingManager.pickUp(token);

        Car newCar = new Car();
        Car newToken = parkingManager.park(newCar);

        Assert.assertEquals(newCar, parkingManager.pickUp(newToken));
    }

    @Test(expected = NotFoundCarException.class)
    public void should_fail_to_pick_a_car_for_a_second_time() throws NoAvailableSpaceException, NotFoundCarException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        ParkingManager parkingManager = new ParkingManager(new ParkingLot[]{parkingLot});
        Car token = parkingManager.park(car);

        parkingManager.pickUp(token);

        parkingManager.pickUp(token);
    }

    @Test
    public void should_be_able_to_pick_out_the_car_when_parking_manager_manage_two_parking_lots() throws NoAvailableSpaceException, NotFoundCarException {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);
        Car car = new Car();
        ParkingManager parkingManager = new ParkingManager(new ParkingLot[]{parkingLot, parkingLot2});

        Car token = parkingManager.park(car);

        Assert.assertEquals(car, parkingManager.pickUp(token));
    }

    @Test
    public void should_park_the_car_when_manager_have_one_parking_boy() throws NoAvailableSpaceException, NotFoundCarException {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot[]{parkingLot});
        ParkingManager parkingManager = new ParkingManager(new ParkingLot[]{});
        parkingManager.setParkingBoys(new ParkingBoyBase[]{parkingBoy});

        Car car = new Car();
        Car token = parkingManager.park(car);

        Assert.assertEquals(car, parkingBoy.pickUp(token));
    }

    @Test
    public void should_park_the_car_when_manager_have_one_parking_boy_and_boy_have_one_parking_lot() throws NoAvailableSpaceException, NotFoundCarException {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot[]{parkingLot});
        ParkingManager parkingManager = new ParkingManager(new ParkingLot[]{new ParkingLot(1)});
        parkingManager.setParkingBoys(new ParkingBoyBase[]{parkingBoy});

        Car car = new Car();
        Car token = parkingManager.park(car);

        Assert.assertEquals(car, parkingManager.pickUp(token));
    }

    @Test
    public void should_park_the_car_when_manager_have_two_parking_boy() throws NoAvailableSpaceException, NotFoundCarException {
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot[]{new ParkingLot(0)});
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(new ParkingLot[]{new ParkingLot(1)});
        ParkingManager parkingManager = new ParkingManager(new ParkingLot[]{});
        parkingManager.setParkingBoys(new ParkingBoyBase[]{parkingBoy, superParkingBoy});

        Car car = new Car();
        Car token = parkingManager.park(car);

        Assert.assertEquals(car, parkingManager.pickUp(token));
    }
}
