package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    public static void startGame() {
        String answerNumber = "";
        for (int i = 0; i < 3; i++) {
            answerNumber += Integer.toString(pickNumberInRange(1, 9));
        }
        do {
            System.out.println("숫자를 입력해주세요: ");
            String getNumber = readLine();
        } while (true);
    }
}
