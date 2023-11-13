package pl.edu.pwr.app.engine;

import pl.edu.pwr.app.project.Project;
import pl.edu.pwr.app.staff.Employee;

import java.util.ArrayList;
import java.util.HashMap;

import static pl.edu.pwr.app.project.Project.removeAssignedRolesAndSkills;
import static pl.edu.pwr.app.staff.Employee.useEmployee;

public class AllocationAlgorithm {

    public void AssignEmployeeBySkill(CurrentState currentState) {
        ArrayList<String> allocatedStaff = new ArrayList<>();
        ArrayList<Employee> employees = currentState.getEmployees();
        ArrayList<Project> projects = currentState.getProjects();

        for (Employee employee : employees) {
            HashMap<String, Integer> programmingSkills = employee.getProgrammingSkills();
            HashMap<String, Integer> projectRole = employee.getProjectRole();

            for (Project project : projects) {
                ArrayList<String> projectSkills = project.getProgrammingSkills();
                ArrayList<String> projectRoles = project.getProjectRoles();

                for (String skill : projectSkills) {
                    if (programmingSkills.containsKey(skill)
                            && employee.getUsedSkillsCount() < 1
                            && employee.getUsedRolesCount() == 0
                            && !skill.equals("NONE")) {
                        useEmployee(employee, skill);
                        removeAssignedRolesAndSkills(project, skill);
                        allocatedStaff.add(project.getProjectID() + "," + skill);
                    }
                }

                for (String role : projectRoles) {
                    if (projectRole.containsKey(role)
                            && employee.getUsedSkillsCount() == 0
                            && employee.getUsedRolesCount() < 2
                            && !role.equals("NONE")) {
                        useEmployee(employee, role);
                        removeAssignedRolesAndSkills(project, role);
                        allocatedStaff.add(project.getProjectID() + "," + role);
                    }
                }
            }
        }
        currentState.setAllocatedStaff(allocatedStaff);
    }

    public void AssignEmployeeByRole(CurrentState currentState) {
        ArrayList<String> allocatedStaff = new ArrayList<>();
        ArrayList<Employee> employees = currentState.getEmployees();
        ArrayList<Project> projects = currentState.getProjects();

        for (Employee employee : employees) {
            HashMap<String, Integer> programmingSkills = employee.getProgrammingSkills();
            HashMap<String, Integer> projectRole = employee.getProjectRole();

            for (Project project : projects) {
                ArrayList<String> projectSkills = project.getProgrammingSkills();
                ArrayList<String> projectRoles = project.getProjectRoles();

                for (String role : projectRoles) {
                    if (projectRole.containsKey(role)
                            && employee.getUsedSkillsCount() == 0
                            && employee.getUsedRolesCount() < 2
                            && !role.equals("NONE")) {
                        useEmployee(employee, role);
                        removeAssignedRolesAndSkills(project, role);
                        allocatedStaff.add(project.getProjectID() + "," + role);
                    }
                }

                for (String skill : projectSkills) {
                    if (programmingSkills.containsKey(skill)
                            && employee.getUsedSkillsCount() < 1
                            && employee.getUsedRolesCount() == 0
                            && !skill.equals("NONE")) {
                        useEmployee(employee, skill);
                        removeAssignedRolesAndSkills(project, skill);
                        allocatedStaff.add(project.getProjectID() + "," + skill);
                    }
                }
            }
        }
        currentState.setAllocatedStaff(allocatedStaff);
    }
}









