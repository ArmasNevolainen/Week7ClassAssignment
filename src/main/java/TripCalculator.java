import java.util.Scanner;

public class TripCalculator {
    int distance;
    double price;

    public double fuelNeeded (int distance){
        return  distance / ((double) 100 /5);
    }
    public double totalPrice(double price, double fuel){
        return price * fuel;
    };
    public static void main (String[] args) {
        TripCalculator calculator = new TripCalculator();
        System.out.println("Enter distance to travel: ");
        Scanner scanner = new Scanner(System.in);
        int distance = scanner.nextInt();
        System.out.println("Enter fuel price: ");
        double price = scanner.nextDouble();
        double fuel = calculator.fuelNeeded(distance);
        double total = calculator.totalPrice(price, fuel);
        System.out.println("Fuel needed to travel: " + fuel);
        System.out.println("Trip total cost: " + total);

    }
}
