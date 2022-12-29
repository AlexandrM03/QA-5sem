package errorexceptions;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Student {
    private String surname;
    private Map<String, Integer> lessonsAndMarks;

    public Student(String surname) {
        this.surname = surname;
        lessonsAndMarks = new HashMap<>();
    }

    public void putMark(String lesson, int mark) {
        this.lessonsAndMarks.put(lesson, mark);
    }
}