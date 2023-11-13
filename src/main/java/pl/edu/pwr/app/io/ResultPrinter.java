package pl.edu.pwr.app.io;

import pl.edu.pwr.app.engine.CurrentState;

import java.util.ArrayList;
import java.util.Collections;

public class ResultPrinter {

    public void printAllResults(CurrentState currentState) {
        printCurrentConfiguration(currentState);
        printObjectiveFunctionValue(currentState);
    }

    public void printCurrentConfiguration(CurrentState currentState) {
        ArrayList<String> allocatedStaff = currentState.getAllocatedStaff();
        Collections.sort(allocatedStaff);

        for (String s : allocatedStaff) {
            if (s.split(",").length >= 2) {
                String projectID = s.split(",")[0];
                String skill = s.split(",")[1];
                System.out.println(projectID + ":" + skill + "->" + skill);
            }
        }
    }

    public void printObjectiveFunctionValue(CurrentState currentState) {
        System.out.println("Wartosc funkcji celu (dopasowania): " + currentState.calculateObjectiveFunctionValue());
    }

    public void printSummary(CurrentState currentState) {
        if (currentState.getObjectiveFunctionValue().get(0) > currentState.getObjectiveFunctionValue().get(1)) {
            System.out.println("Pierwszy algorytm dopasowyujacy najpierw jezyki programowania a " +
                    "pozniej role uzyskal najwieksza wartosc funkcji celu: " + currentState.getObjectiveFunctionValue().get(0));
        } else if (currentState.getObjectiveFunctionValue().get(0) < currentState.getObjectiveFunctionValue().get(1)) {
            System.out.println("Drugi algorytm dopasowyujacy najpierw role a " +
                    "pozniej jezyki programowania uzyskal najwieksza wartosc funkcji celu: " + currentState.getObjectiveFunctionValue().get(1));
        } else {
            System.out.println("Oba algorytmy uzyskaly taka sama wartosc funkcji celu: " + currentState.getObjectiveFunctionValue().get(0));
        }
    }
}
