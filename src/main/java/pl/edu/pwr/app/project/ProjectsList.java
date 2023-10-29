package pl.edu.pwr.app.project;

import pl.edu.pwr.app.staff.ProgrammingSkills;
import pl.edu.pwr.app.staff.ProjectRole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProjectsList {

    public ArrayList<Project> getProjectsList(HashMap<Integer, ArrayList<String>> projectsData) {
        ArrayList<Project> projects = new ArrayList<>();

        for (Map.Entry<Integer, ArrayList<String>> staff : projectsData.entrySet()) {
            ArrayList<String> projectRequirements = staff.getValue();
            ArrayList<ProgrammingSkills> programmingSkills = new ArrayList<>();
            ArrayList<ProjectRole> projectRoles = new ArrayList<>();

            for (int i = 0; i < projectRequirements.size(); i++) {
                for (int j = 0; j < ProgrammingSkills.values().length; j++) {
                    if (projectRequirements.get(i).equalsIgnoreCase(String.valueOf(ProgrammingSkills.values()[j]))) {
                        programmingSkills.add(ProgrammingSkills.values()[j]);
                    }
                }
                for (int k = 0; k < ProjectRole.values().length; k++) {
                    if (projectRequirements.get(i).equalsIgnoreCase(String.valueOf(ProjectRole.values()[k]))) {
                        projectRoles.add(ProjectRole.values()[k]);
                    }
                }
            }
            if (programmingSkills.isEmpty()) {
                programmingSkills.add(ProgrammingSkills.NONE);
            } else if (projectRoles.isEmpty()) {
                projectRoles.add(ProjectRole.NONE);
            }
            projects.add(new Project(programmingSkills, projectRoles));
        }
        return projects;
    }



}
