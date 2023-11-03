package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    Scanner scan = new Scanner(System.in);
    public UserInterface() {
        this.dealership = init();
    }

    public void display(){
    Scanner scan = new Scanner(System.in);
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
    }

    public void processGetByPriceRequest(){
        System.out.print("Enter min price: ");
        int min = scan.nextInt();

        System.out.print("Enter max price");
        int max = scan.nextInt();
        scan.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByYear(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByMakeModelRequest(){
        System.out.print("Enter Make: ");
        String make = scan.nextLine();

        System.out.print("Enter Model: ");
        String model = scan.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    public void processGetByYearRequest(){
        System.out.print("Enter start year: ");
        int start = scan.nextInt();

        System.out.print("Enter end year");
        int end = scan.nextInt();
        scan.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByYear(start, end);
        displayVehicles(vehicles);
    }

    public void processGetByColorRequest(){
        System.out.print("Enter Color: ");
        String color = scan.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    public void processGetByMileageRequest(){
        System.out.print("Enter Mileage: ");
        int mileage = scan.nextInt();
        scan.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByMileage(mileage);
        displayVehicles(vehicles);
    }

    public void processGetByVehicleTypeRequest(){
        System.out.print("Enter Vehicle Type: ");
        String type = scan.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByType(type);
        displayVehicles(vehicles);
    }

    public void processGetAllVehiclesRequest(){
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    public void processAddVehicleRequest(){
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
        List<Vehicle> vehicles = dealership.getAllVehicles();
        System.out.print("Enter vin: ");
        int vin = scan.nextInt();

        for (Vehicle v: vehicles) {
            if (v.getVin() == vin) {
                dealership.removeVehicle(v);
                System.out.println("vehicle removed.");
                break;
            }
            else {
                System.out.println("vehicle not found.");
            }
        }
        DealershipFileManager dfm = new DealershipFileManager();
        dfm.saveDealership(dealership);
    }

    public void menu() {
        System.out.println("\nMenu");
        System.out.println("1) Find vehicles within a price range");
        System.out.println("2) Find vehicles by make / model");
        System.out.println("3) Find vehicles by year range");
        System.out.println("4) Find vehicles by color");
        System.out.println("5) Find vehicles by mileage range");
        System.out.println("6) Find vehicles by type (car, truck, SUV, van)");
        System.out.println("7) List ALL vehicles");
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

    private Dealership init(){
        DealershipFileManager dfm = new DealershipFileManager();
        return dfm.getDealership();
    }
}