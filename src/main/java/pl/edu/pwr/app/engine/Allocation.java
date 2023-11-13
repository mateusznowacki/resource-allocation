package pl.edu.pwr.app.engine;

import pl.edu.pwr.app.io.ResultPrinter;

public class Allocation {

    private CurrentState currentState;

    public void setCurrentState(CurrentState currentState) {
        this.currentState = CurrentState.getInstance();
    }

    public void runAllocation() {
        AllocationAlgorithm allocationAlgorithm = new AllocationAlgorithm();
        ResultPrinter printer = new ResultPrinter();

        allocationAlgorithm.AssignEmployeeBySkill(currentState);
        printer.printAllResults(currentState);

        currentState.restoreLists();

        allocationAlgorithm.AssignEmployeeByRole(currentState);
        printer.printAllResults(currentState);

        printer.printSummary(currentState);
    }
}

