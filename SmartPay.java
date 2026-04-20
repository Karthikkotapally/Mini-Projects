import java.util.*;

interface Billable {
    double calculateTotal(int units);
}

class UtilityBill implements Billable {
    double tax = 0;

    public double calculateTotal(int u) {
        double total = 0;

        if (u <= 100) {
            total = u * 1;
        } else if (u <= 300) {
            total = (100 * 1) + (u - 100) * 2;
        } else {
            total = (100 * 1) + (200 * 2) + (u - 300) * 5;
        }

        tax = total * 0.10; // 10% tax
        return total + tax;
    }

    double getTax() {
        return tax;
    }
}

public class SmartPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("\nEnter Customer Name (or type Exit): ");
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("Exit")){
                break;
            }
            System.out.print("Enter Previous Meter Reading: ");
            int prev = sc.nextInt();
            System.out.print("Enter Current Meter Reading: ");
            int curr = sc.nextInt();
            sc.nextLine();

            if (prev > curr) {
                System.out.println("Error: Previous reading cannot be greater than current reading.");
                continue;
            }

            int units = curr - prev;
            UtilityBill ub = new UtilityBill();
            double total = ub.calculateTotal(units);
            double tax = ub.getTax();
            System.out.println("\n===== SMARTPAY DIGITAL RECEIPT =====");
            System.out.println("Customer Name : " + name);
            System.out.println("Units Consumed: " + units);
            System.out.println("Tax Amount    : $" + tax);
            System.out.println("Final Total   : $" + total);
        }
        sc.close();
    }
}