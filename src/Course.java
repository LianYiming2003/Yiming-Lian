//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Course
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
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * This class define the course and its relevant methods
 * 
 * @author Yiming Lian, Xinya Yan
 *
 */
public class Course {
  private String name;
  private int numStudents;

  /**
   * Create a new course with the input name and number
   * 
   * @param name   the name of the course
   * @param number the number of students in this course
   */
  public Course(String name, int number) {
    if (number < 0) {
      throw new IllegalArgumentException("number is negative");
    }
    this.name = name;
    this.numStudents = number;
  }

  /**
   * Return the name of the course
   * 
   * @return name of the course
   */
  public String getName() {
    return this.name;
  }

  /**
   * Return the number of students enrolled in the course
   * 
   * @return how many students enrolled in the course
   */
  public int getNumStudents() {
    return this.numStudents;
  }
}
