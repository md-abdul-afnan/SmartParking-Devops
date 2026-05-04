package com.smartparking.model;

public class ParkingSlot {
    private final int slotId;
    private final String slotType;
    private boolean available;

    public ParkingSlot(int slotId, String slotType, boolean available) {
        if (slotType == null || slotType.trim().isEmpty()) {
            throw new IllegalArgumentException("Slot type cannot be empty");
        }
        this.slotId = slotId;
        this.slotType = slotType;
        this.available = available;
    }

    public int getSlotId() {
        return slotId;
    }

    public String getSlotType() {
        return slotType;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "slotId=" + slotId +
                ", slotType='" + slotType + '\'' +
                ", available=" + available +
                '}';
    }
}
