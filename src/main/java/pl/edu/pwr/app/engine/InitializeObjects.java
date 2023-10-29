package pl.edu.pwr.app.engine;

import pl.edu.pwr.app.project.Project;
import pl.edu.pwr.app.project.ProjectsList;
import pl.edu.pwr.app.staff.Employee;
import pl.edu.pwr.app.staff.EmployeesFactory;

import java.util.ArrayList;

import static pl.edu.pwr.filereader.FileParser.getProjectData;
import static pl.edu.pwr.filereader.FileParser.getStaffData;

public class InitializeObjects {
    public CurrentState initAllObjects() {
        CurrentState currentState = new CurrentState();

        //tworzenie listy pracowników
        EmployeesFactory employeesFactory = new EmployeesFactory();
        ArrayList<Employee> employees = employeesFactory.getEmployees(getStaffData());
        currentState.setEmployees(employees);

        //tworzenie listy projektów
        ProjectsList projectsFactory = new ProjectsList();
        ArrayList<Project> projects = projectsFactory.getProjectsList(getProjectData());
        currentState.setProjects(projects);

        return currentState;
    }
}
