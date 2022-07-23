import java.util.ArrayList;

public class ExamSchedulerTester {
  
  public static boolean testCourse() {
    //1. check correctness of constructor
    {
      try {
        Course testCourse = new Course("CS300", -1);
        return false;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
    
    //2. check the correctness of getName method
    {
      String expectName = "CS300";
      Course testCourse = new Course("CS300", 250);
      if (!expectName.equals(testCourse.getName())) {
        return false;
      }
    }
    
    //3. check the correctness of getNumStudents method
    {
      int expectNumber = 250;
      Course testCourse = new Course("CS300", 250);
      if (expectNumber != testCourse.getNumStudents()) {
        return false;
      }
    }
      
    return true;
  }
  
  public static boolean testRoom() {
    //1. check correctness of constructor
    {
      try {
        Room testRoom = new Room("Van", -1);
        return false;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
    
    //2. check the correctness of getLocation method
    {
      String expectName = "Van";
      Room testRoom = new Room("Van", 300);
      if (!expectName.equals(testRoom.getLocation())) {
        return false;
      }
    }
    
    //3. check the correctness of getNumStudents method
    {
      int expectNumber = 300;
      Room testRoom = new Room("Van", 300);
      if (expectNumber != testRoom.getCapacity()) {
        return false;
      }
    }
    
    //4. check the correctness of reduceCapacity method
    {
      try {
        Room testRoom = new Room("Van", 300);
        testRoom.reduceCapacity(400);
        return false;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
    
    //5. check the correctness of reduceCapacity method
    {
      int expectNumber = 100;
      Room testRoom = new Room("Van", 300);
      Room newRoom = testRoom.reduceCapacity(200);
      if (expectNumber != newRoom.getCapacity()) {
        return false;
      }
    }
    
    return true;
  }
  
  public static boolean testScheduleAccessors() {
    
    Course[] courseArray = new Course[3];
    Room[] roomArray = new Room[3];
    courseArray[0] = new Course("CS200", 300);
    courseArray[1] = new Course("CS220", 100);
    courseArray[2] = new Course("CS300", 200);
    
    roomArray[0] = new Room("Van", 150);
    roomArray[1] = new Room("Hum", 200);
    roomArray[2] = new Room("Sci", 350);
    
    //1. check correctness of constructor
    {
      String expectOutput = "{CS200: Unassigned, CS220: Unassigned, CS300: Unassigned}";
      Schedule testSchedule = new Schedule(roomArray, courseArray);
      if (!expectOutput.equals(testSchedule.toString())) {
        return false;
      }
    }
    
    //2. check the correctness of getNumRooms method
    {
      int expectNumber = 3;
      Schedule testSchedule = new Schedule(roomArray, courseArray);
      if (expectNumber != testSchedule.getNumRooms()) {
        return false;
      }
    }
    
    //3. check the correctness of getNumRooms method
    {
      int expectNumber = 3;
      Schedule testSchedule = new Schedule(roomArray, courseArray);
      if (expectNumber != testSchedule.getNumCourses()) {
        return false;
      }
    }
    
    //4. check the correctness of getRoom method
    {
      Schedule testSchedule = new Schedule(roomArray, courseArray);
      try {
        testSchedule.getRoom(4);
        return false;
      } catch (IndexOutOfBoundsException e) {
        System.out.println(e.getMessage());
      }
    }
    
    //5. check the correctness of getRoom method
    {
      String expectName = "Van";
      Schedule testSchedule = new Schedule(roomArray, courseArray);
      if (!expectName.equals(testSchedule.getRoom(0).getLocation())) {
        return false;
      }
    }
    
    //6. check the correctness of getCourse method
    {
      Schedule testSchedule = new Schedule(roomArray, courseArray);
      try {
        testSchedule.getCourse(4);
        return false;
      } catch (IndexOutOfBoundsException e) {
        System.out.println(e.getMessage());
      }
    }
    
    //7. check the correctness of getCourse method
    {
      String expectName = "CS200";
      Schedule testSchedule = new Schedule(roomArray, courseArray);
      if (!expectName.equals(testSchedule.getCourse(0).getName())) {
        return false;
      }
    }
    
    //8. check the correctness of getAssignment method
    {
      Schedule testSchedule = new Schedule(roomArray, courseArray);
      try {
        testSchedule.getAssignment(4);
        return false;
      } catch (IndexOutOfBoundsException e) {
        System.out.println(e.getMessage());
      }
    }
    
    //9. check the correctness of getAssignment method
    {
      Schedule testSchedule = new Schedule(roomArray, courseArray);
      try {
        testSchedule.getAssignment(0);
        return false;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
    
    //10. check the correctness of getAssignment method
    {
      String expectName = "Sci";
      Schedule testSchedule = new Schedule(roomArray, courseArray);
      Schedule newSchedule = testSchedule.assignCourse(0, 2);
      if (!expectName.equals(newSchedule.getAssignment(0).getLocation())) {
        return false;
      }
    }
    
    
    return true;
  }
  
  public static boolean testAssignCourse() {
    
    Course[] courseArray = new Course[3];
    Room[] roomArray = new Room[3];
    courseArray[0] = new Course("CS200", 300);
    courseArray[1] = new Course("CS220", 100);
    courseArray[2] = new Course("CS300", 200);
    
    roomArray[0] = new Room("Van", 150);
    roomArray[1] = new Room("Hum", 200);
    roomArray[2] = new Room("Sci", 350);
    
    //1. test when index is out of bound
    {
      Schedule testSchedule = new Schedule(roomArray, courseArray);
      try {
        testSchedule.assignCourse(-1, 0);
        return false;
      } catch (IndexOutOfBoundsException e) {
        System.out.println(e.getMessage());
      }
      
      try {
        testSchedule.assignCourse(0, -1);
        return false;
      } catch (IndexOutOfBoundsException e) {
        System.out.println(e.getMessage());
      }
      
      try {
        testSchedule.assignCourse(4, 0);
        return false;
      } catch (IndexOutOfBoundsException e) {
        System.out.println(e.getMessage());
      }
      
      try {
        testSchedule.assignCourse(0, 4);
        return false;
      } catch (IndexOutOfBoundsException e) {
        System.out.println(e.getMessage());
      }
    }
    
    //2. test when room is assigned or room's capacity is not enough
    {
      Schedule testSchedule = new Schedule(roomArray, courseArray);
      try {
        testSchedule.assignCourse(0, 1);
        return false;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
      
      try {
        Schedule newSchedule = testSchedule.assignCourse(0, 2);
        newSchedule.assignCourse(0, 1);
        return false;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
    
    //3. test the correctness of the assignCourse method
    {
      String expectName = "Sci";
      Schedule testSchedule = new Schedule(roomArray, courseArray);
      Schedule newSchedule = testSchedule.assignCourse(0, 2);
      if (!expectName.equals(newSchedule.getAssignment(0).getLocation())) {
        return false;
      }
    }
    
    //3. test when adding two valid courses into one room
    {
      String expectName = "Sci";
      Schedule testSchedule = new Schedule(roomArray, courseArray);
      Schedule newSchedule = testSchedule.assignCourse(1, 2);
      newSchedule = newSchedule.assignCourse(2, 2);
      if (!expectName.equals(newSchedule.getAssignment(1).getLocation())
          && !expectName.equals(newSchedule.getAssignment(2).getLocation())) {
        return false;
      }
    }

    return true;
  }
  
  public boolean testFindAllSchedules() {
    return true;
  }
  
  public boolean testFindSchedule() {
    return true;
  }
  
  public static void main(String[] args) {
    System.out.println(testCourse());
    System.out.println(testRoom());
    System.out.println(testScheduleAccessors());
    System.out.println(testAssignCourse());
  }
}
