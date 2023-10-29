package pl.edu.pwr.app.engine;

public class Main {
    public static void main(String[] args) {

        Allocation allocation = new Allocation();
        InitializeObjects initializeObjects = new InitializeObjects();
        allocation.setCurrentState(initializeObjects.initAllObjects());
        allocation.runAllocation();

    }
}