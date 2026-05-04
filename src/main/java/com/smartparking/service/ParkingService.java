package com.smartparking.service;

import com.smartparking.model.Booking;
import com.smartparking.model.ParkingSlot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ParkingService {
    private final List<ParkingSlot> slots = new ArrayList<>();
    private final List<Booking> bookings = new ArrayList<>();

    public void addSlot(ParkingSlot slot) {
        if (slot == null) {
            throw new IllegalArgumentException("Slot cannot be null");
        }
        boolean exists = slots.stream().anyMatch(s -> s.getSlotId() == slot.getSlotId());
        if (exists) {
            throw new IllegalArgumentException("Duplicate slot id: " + slot.getSlotId());
        }
        slots.add(slot);
    }

    public List<ParkingSlot> getAllSlots() {
        return new ArrayList<>(slots);
    }

    public List<ParkingSlot> getAvailableSlots() {
        return slots.stream().filter(ParkingSlot::isAvailable).collect(Collectors.toList());
    }

    public Optional<ParkingSlot> getSlotById(int slotId) {
        return slots.stream().filter(slot -> slot.getSlotId() == slotId).findFirst();
    }

    public boolean updateSlotAvailability(int slotId, boolean available) {
        Optional<ParkingSlot> slot = getSlotById(slotId);
        if (slot.isPresent()) {
            slot.get().setAvailable(available);
            return true;
        }
        return false;
    }

    public boolean deleteSlot(int slotId) {
        if (bookings.stream().anyMatch(booking -> booking.getSlot().getSlotId() == slotId)) {
            return false;
        }
        return slots.removeIf(slot -> slot.getSlotId() == slotId);
    }

    public Booking bookSlot(int bookingId, String vehicleNumber, int slotId) {
        ParkingSlot slot = getSlotById(slotId)
                .orElseThrow(() -> new IllegalArgumentException("Slot not found"));
        if (!slot.isAvailable()) {
            throw new IllegalStateException("Slot is already booked");
        }
        slot.setAvailable(false);
        Booking booking = new Booking(bookingId, vehicleNumber, slot);
        bookings.add(booking);
        return booking;
    }

    public boolean cancelBooking(int bookingId) {
        Optional<Booking> bookingOptional = bookings.stream()
                .filter(booking -> booking.getBookingId() == bookingId)
                .findFirst();
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            booking.getSlot().setAvailable(true);
            bookings.remove(booking);
            return true;
        }
        return false;
    }

    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookings);
    }
}
