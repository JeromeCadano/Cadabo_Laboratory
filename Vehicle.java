import java.util.*;
 
// VEHICLE
class TestVehicle {
    private int speed;
    private String Brand;
    private String FuelType;
 
    public TestVehicle (String Brand, int speed, String FuelType) {
   
    this.speed = speed;
    this.Brand = Brand;
    this.FuelType = FuelType;
 
    }
 
    public int getBrand() { return speed; }
    public String getSpeed() { return Brand; }
    public String getFuelType() { return FuelType; }
   
// DISPLAY
    public void displayInfo() {
 
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Brand: " + Brand);
        System.out.println("Fuel Type" + FuelType);
 
    }
}
 
// CAR
class Car extends TestVehicle {
    private int numDoors;
 
    public Car (String Brand, int speed, String FuelType, int numDoors){
        super(Brand, speed, FuelType);
        this.numDoors = numDoors;
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Number of Doors: " + numDoors);
    }
}
 
// MOTORCYCLE
class Motorcycle extends TestVehicle {
    private boolean hasSidecar;
 
    public Motorcycle (String Brand, int speed, String FuelType, boolean hasSidecar){
        super(Brand, speed, FuelType);
        this.hasSidecar = hasSidecar;
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
    }
   
 }
 public class Vehicle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
// CAR RESULT
        System.out.println("Enter Car Details: ");
        System.out.print("Brand: ");
        String carBrand = scan.nextLine();
        System.out.print("Speed: ");
        int carSpeed = scan.nextInt();
        scan.nextLine();
        System.out.print("Fuel Type: ");
        String carFuelType = scan.nextLine();
        System.out.print("Number of Doors: ");
        int NumDoors = scan.nextInt();
        scan.nextLine();
 
// MOTOR RESULT
        System.out.println("\nEnter Motorcycle Details:");
        System.out.print("Brand: ");
        String motoBrand = scan.nextLine();
        System.out.print("Speed: ");
        int motoSpeed = scan.nextInt();
        scan.nextLine();
        System.out.print("Fuel Type:  ");
        String motoFuel = scan.nextLine();
        System.out.print("Has Sidecar? (true/false): ");
        boolean hasSidecar = scan.nextBoolean();
       
        TestVehicle car = new Car(carBrand, carSpeed, carFuelType, NumDoors);
        TestVehicle motorcycle = new Motorcycle(motoBrand, motoSpeed, motoFuel, hasSidecar);
        System.out.println("\nCar Details:");
        car.displayInfo();
        System.out.println();
        System.out.println("Motorcycle Details:");
        motorcycle.displayInfo();
 
        scan.close();
    }
 
}
   
 
 
 