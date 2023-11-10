package pl.edu.pwr.app.project;

import pl.edu.pwr.app.engine.CurrentState;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;


public class Project {

    private ArrayList<String> programmingSkills;

    private ArrayList<String> projectRoles;

    public Project(ArrayList<String> programmingSkills, ArrayList<String> projectRole) {
        this.programmingSkills = programmingSkills;
        projectRoles = projectRole;
    }


    public static CurrentState removeAssignedRolesAndSkills(Project project, String role) {
        CurrentState currentState = CurrentState.getInstance();
        ArrayList<String> programmingSkills = (ArrayList<String>) project.getProgrammingSkills().clone();
        ArrayList<String> projectRoles = (ArrayList<String>) project.getProjectRoles().clone();

        // Usuwanie z programmingSkills
        Iterator<String> programmingSkillsIterator = programmingSkills.iterator();
        while (programmingSkillsIterator.hasNext()) {
            String skill = programmingSkillsIterator.next();
            if (skill.equals(role)) {
                programmingSkillsIterator.remove();
            }
        }

        // Usuwanie z projectRoles
        Iterator<String> projectRolesIterator = projectRoles.iterator();
        while (projectRolesIterator.hasNext()) {
            String projectRole = projectRolesIterator.next();
            if (projectRole.equals(role)) {
                projectRolesIterator.remove();
            }
        }
        project.setProgrammingSkills(programmingSkills);
        project.setProjectRoles(projectRoles);

        return currentState;
    }


    public ArrayList<String> getProgrammingSkills() {
        return programmingSkills;
    }

    public void setProgrammingSkills(ArrayList<String> programmingSkills) {
        this.programmingSkills = programmingSkills;
    }

    public ArrayList<String> getProjectRoles() {
        return projectRoles;
    }

    public void setProjectRoles(ArrayList<String> projectRoles) {
        this.projectRoles = projectRoles;
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
