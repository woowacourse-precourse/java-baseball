package baseball;

import camp.nextstep.edu.missionutils.Console;
import constant.Messages;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean isFinish = false;
        while (!isFinish) {
            BaseBall baseBall = new BaseBall();
            baseBall.playGame();
            isFinish = isFinishOrResume();
        }
    }

    private static boolean isFinishOrResume() {
        System.out.println(Messages.restartOrFinish);

        int input = Integer.parseInt(Console.readLine());
        if(!checkInput(input)) throw new IllegalArgumentException(Messages.wrongAnswer);

        if (input == 2) {
            System.out.println(Messages.finishGame);
            return false;
        }
        return true;
    }

    private static boolean checkInput(int input) {
        if(input == 1 || input == 2) return true;
        return false;
    }
}
