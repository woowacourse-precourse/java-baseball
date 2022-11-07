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

    public Computer getComputer() {
        return computer;
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

    public int isEqualToComputerNumber() {
        if (computer.getFirstRandomNumber() != Character.getNumericValue(userNumber.charAt(0))) {
            return 0;
        }
        if (computer.getSecondRandomNumber() != Character.getNumericValue(userNumber.charAt(1))) {
            return 0;
        }
        if (computer.getThirdRandomNumber() != Character.getNumericValue(userNumber.charAt(2))) {
            return 0;
        }
        return 1;
    }
}
