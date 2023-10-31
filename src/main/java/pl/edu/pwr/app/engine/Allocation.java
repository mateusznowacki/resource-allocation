package pl.edu.pwr.app.engine;

public class Allocation {

    private CurrentState currentState;

    public void setCurrentState(CurrentState currentState) {
        this.currentState = currentState;
    }

    public void runAllocation(){

        System.out.println(currentState.getEmployees());
        System.out.println("---------------------------------");
        System.out.println(currentState.getProjects());
        System.out.println("---------------------------------");

        AllocationAlgorithm allocationAlgorithm = new AllocationAlgorithm();
        allocationAlgorithm.SequenceAssignEmployeeToProject(currentState);
    }
    public void printReults(){}


}

