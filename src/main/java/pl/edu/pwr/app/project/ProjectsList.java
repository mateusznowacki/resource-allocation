package pl.edu.pwr.app.project;


import java.util.ArrayList;
import java.util.HashMap;

public class ProjectsList {

    public ArrayList<Project> getProjectsList(HashMap<Integer, ArrayList<String>> projectsData) {
        ArrayList<Project> projects = new ArrayList<>();

        for (ArrayList<String> project : projectsData.values()) {
            ArrayList<String> programmingSkills = new ArrayList<>();
            ArrayList<String> projectRoles = new ArrayList<>();

            for (String data : project) {
                if (data.contains("PM") || data.contains("QA") || data.contains("ScrumMaster")) {
                    projectRoles.add(data);
                } else {
                    programmingSkills.add(data);
                }
            }
            if (projectRoles.isEmpty()) {
                projectRoles.add("NONE");
            } else if (programmingSkills.isEmpty()) {
                programmingSkills.add("NONE");
            }


            projects.add(new Project(programmingSkills, projectRoles));
        }
        return projects;
    }

}
