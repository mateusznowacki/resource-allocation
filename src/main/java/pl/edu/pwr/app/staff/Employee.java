package pl.edu.pwr.app.staff;

import java.util.Objects;
import java.util.Set;

public class Employee {

    private final Set<ProgrammingSkills> ProgrammingSkills;
    private final Set<ProjectRole> ProjectRole;

    public Employee(Set<ProgrammingSkills> programmingSkills, Set<ProjectRole> projectRole) {
        ProgrammingSkills = programmingSkills;
        ProjectRole = projectRole;
    }

    public Set<ProgrammingSkills> getProgrammingSkills() {
        return ProgrammingSkills;
    }

    public Set<ProjectRole> getProjectRole() {
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
