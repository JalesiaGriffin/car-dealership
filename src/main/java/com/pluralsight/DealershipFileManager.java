package com.pluralsight;

import java.io.*;
import java.util.ArrayList;


public class DealershipFileManager {
    private String FILE_NAME = "dealership.csv";
    public Dealership getDealership() {
        Dealership dealership = null;
        try {
            // INSTANTIATE READER
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String input;

            // CREATE DEALERSHIP
            input = reader.readLine();
            String[] dealershipTokens = input.split("\\|");
            String name = dealershipTokens[0];
            String address = dealershipTokens[1];
            String phone = dealershipTokens[2];

            dealership = new Dealership(name, address, phone);

            // CREATE VEHICLES
            while ((input = reader.readLine()) != null) {
                String[] tokens = input.split("\\|");
                int vin = Integer.parseInt(tokens[0]);
                int year = Integer.parseInt(tokens[1]);
                String make = tokens[2];
                String model = tokens[3];
                String vehicleType = tokens[4];
                String color = tokens[5];
                int odometer = Integer.parseInt(tokens[6]);
                double price = Double.parseDouble(tokens[7]);

            dealership.addVehicle(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
            }
        reader.close();
        } catch (IOException e) {
            System.out.println("failed to load file.");
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try {
            // DEALERSHIP
            String name = dealership.getName();
            String address = dealership.getAddress();
            String phone = dealership.getPhone();
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            writer.write(name + "|" + address + "|" + phone);
            writer.newLine();


            // VEHICLES
            ArrayList<Vehicle> vehicles = dealership.getInventory();

                for (Vehicle v : vehicles) {
                    int vin = v.getVin();
                    int year = v.getYear();
                    String make = v.getMake();
                    String model = v.getModel();
                    String vehicleType = v.getVehicleType();
                    String color = v.getColor();
                    int odometer = v.getOdometer();
                    double price = v.getPrice();

                    writer.write(vin + "|" + year + "|" + make + "|" + model + "|" +
                                vehicleType + "|" + color + "|" + odometer + "|" + price);
                    writer.newLine();
                }

        writer.close();

         } catch (IOException e){
            System.out.println("failed to update dealership.");
        }
    }
}