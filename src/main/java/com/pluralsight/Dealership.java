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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> vehicles = new ArrayList<>();
        boolean found = false;
        for(Vehicle v: inventory){
            if(v.getPrice() >= min && v.getPrice() <= max){
                vehicles.add(v);
                found = true;
            }
        }
        if (!found){
            System.out.println("no results.");
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        List<Vehicle> vehicles = new ArrayList<>();
        boolean found = false;
        for(Vehicle v: inventory){
            if(v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)){
                vehicles.add(v);
                found = true;
            }
        }
        if (!found){
            System.out.println("no results.");
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> vehicles = new ArrayList<>();
        boolean found = false;
        for(Vehicle v: inventory){
            if(v.getYear() >= min && v.getYear() <= max){
                vehicles.add(v);
                found = true;
            }
        }
        if (!found){
            System.out.println("no results.");
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color){
        List<Vehicle> vehicles = new ArrayList<>();
        boolean found = false;
        for(Vehicle v: inventory){
            if(v.getColor().equalsIgnoreCase(color)){
                vehicles.add(v);
                found = true;
            }
        }
        if (!found){
            System.out.println("no results.");
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max){
        List<Vehicle> vehicles = new ArrayList<>();
        boolean found = false;
        for(Vehicle v: inventory){
            if(v.getOdometer() >= min &&  v.getOdometer() <= max){
                vehicles.add(v);
                found = true;
            }
        }
        if (!found){
            System.out.println("no results.");
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType){
        List<Vehicle> vehicles = new ArrayList<>();
        boolean found = false;
        for(Vehicle v: inventory){
            if(v.getVehicleType().equalsIgnoreCase(vehicleType)){
                vehicles.add(v);
                found = true;
            }
        }
        if (!found){
            System.out.println("no results.");
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
        inventory.remove(vehicle);
    }
}