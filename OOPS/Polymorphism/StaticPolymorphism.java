package Polymorphism;


//The same action can behave differently depending on the input parameters
class ManualCar {
    protected int totalGear;
    protected String brand;
    protected String model;

    public ManualCar(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.totalGear = 5;
        System.out.println("Displaying normal model of Manual Car");
    }

    public ManualCar(String brand, String model, int totalGear) {
        this.brand = brand;
        this.model = model;
        this.totalGear = totalGear;
        System.out.println("Displaying special model of Manual Car");
    }

    public int totalGear() {
        return totalGear;
    }

}

public class StaticPolymorphism {
    public static void main(String[] args) {
        ManualCar myManualCar1 = new ManualCar("Suzuki", "WagonR");
        System.out.println("Top gear of " + myManualCar1.model + " is " + myManualCar1.totalGear());
        ManualCar myManualCar2 = new ManualCar("Toyata", "Inova", 6);
        System.out.println("Top gear of " + myManualCar2.model + " is " + myManualCar2.totalGear());
        
    }
}
