package pl.edu.pwr.app.project;

import java.util.ArrayList;
import java.util.Objects;

public class Project {

    private ArrayList<String> programmingSkills;

    private ArrayList<String> projectRoles;

    public Project(ArrayList<String> programmingSkills, ArrayList<String> projectRole) {
        this.programmingSkills = programmingSkills;
        projectRoles = projectRole;
    }

    public ArrayList<String> getProgrammingSkills() {
        return programmingSkills;
    }

    public ArrayList<String> getProjectRoles() {
        return projectRoles;
    }

    @Override
    public String toString() {
        return "Project{" +
                "ProgrammingRequirements=" + programmingSkills +
                ", ProjectRole=" + projectRoles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(programmingSkills, project.programmingSkills) && Objects.equals(projectRoles, project.projectRoles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(programmingSkills, projectRoles);
    }
}
