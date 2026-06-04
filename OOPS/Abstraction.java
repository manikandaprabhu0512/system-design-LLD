/*
    Car Interface --> It acts like a interface for the outer world showing what it can do.
    This will tell what it can do, but not how it does it.
    This interface will be implemented by the concrete classes / child classes.
*/

interface Car {
    void startEngine(); 
    void shiftGear(int gear);
    void accelerate();
    void brake();
    void stopEngine();
}

class SportsCar implements Car {
    
    @Override
    public void startEngine() {
        System.out.println("Engine started");
    }
    @Override
    public void shiftGear(int gear) {
        System.out.println("Gear shifted to " + gear);
    }
    @Override
    public void accelerate() {
        System.out.println("Accelerating...");
    }
    @Override
    public void brake() {
        System.out.println("Braking...");
    }
    @Override
    public void stopEngine() {
        System.out.println("Engine stopped");
    }

}

public class Abstraction {
    public static void main(String[] args) {
        SportsCar car = new SportsCar();
        car.startEngine();
        car.shiftGear(2);
        car.accelerate();
        car.brake();
        car.stopEngine();
    }
}
