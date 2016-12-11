package OO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangChaohui on 9/19/16.
 */
public class ParkingLot {
    private int capacity;
    private List<Car> carList;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        carList = new ArrayList<Car>();
    }

    protected int getLotsCount(){
        return this.capacity;
    }

    public Car park(Car car) throws NoAvailableSpaceException {
        if (!canPark())
            throw new NoAvailableSpaceException();
        carList.add(car);
        return car;
    }


    public Car pickUp(Car token) throws NotFoundCarException {
        for (Car car : carList) {
            if (car == token) {
                carList.remove(car);
                return car;
            }
        }
        throw new NotFoundCarException();
    }

    protected int getCapacity() {
        return capacity - carList.size();
    }

    protected int getCapacityRate() {
        return (capacity - carList.size()) / capacity;
    }


    protected boolean canPark() {
        return capacity > carList.size();
    }

    protected boolean canPickUp(Car token) {
        return carList.stream().anyMatch(car -> car==token);
    }

    public int getCarCount() {
        return this.carList.size();
    }
}
