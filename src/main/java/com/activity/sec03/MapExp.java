package com.activity.sec03;

import com.models.sec03.Car;
import com.models.sec03.CarType;
import com.models.sec03.Dealer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapExp {
    private static final Logger log = LoggerFactory.getLogger(MapExp.class);

    public static void main(String args[]) {
        Car car1 = Car.newBuilder().setMake(12).setType(CarType.SUV).setModel("Accord").build();
        Car car2 = Car.newBuilder().setMake(13).setModel("BMW").build();
        Dealer dealer = Dealer.newBuilder().putInventory(1, car1).putInventory(2, car2).build();

        log.info("{}", dealer);
        log.info("{}", dealer.getInventoryOrDefault(2, car1).equals(Car.getDefaultInstance()));
        log.info("{}", car2.getType()); // Default value for enum is 0

    }
}
