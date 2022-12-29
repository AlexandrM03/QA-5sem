package errorexceptions;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Faculty {
    private String name;
    private List<Group> groups;

    public Faculty(String name) {
        this.name = name;
        groups = new ArrayList<>();
    }

    public void addGroup(Group group) {
        this.groups.add(group);
    }
}