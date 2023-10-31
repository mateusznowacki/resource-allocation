package pl.edu.pwr.app.staff;

import java.util.ArrayList;
import java.util.Objects;

public class Employee {

    private ArrayList<String> ProgrammingSkills;
    private  ArrayList<String> ProjectRole;

    public Employee(ArrayList<String> programmingSkills, ArrayList<String> projectRole) {
        ProgrammingSkills = programmingSkills;
        ProjectRole = projectRole;
    }

    public ArrayList<String> getProgrammingSkills() {
        return ProgrammingSkills;
    }

    public ArrayList<String> getProjectRole() {
        return ProjectRole;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ProgrammingSkills=" + ProgrammingSkills +
                ", ProjectRole=" + ProjectRole +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!Objects.equals(ProjectRole, employee.ProjectRole))
            return false;
        return Objects.equals(ProgrammingSkills, employee.ProgrammingSkills);
    }

    @Override
    public int hashCode() {
        int result = ProjectRole != null ? ProjectRole.hashCode() : 0;
        result = 31 * result + (ProgrammingSkills != null ? ProgrammingSkills.hashCode() : 0);
        return result;
    }
}
