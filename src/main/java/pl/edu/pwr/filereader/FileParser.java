package pl.edu.pwr.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileParser {

//        public static String getProjectsData(String databasePath) {
//            try {
//                BufferedReader reader = new BufferedReader(new FileReader(databasePath));
//                StringBuilder projectsData = new StringBuilder();
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    projectsData.append(line).append("\n");
//                }
//                reader.close();
//                return projectsData.toString();
//            } catch (IOException e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//
    public static HashMap<Integer, ArrayList<String>> getStaffData(String databasePath) {
        HashMap<Integer, ArrayList<String>> staffData = new HashMap<>();
        staffData.put(1, new ArrayList<String>());
       // staffData.get(1).add("Java");
        staffData.get(1).add("PHP");
        staffData.put(2, new ArrayList<String>());
        staffData.get(2).add("Java");
        staffData.get(2).add("PHP");

        staffData.put(3, new ArrayList<String>());

        staffData.get(3).add("pm");


//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(databasePath));
//            String line;
//            int index = -1;
//            while ((line = reader.readLine()) != null) {
//                if (line.startsWith("R")) {
//                    index = Integer.parseInt(line.substring(1)); // Numer pracownika
//                    staffData.put(index, new ArrayList<>());
//
//                    String[] skills = line.split(","); // Umiejętności oddzielone
//                    for (String skill : skills) {
//                        staffData.get(index).add(skill);
//                    }
//                }
//
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(staffData);
        return staffData;
    }
    }
