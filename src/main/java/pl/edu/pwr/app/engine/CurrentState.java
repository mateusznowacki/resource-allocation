package pl.edu.pwr.app.engine;

import pl.edu.pwr.app.project.Project;
import pl.edu.pwr.app.staff.Employee;

import java.util.ArrayList;

public class CurrentState {
    private static CurrentState instance = null;
    private ArrayList<Employee> employees;
    private ArrayList<Employee> employeesCopy;
    private ArrayList<Project> projects;
    private ArrayList<Project> projectsCopy;
    private ArrayList<String> allocatedStaff;
    private double numberOfSkillsRequired = 0;
    private double numberOfRolesRequired = 0;
    private final ArrayList<Double> objectiveFunctionValue = new ArrayList<>();

    public double calculateObjectiveFunctionValue() {
        double objFunctionValue = 0;
        double numberOfAssignedSkills = 0;
        double numberOfAssignedRoles = 0;

        for (Employee employee : employees) {
            if (employee.getUsedSkillsCount() > 0) {
                numberOfAssignedSkills += employee.getUsedSkillsCount();

            } else if (employee.getUsedRolesCount() > 0) {
                numberOfAssignedRoles += employee.getUsedRolesCount();
            }
        }
        if (numberOfSkillsRequired != 0 && numberOfRolesRequired != 0) {
            objFunctionValue = (numberOfAssignedSkills / numberOfSkillsRequired) + (numberOfAssignedRoles / numberOfRolesRequired);

        }
        objectiveFunctionValue.add(Double.valueOf(objFunctionValue));
        return objFunctionValue;
    }

    public void restoreLists() {
        this.employees = employeesCopy;
        this.projects = projectsCopy;
        this.allocatedStaff.clear();
    }

    private CurrentState() {

    }

    public static CurrentState getInstance() {
        if (instance == null) {
            instance = new CurrentState();
        }
        return instance;
    }


    public void setEmployeesCopy(ArrayList<Employee> employeesCopy) {
        this.employeesCopy = employeesCopy;
    }

    public void setProjectsCopy(ArrayList<Project> projectsCopy) {
        this.projectsCopy = projectsCopy;
    }

    public ArrayList<String> getAllocatedStaff() {
        return allocatedStaff;
    }

    public void setAllocatedStaff(ArrayList<String> allocatedStaff) {
        this.allocatedStaff = allocatedStaff;
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

    public ArrayList<Double> getObjectiveFunctionValue() {
        return objectiveFunctionValue;
    }

    public void setNumberOfSkillsRequired(double numberOfSkillsRequired) {
        this.numberOfSkillsRequired = numberOfSkillsRequired;
    }

    public void setNumberOfRolesRequired(double numberOfRolesRequired) {
        this.numberOfRolesRequired = numberOfRolesRequired;
    }
}


