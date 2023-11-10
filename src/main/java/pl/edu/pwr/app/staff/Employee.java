package pl.edu.pwr.app.staff;

import pl.edu.pwr.app.engine.CurrentState;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Employee {

    private int employeeID;
    private int projectsSkillCount = 0;
    private int projectsRoleCount = 0;
    
    private HashMap<String, Integer> programmingSkills;
    private HashMap<String, Integer> projectRole;

    public int getProjectsSkillCount() {
        return projectsSkillCount;
    }

    public void setProjectsSkillCount(int projectsSkillCount) {
        this.projectsSkillCount = projectsSkillCount;
    }

    public int getProjectsRoleCount() {
        return projectsRoleCount;
    }

    public void setProjectsRoleCount(int projectsRoleCount) {
        this.projectsRoleCount = projectsRoleCount;
    }

    public Employee(HashMap<String, Integer> programmingSkills, HashMap<String, Integer> projectRole, int employeeID) {
        this.programmingSkills = programmingSkills;
        this.projectRole = projectRole;
        this.employeeID = employeeID;
    }

    public static CurrentState useEmployee(Employee employee, String skill) {
        CurrentState currentState = CurrentState.getInstance();
        HashMap<String, Integer> programmingSkills = employee.getProgrammingSkills();
        HashMap<String, Integer> projectRole = employee.getProjectRole();

        if ((skill.equals("QA") || skill.equals("PM") || skill.equals("ScrumMaster")) && (employee.getProjectRole().get(skill) <2) ) {
            for (Map.Entry<String, Integer> entry : projectRole.entrySet()) {
                String currentRole = entry.getKey();
                Integer roleCount = entry.getValue();

                if (currentRole != null && currentRole.equals(skill)) {
                    projectRole.put(skill, roleCount + 1);
                    employee.projectsSkillCount++;
                }
            }
        } else {
            for (Map.Entry<String, Integer> entry : programmingSkills.entrySet()) {
                String currentSkill = entry.getKey();
                Integer skillCount = entry.getValue();

                if (currentSkill != null && currentSkill.equals(skill) && (employee.getProgrammingSkills().get(skill)<1) ) {
                    programmingSkills.put(skill, skillCount + 1);
                    employee.projectsRoleCount++;
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
        return programmingSkills;
    }

    public HashMap<String, Integer> getProjectRole() {
        return projectRole;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", ProgrammingSkills=" + programmingSkills +
                ", ProjectRole=" + projectRole +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!Objects.equals(projectRole, employee.projectRole))
            return false;
        return Objects.equals(programmingSkills, employee.programmingSkills);
    }

    @Override
    public int hashCode() {
        int result = projectRole != null ? projectRole.hashCode() : 0;
        result = 31 * result + (programmingSkills != null ? programmingSkills.hashCode() : 0);
        return result;
    }
}
