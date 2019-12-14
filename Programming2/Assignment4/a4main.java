package Assignment4;

public class a4main {
  
  public static void main(String[] args) {
    
    FuelGauge fuel = new FuelGauge();
    Odometer odometer = new Odometer(0, fuel);
    
    for (int x = 0; x < fuel.MAXIMUM_GALLONS; x++) {
      fuel.setGallons();
    }
    
    while (fuel.getGallons() > 0) {
      
      odometer.setMileage();
      
      System.out.println("Mileage: " + odometer.getMileage());  
      System.out.println("Fuel level: " + fuel.getGallons() + " gallons");
      System.out.println("_______________");
    }
  } 
}
