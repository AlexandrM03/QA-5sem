package errorexceptions;

import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Faculty tov = new Faculty("TOV");
        Faculty fit = new Faculty("FIT");
        Group tov_1 = new Group(1);
        Group tov_2 = new Group(2);
        Group fit_1 = new Group(1);
        Group fit_2 = new Group(2);
        tov.addGroup(tov_1);
        tov.addGroup(tov_2);
        fit.addGroup(fit_1);
        fit.addGroup(fit_2);
        Student student_tov_1 = new Student("ST_TOV_1");
        Student student_tov_2 = new Student("ST_TOV_2");
        Student student_fit_1 = new Student("ST_FIT_1");
        Student student_fit_2 = new Student("ST_FIT_2");
        student_tov_1.putMark("Math", 4);
        student_tov_1.putMark("Chemistry", 7);
        student_tov_2.putMark("Math", 8);
        student_fit_1.putMark("Math", 9);
        student_fit_2.putMark("Math", 6);
        tov_1.addStudent(student_tov_1);
        tov_2.addStudent(student_tov_2);
        fit_1.addStudent(student_fit_1);
        fit_2.addStudent(student_fit_2);

        try {
            System.out.print("AVG for student: ");
            double sumForStudent = 0;
            for (Integer mark : student_tov_1.getLessonsAndMarks().values()) {
                sumForStudent += mark;
            }
            double avgForStudent = sumForStudent / student_tov_1.getLessonsAndMarks().size();
            if (avgForStudent < 0 || avgForStudent > 10) {
                throw new WrongAVGException("Wrong AVG");
            }
            System.out.println(avgForStudent);

            System.out.print("AVG for Math on TOV: ");
            double sumForMathOnTov = 0;
            int count = 0;
            if (tov.getGroups().size() == 0) {
                throw new WrongFacultyException("No groups");
            }
            for (Group group: tov.getGroups()) {
                if (group.getStudents().size() == 0) {
                    throw new WrongGroupException("No students");
                }
                for (Student student: group.getStudents()) {
                    Map<String, Integer> entries = student.getLessonsAndMarks();
                    if (entries.size() == 0) {
                        throw new WrongLessonsException("No lessons");
                    }
                    for (Map.Entry<String, Integer> entry : entries.entrySet()) {
                        if (Objects.equals(entry.getKey(), "Math")) {
                            sumForMathOnTov += entry.getValue();
                            count++;
                        }
                    }
                }
            }
            double avgForMathOnTov = sumForMathOnTov / count;
            if (avgForMathOnTov < 0 || avgForMathOnTov > 10) {
                throw new WrongAVGException("Wrong AVG");
            }
            System.out.println(avgForMathOnTov);

            System.out.print("AVG for Math: ");
            double sumForMathOnFit = 0;
            if (fit.getGroups().size() == 0) {
                throw new WrongFacultyException("No groups");
            }
            for (Group group: fit.getGroups()) {
                if (group.getStudents().size() == 0) {
                    throw new WrongGroupException("No students");
                }
                for (Student student: group.getStudents()) {
                    Map<String, Integer> entries = student.getLessonsAndMarks();
                    if (entries.size() == 0) {
                        throw new WrongLessonsException("No lessons");
                    }
                    for (Map.Entry<String, Integer> entry : entries.entrySet()) {
                        if (Objects.equals(entry.getKey(), "Math")) {
                            sumForMathOnFit += entry.getValue();
                            count++;
                        }
                    }
                }
            }
            double avgForMath = (sumForMathOnTov + sumForMathOnFit) / count;
            if (avgForMath < 0 || avgForMath > 10) {
                throw new WrongAVGException("Wrong AVG");
            }
            System.out.println(avgForMath);
        } catch (WrongAVGException | WrongLessonsException | WrongFacultyException | WrongGroupException e) {
            System.out.println(e.getMessage());
        }
    }
}
