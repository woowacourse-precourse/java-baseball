package baseball;

import java.util.List;

public class Game {
    public static void start() {
        List<Integer> computerNumber = NumberGenerator.createNumbers();
        while (true) {
            List<Integer> userNumber = NumberScanner.getNumbers();
            String result = Referee.compare(computerNumber, userNumber);
            System.out.println(result);
            if (result.equals("3스트라이크")){
                break;
            }
        }
    }
}
