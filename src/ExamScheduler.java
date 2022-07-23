import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ExamScheduler {
  public static Schedule findSchedule(Room[] room, Course[] course) throws IllegalStateException {
    Schedule newSchedule = null;
    newSchedule = findScheduleHelper(new Schedule(room, course), 0);
    return newSchedule;

  }

  private static Schedule findScheduleHelper(Schedule newSchedule, int index) {
    if (index == newSchedule.getNumCourses()) {
      if (newSchedule.isComplete()) {
        return newSchedule;
      } else {
        throw new IllegalStateException("Illegal");
      }
    } else if (newSchedule.isAssigned(index)) {
      return findScheduleHelper(newSchedule, index + 1);
    } else if (!newSchedule.isAssigned(index)) {
      Schedule possibleSchedules;
      for (int i = 0; i <= newSchedule.getNumRooms(); i++) {
        try {
          possibleSchedules = newSchedule.assignCourse(index, i);
          return findScheduleHelper(possibleSchedules, index + 1);
        } catch (IllegalArgumentException e) {

        } catch (IndexOutOfBoundsException e) {
          throw new IllegalStateException();
        } catch (IllegalStateException e) {

        }
      }
    }

    return null;
  }

  public static ArrayList<Schedule> findAllSchedules(Room[] room, Course[] course) {
    return findAllSchedulesHelper(new Schedule(room, course), 0);
  }

  private static ArrayList<Schedule> findAllSchedulesHelper(Schedule newSchedule, int index) {
    ArrayList<Schedule> finalArrayList = new ArrayList<Schedule>();
    if (index == newSchedule.getNumCourses()) {
      if (newSchedule.isComplete()) {
        finalArrayList.add(newSchedule);
        return finalArrayList;
      }
    }
    if (newSchedule.isAssigned(index)) {
      return findAllSchedulesHelper(newSchedule, index + 1);
    }
    if (!newSchedule.isAssigned(index)) {
      Schedule possibleSchedules;
      for (int i = 0; i < newSchedule.getNumRooms(); i++) {
        try {
          possibleSchedules = newSchedule.assignCourse(index, i);
          finalArrayList.addAll(findAllSchedulesHelper(possibleSchedules, index + 1));
        } catch (IllegalArgumentException e) {

        }
      }
      /**
      Schedule possibleSchedules;
      for (int i = 0; i <= newSchedule.getNumRooms(); i++) {
        try {
          possibleSchedules = newSchedule.assignCourse(index, i);
          finalArrayList.addAll(findAllSchedulesHelper(possibleSchedules, index + 1));
        } catch (IllegalArgumentException e) {

        } catch (IndexOutOfBoundsException e) {
          return finalArrayList;
        }
      }
      */
    }
    return finalArrayList;
  }
}
