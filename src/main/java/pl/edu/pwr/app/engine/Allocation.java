package pl.edu.pwr.app.engine;

public class Allocation {

    private CurrentState currentState;

    public void setCurrentState(CurrentState currentState) {
        this.currentState = currentState;
    }

    public void runAllocation(){


        AllocationAlgorithm allocationAlgorithm = new AllocationAlgorithm();
        allocationAlgorithm.AssignEmployeeToProject(currentState);

    }
    public void printReults(){}


}

