package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
    private String userNumber;
    private Computer computer;
    private int ballCount;
    private int strikeCount;
    private String restartToken;

    public BaseBallGame() {
        computer = new Computer();
        ballCount = 0;
        strikeCount= 0;
        restartToken = "";
    }

    public String getUserNumber() {
        return userNumber;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public String getRestartToken() {
        return restartToken;
    }
    public void inputUserNumber() {
        userNumber = Console.readLine();
    }
}
