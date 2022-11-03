package baseball.repository;

import java.util.List;

public class GameStartRepository {
    public static List<String> lastUserNumberList;

    public static void save(List<String> userNumberList){
        lastUserNumberList = userNumberList;
    }
}
