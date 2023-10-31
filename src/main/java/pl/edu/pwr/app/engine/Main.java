package pl.edu.pwr.app.engine;

import pl.edu.pwr.filereader.PathManager;

public class Main {
    public static void main(String[] args) {

        PathManager databasePath = PathManager.getInstance();
        databasePath.setDatabasePath(args[0]);

        Allocation allocation = new Allocation();
        InitializeObjects initializeObjects = new InitializeObjects();
        allocation.setCurrentState(initializeObjects.initAllObjects());
        allocation.runAllocation();

    }
}