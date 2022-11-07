package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;


public class GamePlay {
    public static boolean restart = false;
    private Computer computer = new Computer();
    private User user = new User();

    public void playContinuous() {
        while (true) {
            System.out.print("숫자를 입력하세요: ");
            int[] guessNumbers = typingNumber();
            match(guessNumbers);
            if (restart && restartGame()) {
                break;
            }
        }
    }

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.generateNumber();
        playContinuous();
    }

    public int[] typingNumber() {
        return user.inputNumber();
    }

    public boolean restartGame() {
        boolean restartFlag = user.inputRestartNumber();
        if (!restartFlag) {
            computer.generateNumber();
        }
        return restartFlag;
    }

    public void match(int[] guessNumbers) {
        computer.compare(guessNumbers);

        if (computer.getStrikeCount() == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            restart = true;
        }

        computer.resetHint();
    }
}
