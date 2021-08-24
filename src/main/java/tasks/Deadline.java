package tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The Deadline class encapsulates all the details of each deadline.
 *
 * @author Quan Teng Foong
 */
public class Deadline extends Task {
    private final LocalDate endTime;

    public Deadline(String message, String endTime){
        super(message);
        this.endTime = LocalDate.parse(endTime);
    }

    /**
     * Overrides toString() method.
     * @return String representation of the Deadline object.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " +
                endTime.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
    /**
     * Converts contents to a storable String.
     *
     * @return a String that represents this Deadline in storage
     */
    @Override
    public String toStorage() {
        return "D|" + super.toStorage() + "/by " + this.endTime;
    }
}
