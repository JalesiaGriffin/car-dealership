package com.pluralsight;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {
    @Test
    public void getVehiclesByPrice_ReturnsList_PriceFound() {
        //arrange
        DealershipFileManager dfm = new DealershipFileManager();
        Dealership d = dfm.getDealership();
        int expectedValue = 2;

        //act
        List<Vehicle> v = d.getVehiclesByPrice(15000, 17000);

        //assert
        int actualValue = v.size();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getVehiclesByMakeModel_ReturnsList_MakeModelFound() {
        //arrange
        DealershipFileManager dfm = new DealershipFileManager();
        Dealership d = dfm.getDealership();
        int expectedValue = 10567;

        //act
        List<Vehicle> v = d.getVehiclesByMakeModel("honda", "Civic");

        //assert
        int actualValue = v.get(0).getVin();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getVehiclesByYear_ReturnsList_YearFound() {
        //arrange
        DealershipFileManager dfm = new DealershipFileManager();
        Dealership d = dfm.getDealership();
        int expectedValue = 3;

        //act
        List<Vehicle> v = d.getVehiclesByYear(2018, 2019);

        //assert
        int actualValue = v.size();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getVehiclesByColor_ReturnsList_ColorFound() {
        //arrange
        DealershipFileManager dfm = new DealershipFileManager();
        Dealership d = dfm.getDealership();
        String expectedValue = "silver";

        //act
        List<Vehicle> v = d.getVehiclesByColor(expectedValue);

        //assert
        String actualValue = v.get(0).getColor();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getVehiclesByMileage_ReturnsList_ColorFound() {
        //arrange
        DealershipFileManager dfm = new DealershipFileManager();
        Dealership d = dfm.getDealership();
        int expectedValue = 25000;

        //act
        List<Vehicle> v = d.getVehiclesByMileage(expectedValue);

        //assert
        int actualValue = v.get(0).getOdometer();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getVehiclesByType_ReturnsList_TypeFound() {
        //arrange
        DealershipFileManager dfm = new DealershipFileManager();
        Dealership d = dfm.getDealership();
        String expectedValue = "truck";

        //act
        List<Vehicle> v = d.getVehiclesByType(expectedValue);

        //assert
        String actualValue = v.get(0).getVehicleType();
        assertEquals(expectedValue, actualValue);
    }
}