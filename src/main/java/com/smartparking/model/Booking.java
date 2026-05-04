package com.smartparking.model;

public class Booking {
    private final int bookingId;
    private final String vehicleNumber;
    private final ParkingSlot slot;

    public Booking(int bookingId, String vehicleNumber, ParkingSlot slot) {
        if (vehicleNumber == null || vehicleNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Vehicle number cannot be empty");
        }
        if (slot == null) {
            throw new IllegalArgumentException("Slot cannot be null");
        }
        this.bookingId = bookingId;
        this.vehicleNumber = vehicleNumber;
        this.slot = slot;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", slotId=" + slot.getSlotId() +
                '}';
    }
}
