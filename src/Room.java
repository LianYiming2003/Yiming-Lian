import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Room {
  
  private String location;
  private int capacity;
  public Room(String location, int capacity) {
    if (capacity < 0) {
      throw new IllegalArgumentException("capacity is negative");
    }
    this.location = location;
    this.capacity = capacity;
  }
  
  public String getLocation() {
    return this.location;
  }
  
  public int getCapacity() {
    return this.capacity;
  }
  
  public Room reduceCapacity(int number) {
    if (number < capacity) {
      return new Room(this.location, this.capacity-number);
    }
    throw new IllegalArgumentException("no enough capacity");
  }
    /**
    if (number < capacity) {
      return new Room(this.location, this.capacity-number);
    }
    throw new IllegalArgumentException("no enough capacity");
  }
  */
}
