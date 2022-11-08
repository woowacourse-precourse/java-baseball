package baseball.DB;

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
        for (int index = 0; index < database.size(); index++) {
            System.out.print((index+1) + "번 째 시도 --> ");
            System.out.println(database.get(index));
        }
    }
}
