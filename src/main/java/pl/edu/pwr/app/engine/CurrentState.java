package pl.edu.pwr.app.engine;

import pl.edu.pwr.app.project.Project;
import pl.edu.pwr.app.staff.Employee;

import java.util.ArrayList;
import java.util.HashMap;

public class CurrentState {
    private static CurrentState instance = null;
    private ArrayList<Employee> employees;
    private ArrayList<Project> projects;
    private HashMap<String, String> assigned = new HashMap<>();
    private int iterationNumber;
    private double objectiveFunctionValue;

    private CurrentState() {

    }

    public static CurrentState getInstance() {
        if (instance == null) {
            instance = new CurrentState();
        }
        return instance;
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

    public double getObjectiveFunctionValue() {
        return objectiveFunctionValue;
    }

    public void setObjectiveFunctionValue(double objectiveFunctionValue) {
        this.objectiveFunctionValue = objectiveFunctionValue;
    }
}


