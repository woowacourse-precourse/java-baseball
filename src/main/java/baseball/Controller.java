package baseball;

import baseball.Game.BaseballSystem;
import baseball.Game.Number;
import baseball.Game.User;

import baseball.Game.Vaildate;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
    final int NUM_LEN = 3;
    final int MIN_NUM = 1;
    final int MAX_NUM = 9;

    Vaildate vaildate = new Vaildate();
    BaseballSystem baseballSystem = new BaseballSystem();
    User user = new User();

    public int[] sysNum;

    public void run() {
        setGame();
        startGame();
    }

    private void setGame() {
        sysNum = Number.getRandomNum(NUM_LEN, MIN_NUM, MAX_NUM);
    }

    private void startGame() {
        System.out.println(sysNum[0] + "" + sysNum[1] + "" + sysNum[2]);

        int strike = 0;

        do {
            System.out.print("숫자 야구 게임을 시작합니다.");
        } while (strike != 3) ; {
            int userNum [] = getUserInput();
            int[] scoreTable = baseballSystem.score(sysNum, userNum, NUM_LEN);
            user.UserOutput(scoreTable[0], scoreTable[1]);
            strike = scoreTable[1];
        }

        user.correctAnsMsg();
        user.retryMsg();
        String input = Console.readLine();

        int inputNum = Integer.parseInt(input);
        if (inputNum == 0 || inputNum > 2) {
            throw new IllegalArgumentException();
        }

        if (inputNum == 1) {
            run();
        }

    }

    private int[] getUserInput() {
        User.UserInput();
        String input = Console.readLine();
        int inputNum[] = vaildate.userInputVaildate(input);

        return inputNum;
    }

}
