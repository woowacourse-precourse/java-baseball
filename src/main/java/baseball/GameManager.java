package baseball;

import java.util.List;

import static baseball.Computer.STRIKE;
import static baseball.Computer.getComputer;
import static baseball.Player.getPlayer;

public class GameManager {
    private List<Integer> answer;
    private List<Integer> userInput;

    public void startGame() {
        answer = getComputer().createRandomNumber();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            userInput = getPlayer().inputNumber();

            String result = getComputer().judgeNumber(answer, userInput);

            System.out.println(result);

            if (result.equals(STRIKE)) {
                break;
            }
        }
    }


}
