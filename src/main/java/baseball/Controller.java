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
    public int[] sysNum;

    public void run() {
        setGame();
        startGame();
        endGame();
    }

    private void setGame() {
        sysNum = Number.getRandomNum(NUM_LEN, MIN_NUM, MAX_NUM);
    }

    private void startGame() {
        System.out.println(sysNum[0] + "" + sysNum[1] + "" + sysNum[2]);
        int userNum [] = getUserInput();

        int[] scoreTable = baseballSystem.score(sysNum, userNum, 3);
        System.out.println(scoreTable[0] + "볼 " + scoreTable[1] + "스트라이크");

    }

    private void endGame() {

    }

    private int[] getUserInput() {
        User.UserInput();
        String input = Console.readLine();
        int inputNum[] = vaildate.userInputVaildate(input);

        return inputNum;
    }

}
