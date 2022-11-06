package baseball;

import java.util.List;

import static baseball.Computer.STRIKE;
import static baseball.Computer.getComputer;
import static baseball.Player.getPlayer;

public class GameManager {
    private static final int OVER = 2;
    private List<Integer> answer;
    private List<Integer> userInput;
    private boolean continuation = true;

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

    public void continueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int continueInput = getPlayer().inputContinuation();

        if(continueInput == OVER) {
            this.continuation = false;
            System.out.println("게임 종료");
        }
    }

    public boolean getContinuation() {
        return continuation;
    }
}
