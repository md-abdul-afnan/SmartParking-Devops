# Bug Identification and Test Cases

## Identified Bugs

| Bug ID | Description | Location | Status |
|---|---|---|---|
| BUG-01 | Null slot object can crash add flow | `ParkingService.addSlot` | Fixed |
| BUG-02 | Duplicate slot id creates inconsistent records | `ParkingService.addSlot` | Fixed |
| BUG-03 | Booking unavailable slot not blocked | `ParkingService.bookSlot` | Fixed |
| BUG-04 | Empty vehicle number accepted | `Booking` constructor | Fixed |
| BUG-05 | Deleting booked slot can break booking state | `ParkingService.deleteSlot` | Fixed |

## Test Cases

| Test Case ID | Test Method | Expected Result | Status |
|---|---|---|---|
| TC-01 | `testAddSlot` | Slot list size increases | Pass |
| TC-02 | `testAddDuplicateSlot` | Throws `IllegalArgumentException` | Pass |
| TC-03 | `testGetSlotByIdFound` | Returns slot | Pass |
| TC-04 | `testGetSlotByIdNotFound` | Returns empty | Pass |
| TC-05 | `testGetAvailableSlots` | Only available slots returned | Pass |
| TC-06 | `testUpdateSlotAvailabilitySuccess` | Slot state changes | Pass |
| TC-07 | `testBookSlotSuccess` | Slot marked unavailable and booking created | Pass |
| TC-08 | `testBookSlotAlreadyBooked` | Throws `IllegalStateException` | Pass |
| TC-09 | `testCancelBookingSuccess` | Slot restored to available | Pass |
| TC-10 | `testDeleteSlotBookedDenied` | Returns false | Pass |
