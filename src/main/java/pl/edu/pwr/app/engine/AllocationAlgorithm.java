package pl.edu.pwr.app.engine;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import pl.edu.pwr.app.project.Project;
import pl.edu.pwr.app.staff.Employee;

import java.util.ArrayList;

public class AllocationAlgorithm {

    public void AssignEmployeeToProject(CurrentState currentState) {
        Table<Integer, String, String> allocatedStaff = HashBasedTable.create();
        ArrayList<Employee> employees = currentState.getEmployees();
        ArrayList<Project> projects = currentState.getProjects();

        for (int i = 0; i < projects.size(); i++) {
            for (int j = 0; j < employees.size(); j++) {
                if(projects.get(i).)

            }

        }





        System.out.println("---------------------------------");
        System.out.println(currentState.getEmployees());








    }


}









