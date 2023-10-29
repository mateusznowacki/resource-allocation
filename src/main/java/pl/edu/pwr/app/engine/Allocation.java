package pl.edu.pwr.app.engine;

public class Allocation {

    private CurrentState currentState;
    private int iterationNumber;

    public void setCurrentState(CurrentState currentState) {
        this.currentState = currentState;
    }

    public void runAllocation(){
        System.out.println(currentState.getEmployees());
        System.out.println("---------------------------------");
        System.out.println(currentState.getProjects());
    }
    public void printReults(){}


}

