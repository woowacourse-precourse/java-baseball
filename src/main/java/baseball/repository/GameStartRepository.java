package baseball.repository;

import java.util.List;

public class GameStartRepository {
    public static List<String> lastUserNumberList;
    public static List<String> lastComputerNumberList;

    public static int strike = 0;

    public static int ball = 0;
    public static int nothing = 0;

    public static void saveUserNumber(List<String> userNumberList){
        lastUserNumberList = userNumberList;
    }

    public static void saveComputerNumber(List<String> computerNumberList) {
        lastComputerNumberList = computerNumberList;
    }
}
