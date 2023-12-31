package pl.edu.pwr.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FileParser {

    public static HashMap<Integer, ArrayList<String>> getStaffData() {
        HashMap<Integer, ArrayList<String>> staffData = new HashMap<>();
        String databasePath = PathManager.getInstance().getDatabasePath();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(databasePath));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("R")) {
                    String[] parts = line.split(": ");
                    if (parts.length == 2) {
                        int employeeNumber = Integer.parseInt(parts[0].substring(1));
                        String[] skills = parts[1].split(" ");
                        staffData.put(employeeNumber, new ArrayList<>(Arrays.asList(skills)));
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return staffData;
    }

    public static HashMap<Integer, ArrayList<String>> getProjectData() {
        HashMap<Integer, ArrayList<String>> projectsData = new HashMap<>();
        String databasePath = PathManager.getInstance().getDatabasePath();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(databasePath));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("P")) {
                    String[] parts = line.split(": ");
                    if (parts.length == 2) {
                        int employeeNumber = Integer.parseInt(parts[0].substring(1));
                        String[] skills = parts[1].split(" "); // Dzieli umiejętności oddzielone
                        projectsData.put(employeeNumber, new ArrayList<>(Arrays.asList(skills)));
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return projectsData;
    }


}
