//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Schedule
// Course: CS 300 Spring 2022
//
// Author: Xinya Yan
// Email: xyan89@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Yiming Lian
// Partner Email: ylian7@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___X Write-up states that pair programming is allowed for this assignment.
// ___X We have both read and understand the course Pair Programming Policy.
// ___X We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: (identify each by name and describe how they helped)
// Online Sources: (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class define the Schedule and its relevant methods
 * 
 * @author Yiming Lian, Xinya Yan
 *
 */
public class Schedule {
  private Room[] rooms;
  private Course[] courses;
  private int[] assignments;

  /**
   * Creates a new schedule with given list of room and list of course
   * 
   * @param rooms   a list that includes different rooms
   * @param courses a list that includes different courses
   */
  public Schedule(Room[] rooms, Course[] courses) {
    this.rooms = rooms;
    this.courses = courses;
    this.assignments = new int[courses.length];
    for (int i = 0; i < courses.length; i++) {
      this.assignments[i] = -1;
    }
  }

  /**
   * Creates a new schedule with given list of room and list of course and list of assignments
   * 
   * @param rooms       a list that includes different rooms
   * @param courses     a list that includes different courses
   * @param assignments a list that shows the relationship between rooms and courses
   */
  private Schedule(Room[] rooms, Course[] courses, int[] assignments) {
    this.rooms = rooms;
    this.courses = courses;
    this.assignments = assignments;
  }

  /**
   * returns the number of rooms available in this schedule
   * 
   * @return the number of rooms available in this schedule
   */
  public int getNumRooms() {
    return rooms.length;
  }

  /**
   * returns the Room object at the given index in the rooms array
   * 
   * @param index shows the location of the list that user want to get
   * @return the specified room among the list of rooms
   * @throws IndexOutOfBoundsException if the index is less than 0 or greater than the length of the
   *                                   list
   */
  public Room getRoom(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index >= rooms.length) {
      throw new IndexOutOfBoundsException("Invalid index");
    }
    return rooms[index];
  }

  /**
   * return the number of courses in this schedule
   * 
   * @return the number of courses in this schedule
   */
  public int getNumCourses() {
    return courses.length;
  }

  /**
   * return the specified course in the list of courses using the index user input
   * 
   * @param index shows the location of the list that user want to get
   * @return the specified course among the list of courses
   * @throws IndexOutOfBoundsException if the index is less than 0 or greater than the length of the
   *                                   list
   */
  public Course getCourse(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index >= courses.length) {
      throw new IndexOutOfBoundsException("Invalid index");
    }
    return courses[index];
  }

  /**
   * check whether the course at the given index has been assigned a room
   * 
   * @param index shows the location of the list that user want to check
   * @return true if and only if the course at the given index has been assigned a room; false
   *         otherwise
   */
  public boolean isAssigned(int index) {
    if (assignments[index] != -1) {
      return true;
    }
    return false;
  }

  /**
   * return the specified room in the list of assignment using the index user input
   * 
   * @param index shows the location of the list that user want to get
   * @return the Room object assigned to the course at the given index
   * @throws IndexOutOfBoundsException if the index is less than 0 or greater than the length of the
   *                                   list
   * @throws IllegalArgumentException  if the course has not been assigned a room
   */
  public Room getAssignment(int index) {
    if (index < 0 || index >= assignments.length) {
      throw new IndexOutOfBoundsException("Invalid index");
    }
    if (assignments[index] == -1) {
      throw new IllegalArgumentException("course has not been assigned a room");
    }
    return rooms[assignments[index]];
  }

  /**
   * check whether all courses have been assigned to rooms
   * 
   * @return true if and only if all courses have been assigned to rooms; false otherwise
   */
  public boolean isComplete() {
    for (int i = 0; i < assignments.length; i++) {
      if (assignments[i] == -1) {
        return false;
      }
    }
    return true;
  }

  /**
   * a new Schedule object with the course at the first argument index assigned to the room at the
   * second argument index
   * 
   * @param firstIndex  index shows which course user want to assign
   * @param secondIndex index shows which room user want to assign in
   * @return a new Schedule object with the course at the first argument index assigned to the room
   *         at the second argument index
   * @throws IndexOutOfBoundsException if the given course or room index is invalid
   * @throws IllegalArgumentException  if the given course has already been assigned a room, or if
   *                                   the room does not have sufficient capacity.
   */
  public Schedule assignCourse(int firstIndex, int secondIndex) {
    if (firstIndex < 0 || secondIndex < 0) {
      throw new IndexOutOfBoundsException("Index out of bound");
    }

    if (firstIndex >= courses.length || secondIndex >= rooms.length) {
      throw new IndexOutOfBoundsException("Index out of bound");
    }

    if (assignments[firstIndex] != -1
        || rooms[secondIndex].getCapacity() < courses[firstIndex].getNumStudents()) {
      throw new IllegalArgumentException(
          "Already been assigned a room, or the room does not have sufficient capacity.");
    }
    Room[] alterRooms = new Room[rooms.length];
    Course[] alterCourses = new Course[courses.length];
    int[] alterAssignments = new int[assignments.length];
    for (int i = 0; i < rooms.length; i++) {
      alterRooms[i] = new Room(rooms[i].getLocation(), rooms[i].getCapacity());
    }
    for (int i = 0; i < courses.length; i++) {
      alterCourses[i] = courses[i];
    }
    for (int i = 0; i < assignments.length; i++) {
      alterAssignments[i] = assignments[i];
    }
    alterAssignments[firstIndex] = secondIndex;
    alterRooms[secondIndex] =
        rooms[secondIndex].reduceCapacity(courses[firstIndex].getNumStudents());
    return new Schedule(alterRooms, alterCourses, alterAssignments);
  }

  /**
   * create a String representation of Schedule object
   */
  @Override
  public String toString() {
    String allString = "{";
    for (int i = 0; i < courses.length; i++) {
      allString += (courses[i].getName());
      allString += ": ";
      if (assignments[i] == -1) {
        allString += "Unassigned";
      } else {
        allString += (rooms[assignments[i]].getLocation());
      }
      if (i == courses.length - 1) {
        continue;
      }
      allString += ", ";
    }
    allString += "}";
    return allString;
  }
}
