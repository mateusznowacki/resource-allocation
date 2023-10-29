package pl.edu.pwr.app.project;

import pl.edu.pwr.app.staff.ProgrammingSkills;
import pl.edu.pwr.app.staff.ProjectRole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public class Project {

    private final ArrayList<ProgrammingSkills> programmers;

    private final ArrayList<ProjectRole> projectRoles;

    public Project(ArrayList<ProgrammingSkills> programmingSkills, ArrayList<ProjectRole> projectRole) {
        programmers = programmingSkills;
        projectRoles = projectRole;
    }

    public ArrayList<ProgrammingSkills> getProgrammers() {
        return programmers;
    }

    public ArrayList<ProjectRole> getProjectRoles() {
        return projectRoles;
    }

    @Override
    public String toString() {
        return "Project{" +
                "ProgrammingRequirements=" + programmers +
                ", ProjectRole=" + projectRoles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(programmers, project.programmers) && Objects.equals(projectRoles, project.projectRoles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(programmers, projectRoles);
    }
}
