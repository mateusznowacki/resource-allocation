package pl.edu.pwr.app.staff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class EmployeesFactory {

    public ArrayList<Employee> getEmployees(HashMap<Integer, ArrayList<String>> staffData) {
        ArrayList<Employee> employees = new ArrayList<>();

        for (ArrayList<String> employeeData : staffData.values()) {
            HashSet<String> programmingSkills = new HashSet<>();
            HashSet<String> projectRoles = new HashSet<>();

            for (String data : employeeData) {
                if (data.contains("PM") || data.contains("QA") || data.contains("ScrumMaster")) {
                    projectRoles.add(data);
                } else {
                    programmingSkills.add(data);
                }
            }
            if(projectRoles.isEmpty()){
                projectRoles.add("NONE");
            }
            else if (programmingSkills.isEmpty()){
                programmingSkills.add("NONE");
            }


            employees.add(new Employee(programmingSkills, projectRoles));
        }



        return employees;
    }

}
