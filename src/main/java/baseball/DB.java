package baseball;

import java.util.ArrayList;
import java.util.List;

public class DB {

    private static DB instance;
    private List<Data> database = new ArrayList<>();

    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }

    public void addData(Data data) {
        database.add(data);
    }

    public List<Data> getAllData() {
        return this.database;
    }

    public Data getData(Data data) {
        if(database.contains(data)) {
            return database.get(database.indexOf(data));
        }
        return null;
    }

    public void modifyData(Data existData, Data newData) {
        if(database.contains(existData)) {
            Data data = database.get(database.indexOf(existData));
            data.modifyTryData(newData.getTryDate());
            data.modifyTryCount(newData.getTryCount());
        }
    }

    public void removeData(Data data) {
        if (database.contains(data)) {
            database.remove(data);
        }
    }
}
