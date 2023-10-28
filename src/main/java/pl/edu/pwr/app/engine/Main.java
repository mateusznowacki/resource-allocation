package pl.edu.pwr.app.engine;

import pl.edu.pwr.app.staff.EmployeesFactory;
import pl.edu.pwr.filereader.FileParser;

import java.util.List;
import java.util.Map;

import static pl.edu.pwr.filereader.FileParser.*;

public class Main {
    public static void main(String[] args) {
      //  System.out.println(getStaffData("src/main/resources/database.txt"));

       System.out.println(EmployeesFactory.getEmployees(getStaffData("src/main/resources/database.txt")));

    }
}