package pl.edu.pwr.app.engine;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import pl.edu.pwr.app.project.Project;
import pl.edu.pwr.app.staff.Employee;

import java.util.ArrayList;
import java.util.HashMap;

import static pl.edu.pwr.app.project.Project.removeAssignedRolesAndSkills;
import static pl.edu.pwr.app.staff.Employee.useEmployeeSkills;

public class AllocationAlgorithm {

    public void AssignEmployeeToProject(CurrentState currentState) {
        Table<Integer, String, String> allocatedStaff = HashBasedTable.create();
        ArrayList<Employee> employees = currentState.getEmployees();
        ArrayList<Project> projects = currentState.getProjects();

        for (Project project : projects) {
            ArrayList<String> projectSkills = project.getProgrammingSkills();
            ArrayList<String> projectRoles = project.getProjectRoles();

            for (Employee employee : employees) {
                HashMap<String, Integer> programmingSkills = employee.getProgrammingSkills();
                HashMap<String, Integer> projectRole = employee.getProjectRole();

                // Sprawdź, czy jakiekolwiek umiejętności projektu są obecne w umiejętnościach pracownika
                for (String skill : projectSkills) {
                    if (programmingSkills.containsKey(skill)) {
                        useEmployeeSkills(employee, skill);
                        removeAssignedRolesAndSkills(project, skill);
                    }
                }
                // Sprawdź, czy jakiekolwiek role projektu są obecne w rolach pracownika
                for (String role : projectRoles) {
                    if (projectRole.containsKey(role)) {
                        useEmployeeSkills(employee, role);
                        removeAssignedRolesAndSkills(project, role);
                    }
                }
            }
        }

        System.out.println("---------------------------------");

        //System.out.println(currentState.getProjects());
        System.out.println(currentState.getEmployees());

    }
}









