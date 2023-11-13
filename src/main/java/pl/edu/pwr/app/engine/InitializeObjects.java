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
        CurrentState currentState = CurrentState.getInstance();

        EmployeesFactory employeesFactory = new EmployeesFactory();
        ArrayList<Employee> employees = employeesFactory.getEmployees(getStaffData());
        ArrayList<Employee> employeesCopy = employeesFactory.getEmployees(getStaffData());
        currentState.setEmployees(employees);
        currentState.setEmployeesCopy(employeesCopy);

        ProjectsList projectsFactory = new ProjectsList();
        ArrayList<Project> projects = projectsFactory.getProjectsList(getProjectData());
        ArrayList<Project> projectsCopy = projectsFactory.getProjectsList(getProjectData());
        currentState.setProjects(projects);
        currentState.setProjectsCopy(projectsCopy);
        currentState.setNumberOfSkillsRequired(projects.stream().filter(project -> !project.getProgrammingSkills().equals("NONE")).count());
        currentState.setNumberOfRolesRequired(projects.stream().filter(project -> !project.getProjectRoles().equals("NONE")).count());

        return currentState;
    }
}
