package pl.edu.pwr.app.staff;

import pl.edu.pwr.app.engine.CurrentState;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Employee {

    private int employeeID;
    private HashMap<String, Integer> ProgrammingSkills;
    private HashMap<String, Integer> ProjectRole;

    public Employee(HashMap<String, Integer> programmingSkills, HashMap<String, Integer> projectRole, int employeeID) {
        this.ProgrammingSkills = programmingSkills;
        this.ProjectRole = projectRole;
        this.employeeID = employeeID;
    }

    public CurrentState useEmployeeSkills(Employee employee, String skill) {
        CurrentState currentState = CurrentState.getInstance();
        HashMap<String, Integer> programmingSkills = employee.getProgrammingSkills();
        HashMap<String, Integer> projectRole = employee.getProjectRole();

        if ((skill.equals("QA") || skill.equals("PM") || skill.equals("ScrumMaster")) && (employee.getProjectRole().get(skill) <2)) {
            for (Map.Entry<String, Integer> entry : projectRole.entrySet()) {
                String currentRole = entry.getKey();
                Integer roleCount = entry.getValue();

                if (currentRole != null && currentRole.equals(skill)) {
                    projectRole.put(skill, roleCount + 1);
                }
            }
        } else {
            for (Map.Entry<String, Integer> entry : programmingSkills.entrySet()) {
                String currentSkill = entry.getKey();
                Integer skillCount = entry.getValue();

                if (currentSkill != null && currentSkill.equals(skill)) {
                    programmingSkills.put(skill, skillCount + 1);
                }
            }
        }
        currentState.getEmployees().set(employee.employeeID, employee);

        return currentState;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public HashMap<String, Integer> getProgrammingSkills() {
        return ProgrammingSkills;
    }

    public HashMap<String, Integer> getProjectRole() {
        return ProjectRole;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", ProgrammingSkills=" + ProgrammingSkills +
                ", ProjectRole=" + ProjectRole +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!Objects.equals(ProjectRole, employee.ProjectRole))
            return false;
        return Objects.equals(ProgrammingSkills, employee.ProgrammingSkills);
    }

    @Override
    public int hashCode() {
        int result = ProjectRole != null ? ProjectRole.hashCode() : 0;
        result = 31 * result + (ProgrammingSkills != null ? ProgrammingSkills.hashCode() : 0);
        return result;
    }
}
