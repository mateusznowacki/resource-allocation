package pl.edu.pwr.app.staff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class EmployeesFactory {

    public static ArrayList<Employee> getEmployees(HashMap<Integer, ArrayList<String>> staffData) {
        ArrayList<Employee> employees = new ArrayList<>();

        for (Map.Entry<Integer, ArrayList<String>> staff : staffData.entrySet()) {
            ArrayList<String> employeeData = staff.getValue();
            HashSet<ProgrammingSkills> programmingSkills = new HashSet<>();
            HashSet<ProjectRole> projectRoles = new HashSet<>();

            for (int i = 0; i < employeeData.size(); i++) {
                for (int j = 0; j < ProgrammingSkills.values().length; j++) {
                    if (employeeData.get(i).equalsIgnoreCase(String.valueOf(ProgrammingSkills.values()[j]))) {
                        programmingSkills.add(ProgrammingSkills.values()[j]);
                    } else if (programmingSkills.isEmpty() && j == ProgrammingSkills.values().length - 1) {
                        programmingSkills.add(ProgrammingSkills.NONE);
                    }
                }
                for (int k = 0; k < ProjectRole.values().length; k++) {
                    if (employeeData.get(i).equalsIgnoreCase(String.valueOf(ProjectRole.values()[k]))) {
                        projectRoles.add(ProjectRole.values()[k]);
                    } else if (projectRoles.isEmpty() && k == ProjectRole.values().length - 1) {
                        projectRoles.add(ProjectRole.NONE);
                    }
                }
            }
            employees.add(new Employee(programmingSkills, projectRoles));
        }

        return employees;
    }

}
