abstract class Vehicle {
    public abstract void repair();
}

class Car extends Vehicle {
    public void repair() {
        System.out.println("Repairing car...");
    }
}

class Motorcycle extends Vehicle {
    public void repair() {
        System.out.println("Repairing motorcycle...");
    }
}

class VehicleRepairShop {
    public void repairVehicle(Vehicle vehicle) {
        vehicle.repair();
    }
}

public class VehicleMain {
    public static void main(String[] args) {
        VehicleRepairShop shop = new VehicleRepairShop();

        Vehicle car = new Car();
        Vehicle motorcycle = new Motorcycle();

        shop.repairVehicle(car);
        shop.repairVehicle(motorcycle);
    }
}