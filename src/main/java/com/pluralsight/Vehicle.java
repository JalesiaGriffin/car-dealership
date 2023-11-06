package com.pluralsight;

public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public int getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    public int getOdometer() {
        return odometer;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  "vin: " + vin +
                " year: " + year +
                " make: " + make + '\'' +
                " model: " + model + '\'' +
                " vehicleType: " + vehicleType + '\'' +
                " color: " + color + '\'' +
                " odometer: " + odometer +
                " price: " + price;
    }

    public static void printVehicleHeader() {
        System.out.println(String.format("%s", "------------------------------------------------------------------------------------------------------------------------"));
        System.out.println(String.format("%-15s %-15s %-20s %-15s %-15s %-15s %-15s %-15s", "vin", "year", "make",
                "model", "type", "color", "odometer", "price"));
        System.out.println(String.format("%s", "------------------------------------------------------------------------------------------------------------------------"));
    }

    public void printVehicle(Vehicle v) {
        System.out.println(String.format("%-15s %-15s %-20s %-15s %-15s %-15s %-15s %-15s", v.getVin(), v.getYear(), v.getMake(),
                v.getModel(), v.getVehicleType(), v.getColor(), v.getOdometer(), v.getPrice()));
    }
}