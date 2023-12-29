import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract class for AutomobileService
abstract class AutomobileService {
    protected String serviceName;
    protected double serviceCost;

    public AutomobileService(String serviceName, double serviceCost) {
        this.serviceName = serviceName;
        this.serviceCost = serviceCost;
    }

    // Abstract method to perform the service
    abstract void performService();

    public String getServiceName() {
        return serviceName;
    }

    public double getServiceCost() {
        return serviceCost;
    }
}

// Concrete classes for specific services
class OilChangeService extends AutomobileService {
    public OilChangeService() {
        super("Oil Change", 50.0);
    }

    @Override
    void performService() {
        System.out.println("Performing oil change service.");
    }
}

class BrakeService extends AutomobileService {
    public BrakeService() {
        super("Brake Service", 80.0);
    }

    @Override
    void performService() {
        System.out.println("Performing brake service.");
    }
}

class TireRotationService extends AutomobileService {
    public TireRotationService() {
        super("Tire Rotation", 30.0);
    }

    @Override
    void performService() {
        System.out.println("Performing tire rotation service.");
    }
}

class CarWashService extends AutomobileService {
    public CarWashService() {
        super("Car Wash", 40.0);
    }

    @Override
    void performService() {
        System.out.println("Performing car wash service.");
    }
}

class AlignmentService extends AutomobileService {
    public AlignmentService() {
        super("Wheel Alignment", 60.0);
    }

    @Override
    void performService() {
        System.out.println("Performing wheel alignment service.");
    }
}

// Class for user registration
class UserRegistration {
    private String userName;

    public UserRegistration(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}

// Class for payment
class Payment {
    private double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

// Class for service center
class ServiceCenter {
    public List<AutomobileService> services;
    private UserRegistration user;

    public ServiceCenter(UserRegistration user) {
        this.user = user;
        services = new ArrayList<>();
        services.add(new OilChangeService());
        services.add(new BrakeService());
        services.add(new TireRotationService());
        services.add(new CarWashService());
        services.add(new AlignmentService());
    }

    // Method to display available services
    public void displayServices() {
        System.out.println("Available services:");
        for (int i = 0; i < services.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + services.get(i).getServiceName() + " - $" + services.get(i).getServiceCost());
        }
    }

    // Method to perform selected service
    public void performService(int choice) {
        services.get(choice - 1).performService();
    }

    // Method to calculate total bill
    public double calculateTotalBill(List<Integer> choices) {
        double totalBill = 0;
        for (int choice : choices) {
            totalBill += services.get(choice - 1).getServiceCost();
        }
        return totalBill;
    }

    // Method to display greeting and total bill
    public void displayGreetingAndBill(double totalBill) {
        System.out.println("Hello, " + user.getUserName() + "! Thank you for choosing our service center.");
        System.out.println("Your total bill is: $" + totalBill);
    }

    // Method for payment
    public void processPayment(Payment payment) {
        System.out.println("Payment processed successfully. Thank you!");
        System.out.println("Receipt:");
        System.out.println("Amount paid: $" + payment.getAmount());
    }
}

public class AutomobileServiceCenter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        UserRegistration user = new UserRegistration(userName);
        ServiceCenter serviceCenter = new ServiceCenter(user);

        // User choice for services
        List<Integer> selectedServices = new ArrayList<>();
        int serviceChoice;

        do {
            serviceCenter.displayServices();

            System.out.print("Enter the number corresponding to the service you want (0 to finish): ");
            serviceChoice = scanner.nextInt();

            if (serviceChoice > 0 && serviceChoice <= serviceCenter.services.size()) {
                selectedServices.add(serviceChoice);
            }
        } while (serviceChoice != 0);

        // Perform selected services
        for (int choice : selectedServices) {
            serviceCenter.performService(choice);
        }

        // Calculate and display total bill
        double totalBill = serviceCenter.calculateTotalBill(selectedServices);
        serviceCenter.displayGreetingAndBill(totalBill);

        // Payment
        System.out.print("Select payment method (1. Credit Card, 2. Cash): ");
        int paymentChoice = scanner.nextInt();

        if (paymentChoice == 1) {
            System.out.print("Enter credit card number: ");
            String creditCardNumber = scanner.next();
            // Additional logic for credit card payment can be added here
        } else if (paymentChoice == 2) {
            System.out.print("Enter cash amount: $");
            double cashAmount = scanner.nextDouble();
            Payment payment = new Payment(cashAmount);
            serviceCenter.processPayment(payment);
        } else {
            System.out.println("Invalid payment method selected.");
        }
    }
}
