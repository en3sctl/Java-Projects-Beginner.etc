package ProgramThatCalculatesFlightTicketPrice;

import java.util.Scanner;

public class FlightTicketCalculator {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int km, age, type;
        System.out.println("Enter Distance: ");
        km = scan.nextInt();
        System.out.println("\nEnter Age: ");
        age = scan.nextInt();
        System.out.println("\nChoose The Type of Trip (1-One Way, 2-Departure-Return): ");
        type = scan.nextInt();

        double normalPrice, mourningAllowance, typeDiscount;

        if (km > 0 && age > 0 && (type == 1 || type == 2)) {
            normalPrice = km * 0.10;
            if (age < 12) {
                mourningAllowance = (normalPrice * 50) / 100; // I calculate the discount rate
            } else if (age >= 12 && age <= 24) {
                mourningAllowance = normalPrice * 0.10;
            } else if (age >= 65) {
                mourningAllowance = normalPrice * 0.30;
            } else {
                mourningAllowance = 0;
            }
            normalPrice -= mourningAllowance; // I take my share of the discount from the price
            if (type == 2) {
                typeDiscount = normalPrice * 0.20;
                normalPrice -= typeDiscount;
            }
            System.out.println("Ticket Amount: "+normalPrice);
        } else {
            System.out.println("The values you entered are missing or incorrect, please try again. ");
        }
    }
}
