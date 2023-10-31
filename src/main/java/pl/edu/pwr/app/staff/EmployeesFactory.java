package pl.edu.pwr.app.staff;

import java.util.ArrayList;
import java.util.HashMap;

public class EmployeesFactory {

    public ArrayList<Employee> getEmployees(HashMap<Integer, ArrayList<String>> staffData) {
        ArrayList<Employee> employees = new ArrayList<>();

        for (ArrayList<String> employeeData : staffData.values()) {
            ArrayList<String> programmingSkills = new ArrayList<>();
            ArrayList<String> projectRoles = new ArrayList<>();

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
