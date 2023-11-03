package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class DealershipFileManager {
    public Dealership getDealership() {
        Dealership dealership = null;
        try {
            // INSTANTIATE READER
            BufferedReader reader = new BufferedReader(new FileReader("dealership.csv"));
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

    }
}
