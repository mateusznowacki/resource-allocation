package pl.edu.pwr.app.engine;

import pl.edu.pwr.app.project.Project;
import pl.edu.pwr.app.staff.Employee;

import java.util.ArrayList;
import java.util.HashMap;

public class AllocationAlgorithm {

    public void SequenceAssignEmployeeToProject(CurrentState currentState) {
        ArrayList<Employee> employees = currentState.getEmployees();
        ArrayList<Project> projects = currentState.getProjects();
        HashMap<Integer, String> employeeToProject = new HashMap<>();

        for (int i = 0; i < projects.size(); i++) {
            for (int j = 0; j < employees.size(); j++) {
               if (projects.get(i).equals(employees.get(j).getProgrammingSkills())){
                  employeeToProject.put(Integer.valueOf(i), String.valueOf(employees.get(j).getProgrammingSkills()));
                   employees.remove(j);
                   break;
               }

            }

        }

    }


}



