package pl.edu.pwr.app.engine;

import pl.edu.pwr.app.project.Project;
import pl.edu.pwr.app.staff.Employee;

import java.util.ArrayList;

public class CurrentState {

    private ArrayList<Employee> employees;
    private ArrayList<Project> projects;
    private int iterationNumber;

    public CurrentState() {
    }

    public CurrentState(ArrayList<Employee> employees, ArrayList<Project> projects) {
        this.employees = employees;
        this.projects = projects;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public int getIterationNumber() {
        return iterationNumber;
    }

    public void setIterationNumber(int iterationNumber) {
        this.iterationNumber = iterationNumber;
    }
}
