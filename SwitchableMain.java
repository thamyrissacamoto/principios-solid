interface Switchable {
    void turnOn();
    void turnOff();
}

class LightBulb implements Switchable {
    public void turnOn() {
        System.out.println("LightBulb turned on");
    }

    public void turnOff() {
        System.out.println("LightBulb turned off");
    }
}

class Fan implements Switchable {
    public void turnOn() {
        System.out.println("Fan turned on");
    }

    public void turnOff() {
        System.out.println("Fan turned off");
    }
}

class PowerSwitch {
    private Switchable device;

    public PowerSwitch(Switchable device) {
        this.device = device;
    }

    public void press() {
        device.turnOn();
        device.turnOff();
    }
}

public class SwitchableMain {
    public static void main(String[] args) {
        Switchable bulb = new LightBulb();
        PowerSwitch bulbSwitch = new PowerSwitch(bulb);
        bulbSwitch.press();

        Switchable fan = new Fan();
        PowerSwitch fanSwitch = new PowerSwitch(fan);
        fanSwitch.press();
    }
}