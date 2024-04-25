interface Flyable {
    void fly();
}

interface Driveable {
    void drive();
}

class Airplane implements Flyable {
    public void fly() {
        System.out.println("Airplane is flying.");
    }
}

class Car implements Driveable {
    public void drive() {
        System.out.println("Car is driving.");
    }
}

public class FlyableMain {
    public static void main(String[] args) {
        Airplane airplane = new Airplane();
        airplane.fly();

        Car car = new Car();
        car.drive();
    }
}