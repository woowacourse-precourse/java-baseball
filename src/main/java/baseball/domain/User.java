package baseball.domain;

import static baseball.exception.Exception.validateInputNumber;
import static baseball.exception.Exception.validateInputRestart;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    private baseballGame baseballGame;
    private String number;
    private int restart;

    public User() {
        baseballGame = null;
    }

    public void startBaseballGame() {
        baseballGame = new baseballGame();
        baseballGame.createRandomNumber();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (restart != 2) {
            System.out.print("숫자를 입력해주세요 : ");
            baseballGame.initCounts();
            inputNumber();
            baseballGame.checkMatch(number);
            baseballGame.getGameResult(this);
        }
    }

    public void inputNumber() {
        number = readLine();
        validateInputNumber(number);
    }

    public void inputRestart() {
        restart = Integer.parseInt(readLine());
        validateInputRestart(Integer.toString(restart));
        if (restart != 1 && restart != 2) {
            throw new IllegalArgumentException("1(재시작) 또는 2(종료)를 입력해주세요.");
        }
    }

    public int getRestart() {
        return restart;
    }
}
