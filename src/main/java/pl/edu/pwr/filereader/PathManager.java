package pl.edu.pwr.filereader;

public class PathManager {

    public static PathManager instance = null;
    private String databasePath;

    private PathManager() {
    }

    public static PathManager getInstance() {
        if (instance == null) {
            instance = new PathManager();
        }
        return instance;
    }

    public String getDatabasePath() {
        return databasePath;
    }

    public void setDatabasePath(String databasePath) {
        this.databasePath = databasePath;
    }

}
