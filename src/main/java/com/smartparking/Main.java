package com.smartparking;

import com.smartparking.model.ParkingSlot;
import com.smartparking.service.ParkingService;

public class Main {
    public static void main(String[] args) {
        ParkingService service = new ParkingService();

        service.addSlot(new ParkingSlot(1, "CAR", true));
        service.addSlot(new ParkingSlot(2, "BIKE", true));
        service.addSlot(new ParkingSlot(3, "CAR", true));

        System.out.println("=== Smart Parking Slot Booking System ===");
        System.out.println("All Slots: " + service.getAllSlots());
        System.out.println("Available Slots: " + service.getAvailableSlots());

        System.out.println("\nBooking slot 1 for vehicle TS09AB1234...");
        service.bookSlot(101, "TS09AB1234", 1);
        System.out.println("Available Slots after booking: " + service.getAvailableSlots());

        System.out.println("\nCancelling booking 101...");
        service.cancelBooking(101);
        System.out.println("Available Slots after cancellation: " + service.getAvailableSlots());
    }
}
