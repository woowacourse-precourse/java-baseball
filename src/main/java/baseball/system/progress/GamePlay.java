package baseball.system.progress;

import baseball.player.*;
import baseball.utils.Input;

public class GamePlay {
    private Computer computer;
    private User user;

    public GamePlay(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
    }

    public void playGame() {
        NumberComparison numberComparison = new NumberComparison(computer.getComputerNumbers());

        for (; ; ) {

            printInputText();

            InputThreeNumbers();

            if (numberComparison.startComparison(user.getUserNumbers())) {
                break;
            }
        }

        printGameEndText();
    }

    private void InputThreeNumbers(){
        String inputNumbers = Input.input();
        user.setUser(inputNumbers);
    }

    private void printInputText() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void printGameEndText() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
