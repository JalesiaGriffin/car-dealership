package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private Scanner scan;
    public UserInterface() {
        scan = new Scanner(System.in);
    }

    public void display(){
    init();

    boolean running = true;
        while (running) {
            menu();
            System.out.print("Select an option: ");
            int option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 99 -> running = false;
                default -> System.out.println("invalid response.");
            }
        }
    scan.close();
    }

    public void processGetByPriceRequest(){
        System.out.println("\nSearch by Price");
        System.out.print("Enter min price: ");
        double min = scan.nextDouble();

        System.out.print("Enter max price: ");
        double max = scan.nextDouble();
        scan.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByMakeModelRequest(){
        System.out.println("\nSearch by Make & Model");
        System.out.print("Enter Make: ");
        String make = scan.nextLine();

        System.out.print("Enter Model: ");
        String model = scan.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    public void processGetByYearRequest(){
        System.out.println("\nSearch by Year");
        System.out.print("Enter start year: ");
        int start = scan.nextInt();

        System.out.print("Enter end year: ");
        int end = scan.nextInt();
        scan.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByYear(start, end);
        displayVehicles(vehicles);
    }

    public void processGetByColorRequest(){
        System.out.println("\nSearch by Color");
        System.out.print("Enter Color: ");
        String color = scan.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    public void processGetByMileageRequest(){
        System.out.println("\nSearch by Mileage");
        System.out.print("Enter Mileage min: ");
        int min = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter Mileage max: ");
        int max = scan.nextInt();
        scan.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByMileage(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByVehicleTypeRequest(){
        System.out.println("\nSearch by Type");
        System.out.print("Enter Vehicle Type: ");
        String type = scan.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByType(type);
        displayVehicles(vehicles);
    }

    public void processGetAllVehiclesRequest(){
        System.out.println("\nAll Vehicles");
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    public void processAddVehicleRequest(){
        System.out.println("\nAdd Vehicle");
        System.out.print("Enter vin: ");
        int vin = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter Year: ");
        int year = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter Make: ");
        String make = scan.nextLine();

        System.out.print("Enter Model: ");
        String model = scan.nextLine();

        System.out.print("Enter Vehicle Type: ");
        String type = scan.nextLine();

        System.out.print("Enter Color: ");
        String color = scan.nextLine();

        System.out.print("Enter Mileage: ");
        int odometer = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter Price: ");
        int price = scan.nextInt();
        scan.nextLine();

        dealership.addVehicle(new Vehicle(vin, year, make, model, type, color, odometer, price));
        System.out.println("vehicle added.");

        DealershipFileManager dfm = new DealershipFileManager();
        dfm.saveDealership(dealership);
    }

    public void processRemoveVehicleRequest(){
        System.out.println("\nRemove Vehicle");
        List<Vehicle> vehicles = dealership.getAllVehicles();
        System.out.print("Enter vin: ");
        int vin = scan.nextInt();
        scan.nextLine();

        boolean found = false;
        for (Vehicle v: vehicles) {
            if (v.getVin() == vin) {
                dealership.removeVehicle(v);
                System.out.println("vehicle removed.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("no results.");
        }
        DealershipFileManager dfm = new DealershipFileManager();
        dfm.saveDealership(dealership);
    }

    public void menu() {
        System.out.println("\nCar Dealership Manager");
        System.out.println("vehicle search options:");
        System.out.println("1) Price Range");
        System.out.println("2) Make & Model");
        System.out.println("3) Year Range");
        System.out.println("4) Color");
        System.out.println("5) Mileage Range");
        System.out.println("6) Type (car, truck, SUV, van)");
        System.out.println("7) All vehicles");
        System.out.println("8) Add a vehicle");
        System.out.println("9) Remove a vehicle");
        System.out.println("99) Quit\n");
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        Vehicle.printVehicleHeader();
        for(Vehicle v: vehicles){
            v.printVehicle(v);
        }
    }

    private void init(){
        DealershipFileManager dfm = new DealershipFileManager();
        dealership = dfm.getDealership();
    }
}