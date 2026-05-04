package com.smartparking.service;

import com.smartparking.model.Booking;
import com.smartparking.model.ParkingSlot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class ParkingServiceTest {

    private ParkingService service;

    @Before
    public void setUp() {
        service = new ParkingService();
        service.addSlot(new ParkingSlot(1, "CAR", true));
        service.addSlot(new ParkingSlot(2, "BIKE", true));
        service.addSlot(new ParkingSlot(3, "CAR", false));
    }

    @Test
    public void testAddSlot() {
        service.addSlot(new ParkingSlot(4, "CAR", true));
        assertEquals(4, service.getAllSlots().size());
    }

    @Test
    public void testAddDuplicateSlot() {
        assertThrows(IllegalArgumentException.class, () -> service.addSlot(new ParkingSlot(1, "CAR", true)));
    }

    @Test
    public void testGetSlotByIdFound() {
        assertTrue(service.getSlotById(2).isPresent());
    }

    @Test
    public void testGetSlotByIdNotFound() {
        assertFalse(service.getSlotById(99).isPresent());
    }

    @Test
    public void testGetAvailableSlots() {
        assertEquals(2, service.getAvailableSlots().size());
    }

    @Test
    public void testUpdateSlotAvailabilitySuccess() {
        assertTrue(service.updateSlotAvailability(2, false));
        assertFalse(service.getSlotById(2).get().isAvailable());
    }

    @Test
    public void testUpdateSlotAvailabilityNotFound() {
        assertFalse(service.updateSlotAvailability(200, true));
    }

    @Test
    public void testBookSlotSuccess() {
        Booking booking = service.bookSlot(101, "TS09AB1234", 1);
        assertNotNull(booking);
        assertFalse(service.getSlotById(1).get().isAvailable());
    }

    @Test
    public void testBookSlotAlreadyBooked() {
        assertThrows(IllegalStateException.class, () -> service.bookSlot(102, "TS10CD5678", 3));
    }

    @Test
    public void testCancelBookingSuccess() {
        service.bookSlot(201, "TS09ZZ9000", 1);
        assertTrue(service.cancelBooking(201));
        assertTrue(service.getSlotById(1).get().isAvailable());
    }

    @Test
    public void testDeleteSlotBookedDenied() {
        service.bookSlot(301, "TS11YY1111", 1);
        assertFalse(service.deleteSlot(1));
    }

    @Test
    public void testDeleteSlotSuccess() {
        assertTrue(service.deleteSlot(2));
        assertEquals(2, service.getAllSlots().size());
    }
}
