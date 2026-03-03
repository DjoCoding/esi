import java.util.Arrays;

class TimeSlot {
    private final int day;
    private final int startHour;
    private final int endHour;

    public TimeSlot(int day, int startHour, int endHour) {
        this.day = day;
        this.startHour = startHour;
        this.endHour = endHour;
        this.mustBeValidOrThrow();
    }

    private void mustBeValidOrThrow() {
        if (this.day < 1 || this.day > 7)
            throw new IllegalStateException("Day field must be within the range [1..7]");
        if (this.startHour < 0 || this.startHour > 23)
            throw new IllegalStateException("Start hour field must be within the range [0..23]");
        if (this.startHour < 1 || this.startHour > 24)
            throw new IllegalStateException("End hour field must be within the range [1..24]");
        if (this.startHour >= this.endHour)
            throw new IllegalStateException("End hour must be after start hour");
    }

    public boolean overlaps(TimeSlot other) {
        if (other.getDay() != this.getDay())
            return false;

        if (this.getStartHour() < other.getStartHour() && this.getEndHour() > other.getStartHour()) {
            return true;
        }

        if (other.getStartHour() < this.getStartHour() && other.getEndHour() > this.getEndHour()) {
            return true;
        }

        return false;
    }

    public int getDay() {
        return day;
    }

    public int getEndHour() {
        return endHour;
    }

    public int getStartHour() {
        return startHour;
    }

    @Override
    public String toString() {
        return "%d - [%d:%d]".formatted(this.getDay(), this.getStartHour(), this.getEndHour());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        TimeSlot time = (TimeSlot) obj;

        if (this.getDay() != time.getDay())
            return false;

        if (this.getStartHour() != time.getStartHour())
            return false;

        return this.getEndHour() == time.getEndHour();
    }
}

class Reservation {
    private final String studentName;
    private final TimeSlot time;

    public Reservation(String studentName, TimeSlot time) {
        this.studentName = studentName;
        this.time = time;
    }

    public String summary() {
        return "Student: %s | time: %s".formatted(this.studentName, this.time.toString());
    }

    public String getStudent() {
        return studentName;
    }

    public TimeSlot getTime() {
        return time;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        Reservation res = (Reservation) obj;

        if (!this.studentName.equals(res.getStudent()))
            return false;

        return this.time.equals(res.getTime());
    }
}

class StudyRoom {
    private final String name;
    private Reservation[] reservations;
    private int size;

    public StudyRoom(String name) {
        this.name = name;
        this.reservations = new Reservation[50];
        this.size = 0;
    }

    public boolean reserve(String student, TimeSlot time) {
        for (int i = 0; i < this.size; ++i) {
            Reservation reservation = this.reservations[i];
            if (reservation.getTime().overlaps(time))
                return false;
        }

        if (this.isFull())
            this.resize();

        this.reservations[this.size] = new Reservation(student, time);
        this.size += 1;

        return true;
    }

    public boolean cancel(String student, TimeSlot time) {
        for (int i = 0; i < this.size; ++i) {
            Reservation res = this.reservations[i];

            if (!res.getStudent().equals(student))
                continue;

            if (res.getTime().equals(time)) {
                this.cancelAt(i);
                return true;
            }
        }
        return false;
    }

    public void printSchedule(int day) {
        for (int i = 0; i < this.size; ++i) {
            if (this.reservations[i].getTime().getDay() != day)
                continue;
            System.out.println(this.reservations[i].summary());
        }
    }

    private void resize() {
        assert this.size >= this.reservations.length;
        this.reservations = Arrays.copyOf(this.reservations, this.reservations.length * 2);
    }

    private boolean isFull() {
        return this.size >= this.reservations.length;
    }

    private void cancelAt(int index) {
        assert index < this.size;
        assert index >= 0;

        for (int i = index; i < this.size - 1; ++i) {
            this.reservations[i] = this.reservations[i + 1];
        }

        this.size -= 1;
    }
}

public class Main {

    public static void main(String[] args) {

        // Create a study room
        StudyRoom room = new StudyRoom("TP11");

        // Create some time slots
        TimeSlot slot1 = new TimeSlot(1, 9, 11); // Monday 9–11
        TimeSlot slot2 = new TimeSlot(1, 11, 13); // Monday 11–13
        TimeSlot slot3 = new TimeSlot(1, 10, 12); // Monday 10–12 (overlaps with slot1)
        TimeSlot slot4 = new TimeSlot(2, 9, 11); // Tuesday 9–11

        // Make reservations
        System.out.println("Reserve Alice (9–11 Monday): "
                + room.reserve("Alice", slot1));

        System.out.println("Reserve Bob (11–13 Monday): "
                + room.reserve("Bob", slot2));

        // This should fail because it overlaps with Alice's reservation
        System.out.println("Reserve Charlie (10–12 Monday, overlaps): "
                + room.reserve("Charlie", slot3));

        // Different day → should succeed
        System.out.println("Reserve David (9–11 Tuesday): "
                + room.reserve("David", slot4));

        // Print Monday schedule
        System.out.println("\n--- Monday Schedule ---");
        room.printSchedule(1);

        // Cancel Alice's reservation
        System.out.println("\nCancel Alice (9–11 Monday): "
                + room.cancel("Alice", slot1));

        // Try reserving Charlie again (should now succeed)
        System.out.println("Reserve Charlie again (10–12 Monday): "
                + room.reserve("Charlie", slot3));

        // Print Monday schedule again
        System.out.println("\n--- Monday Schedule After Changes ---");
        room.printSchedule(1);
    }
}