package baseball.service;

import baseball.domain.Computer;
import baseball.domain.User;
import camp.nextstep.edu.missionutils.Console;

public class UserService {

    private final User user = new User();
    private final Computer computer = new Computer();
    private String userBaseballNumber;
    private String userRestartNumber;

    public void initGame() {
        computer.setAnswer();
    }

    public void inputBaseballNumber() {
        userBaseballNumber = Console.readLine();

        checkBaseballNumber();

        user.setBaseballNumber(userBaseballNumber);
    }

    public String getBaseballNumber() {
        return user.getBaseballNumber();
    }

    public String getAnswer() {
        return computer.getAnswer();
    }

    public void inputRestartNumber() {
        userRestartNumber = Console.readLine();

        checkRestartNumber();

        user.setUserRestartNumber(userRestartNumber);
    }

    public String getRestartNumber() {
        return user.getRestartNumber();
    }


    public String getCheckResult() {
        StringBuilder returnResultBuilder = new StringBuilder();
        String returnResult = "";
        int ballCount = 0;
        int strikeCount = 0;

        if (checkNothing()) {
            returnResult = "낫싱";
            return returnResult;
        }

        ballCount = checkBallStrike("ball");
        strikeCount = checkBallStrike("strike");

        if (ballCount != 0) {
            returnResultBuilder.append(ballCount + "볼 ");
        }
        if (strikeCount != 0) {
            returnResultBuilder.append(strikeCount + "스트라이크");
        }

        returnResult = returnResultBuilder.toString();

        return returnResult;

    }

    private boolean checkNothing() {
        String answer;
        String baseballNumber;
        boolean returnNothingStatus = true;

        answer = getAnswer();
        baseballNumber = getBaseballNumber();

        for (int i = 0; i < answer.length(); i++) {
            for (int j = 0; j < baseballNumber.length(); j++) {
                if (answer.charAt(i) == baseballNumber.charAt(j)) {
                    returnNothingStatus = false;
                }
            }
        }

        return returnNothingStatus;
    }

    private Integer checkBallStrike(String status) {
        String answer;
        String baseballNumber;
        int gameCount = 0;

        answer = getAnswer();
        baseballNumber = getBaseballNumber();

        for (int i = 0; i < answer.length(); i++) {
            for (int j = 0; j < baseballNumber.length(); j++) {
                if (status.equals("strike") && i == j && answer.charAt(i) == baseballNumber.charAt(j)) {
                    gameCount += 1;
                }
                if (status.equals("ball") && i != j && answer.charAt(i) == baseballNumber.charAt(j)) {
                    gameCount += 1;
                }
            }
        }

        return gameCount;
    }


    private void checkRestartNumber() {
        if (!checkRestartLength() || !checkIsInteger(userRestartNumber)) {
            throw new IllegalArgumentException("에러발생 프로그램을 종료합니다.");
        }
    }

    private void checkBaseballNumber() {
        if (!checkNumberLength() || !checkIsInteger(userBaseballNumber)) {
            throw new IllegalArgumentException("에러발생 프로그램을 종료합니다.");
        }
    }

    private boolean checkRestartLength() {
        boolean returnCheckNumber = true;
        if (userRestartNumber.length() != 1) {
            returnCheckNumber = false;
        }
        return returnCheckNumber;
    }

    private boolean checkNumberLength() {
        boolean returnCheckNumber = true;
        if (userBaseballNumber.length() != 3) {
            returnCheckNumber = false;
        }
        return returnCheckNumber;
    }

    private boolean checkIsInteger(String userInputNumber) {
        boolean returnCheckNumber = true;
        char number;

        for (int i = 0; i < userInputNumber.length(); i++) {
            number = userInputNumber.charAt(i);

            if (!Character.isDigit(number)) {
                returnCheckNumber = false;
                break;
            }
        }

        return returnCheckNumber;
    }

}
