package baseball;

import java.util.ArrayList;
import java.util.List;

public class GameHandler {
    public static List<Integer> computerNumber;
    public static List<Integer> compareResult;

    public void init() {
        computerNumber = new ArrayList<>();
        compareResult = new ArrayList<>();
    }
}
