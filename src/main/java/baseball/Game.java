package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {
    private Computer computer;
    private User user;

    public Game(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        generateNumbers();
        while (true) {
            if (isGameOver()) {
                return;
            }
            user.setNumbers(inputUserNumbers());
        }

    }

    public String inputUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return input;
    }

    private void generateNumbers() {
        computer.generateRandomNumbers();
        user.setNumbers(inputUserNumbers());
    }

    private boolean isGameOver() {
        Score score = Score.getResult(computer.getNumbers(), user.getNumbers());
        if (score.checkThreeStrike()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}
