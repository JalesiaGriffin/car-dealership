package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<Vehicle>();
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle v: inventory){
            if(v.getPrice() >= min && v.getPrice() <= max){
                vehicles.add(v);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle v: inventory){
            if(v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)){
                vehicles.add(v);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle v: inventory){
            if(v.getYear() >= min && v.getYear() <= max){
                vehicles.add(v);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color){
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle v: inventory){
            if(v.getColor().equalsIgnoreCase(color)){
                vehicles.add(v);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMileage(int odometer){
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle v: inventory){
            if(v.getOdometer() == odometer){
                vehicles.add(v);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType){
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle v: inventory){
            if(v.getVehicleType().equalsIgnoreCase(vehicleType)){
                vehicles.add(v);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getAllVehicles(){
        return inventory;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){

    }
}
