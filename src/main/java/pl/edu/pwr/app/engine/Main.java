package pl.edu.pwr.app.engine;

import pl.edu.pwr.app.staff.EmployeesFactory;
import pl.edu.pwr.filereader.FileParser;

import java.util.List;
import java.util.Map;

import static pl.edu.pwr.filereader.FileParser.*;
import static pl.edu.pwr.filereader.PathManager.getDatabasePath;

public class Main {
    public static void main(String[] args) {

        EmployeesFactory employeesFactory = new EmployeesFactory();
       System.out.println(employeesFactory.getEmployees(getStaffData(getDatabasePath())));
        System.out.println(getProjectData(getDatabasePath()));

    }
}