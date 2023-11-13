package pl.edu.pwr.app.staff;

import java.util.ArrayList;
import java.util.HashMap;

public class EmployeesFactory {

    public ArrayList<Employee> getEmployees(HashMap<Integer, ArrayList<String>> staffData) {
        ArrayList<Employee> employees = new ArrayList<>();
        int employeeID = 0;
        for (ArrayList<String> employeeData : staffData.values()) {

            HashMap<String, Integer> programmingSkills = new HashMap<>();
            HashMap<String, Integer> projectRoles = new HashMap<>();

            for (String data : employeeData) {
                if (data.contains("PM") || data.contains("QA")) {
                    projectRoles.put(data, Integer.valueOf(0));
                } else {
                    programmingSkills.put(data, Integer.valueOf(0));
                }
            }
            if (projectRoles.isEmpty()) {
                projectRoles.put("NONE", Integer.valueOf(0));
            } else if (programmingSkills.isEmpty()) {
                programmingSkills.put("NONE", Integer.valueOf(0));
            }

            employees.add(new Employee(programmingSkills, projectRoles, employeeID));
            employeeID++;
        }

        return employees;
    }
}
