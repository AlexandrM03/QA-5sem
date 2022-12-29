package errorexceptions;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Group {
    private int number;
    private List<Student> students;

    public Group(int number) {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
}