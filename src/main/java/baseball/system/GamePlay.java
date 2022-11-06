package baseball.system;

import baseball.player.*;
import baseball.utils.Input;

public class GamePlay {
    private Computer computer;
    private User user;

    GamePlay(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
    }

    public void playGame() {
        //TODO : 설명 적기
        NumberComparison numberComparison = new NumberComparison(computer.getComputerNumbers());

        for (; ; ) {

            printInputText();

            String inputNumbers = Input.input();
            user.setUser(inputNumbers);

            if (numberComparison.startComparison(user.getUserNumbers())) {
                break;
            }
        }

        printGameEndText();
    }

    private void printInputText() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void printGameEndText() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
