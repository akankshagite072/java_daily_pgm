package lab;

import java.util.Scanner;

import java.util.*;
//BankAccount interface
interface BankAccount {
 void deposit(double amount);

 void withdraw(double amount);
}

//CheckingAccount class implementing BankAccount interface
class CheckingAccount implements BankAccount {
 private double balance;

 CheckingAccount() {
     balance = 0.0;
 }

 @Override
 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposit successful. Current balance: " + balance);
     } else {
         System.out.println("Invalid deposit amount.");
     }
 }

 @Override
 public void withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         System.out.println("Withdrawal successful. Current balance: " + balance);
     } else {
         System.out.println("Invalid withdrawal amount or insufficient funds.");
     }
 }
}

//Vehicle class
class Vehicle {
 String brand;
 String model;
 int year;

 Vehicle(String brand, String model, int year) {
     this.brand = brand;
     this.model = model;
     this.year = year;
 }

 void drive() {
     System.out.println("Vehicle is in motion.");
 }
}

//Car class inheriting from Vehicle
class Car extends Vehicle {
 String color;

 Car(String brand, String model, int year, String color) {
     super(brand, model, year);
     this.color = color;
 }

 void honk() {
     System.out.println("Car is honking!");
 }
}

public class Account{
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     // Creating a CheckingAccount object and performing operations
     CheckingAccount checkingAccount = new CheckingAccount();
     System.out.print("Enter deposit amount: ");
     double depositAmount = scanner.nextDouble();
     checkingAccount.deposit(depositAmount);

     System.out.print("Enter withdrawal amount: ");
     double withdrawalAmount = scanner.nextDouble();
     checkingAccount.withdraw(withdrawalAmount);

     // Creating a Car object and calling methods
     System.out.print("Enter car brand: ");
     String carBrand = scanner.next();

     System.out.print("Enter car model: ");
     String carModel = scanner.next();

     System.out.print("Enter car year: ");
     int carYear = scanner.nextInt();

     System.out.print("Enter car color: ");
     String carColor = scanner.next();

     Car myCar = new Car(carBrand, carModel, carYear, carColor);
     myCar.drive();
     myCar.honk();

     scanner.close();
 }
}
