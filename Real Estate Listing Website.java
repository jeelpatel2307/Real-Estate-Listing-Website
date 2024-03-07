import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Property {
    private String address;
    private int price;
    private int bedrooms;
    private int bathrooms;
    private boolean available;

    public Property(String address, int price, int bedrooms, int bathrooms) {
        this.address = address;
        this.price = price;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.available = true;
    }

    public String getAddress() {
        return address;
    }

    public int getPrice() {
        return price;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Address: " + address +
                ", Price: $" + price +
                ", Bedrooms: " + bedrooms +
                ", Bathrooms: " + bathrooms +
                ", Available: " + (available ? "Yes" : "No");
    }
}

public class RealEstateListing {
    private static List<Property> properties = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Property\n2. View Properties\n3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProperty(scanner);
                    break;
                case 2:
                    viewProperties();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private static void addProperty(Scanner scanner) {
        System.out.println("Enter property details:");
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Price: $");
        int price = scanner.nextInt();
        System.out.print("Bedrooms: ");
        int bedrooms = scanner.nextInt();
        System.out.print("Bathrooms: ");
        int bathrooms = scanner.nextInt();

        Property property = new Property(address, price, bedrooms, bathrooms);
        properties.add(property);
        System.out.println("Property added successfully!");
    }

    private static void viewProperties() {
        if (properties.isEmpty()) {
            System.out.println("No properties available.");
            return;
        }
        System.out.println("Properties:");
        for (Property property : properties) {
            System.out.println(property);
        }
    }
}
