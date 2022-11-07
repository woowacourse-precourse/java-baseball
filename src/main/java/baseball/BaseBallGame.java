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

    public void countStrikeCount() {
        this.strikeCount = 0;
        if (computer.getFirstRandomNumber() == Character.getNumericValue(userNumber.charAt(0))) {
            this.strikeCount += 1;
        }
        if (computer.getSecondRandomNumber() == Character.getNumericValue(userNumber.charAt(1))) {
            this.strikeCount += 1;
        }
        if (computer.getThirdRandomNumber() == Character.getNumericValue(userNumber.charAt(2))) {
            this.strikeCount += 1;
        }
    }

    public void countBallCount() {
        this.ballCount = 0;
        if (computer.getFirstRandomNumber() == Character.getNumericValue(userNumber.charAt(1)) ||
                computer.getFirstRandomNumber() == Character.getNumericValue(userNumber.charAt(2))) {
            this.ballCount += 1;
        }
        if (computer.getSecondRandomNumber() == Character.getNumericValue(userNumber.charAt(0)) ||
                computer.getSecondRandomNumber() == Character.getNumericValue(userNumber.charAt(2))) {
            this.ballCount += 1;
        }
        if (computer.getThirdRandomNumber() == Character.getNumericValue(userNumber.charAt(0)) ||
                computer.getThirdRandomNumber() == Character.getNumericValue(userNumber.charAt(1))) {
            this.ballCount += 1;
        }
    }

    public void printCount() {
        if (strikeCount != 0 && ballCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
        if (strikeCount == 0 && ballCount != 0) {
            System.out.println(ballCount + "볼");
        }
        if (strikeCount != 0 && ballCount == 0) {
            System.out.println(strikeCount+ "스트라이크");
        }
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }
    }

    public void setRestartToken() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        restartToken = Console.readLine();
    }

    public void play() {
        computer.setRandomNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            inputUserNumber();
            int isEqual = isEqualToComputerNumber();
            if (isEqual == 1) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            countStrikeCount();
            countBallCount();
            printCount();
        }
        setRestartToken();
        if (restartToken == "1") {
            play();
        }
    }


}
