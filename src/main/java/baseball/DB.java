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

    public void showAllData() {
        for(int index = 0; index < database.size(); index++) {
            System.out.print((index+1) + "번 째 시도 --> ");
            System.out.println(database.get(index));
        }
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
