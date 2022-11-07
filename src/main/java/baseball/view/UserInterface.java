package baseball.view;

import baseball.controller.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class UserInterface {
    private static final String EXIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    public static final InputValidator validator = new InputValidator();

    public UserInterface() {
    }

    public int inputNumber() {
        System.out.print(INPUT_MESSAGE);
        String number = Console.readLine();
        if(validator.checkValidateNumber(number) == false) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(number);
    }

    public int checkGameRestart() {
        System.out.println(EXIT_MESSAGE);
        String number = Console.readLine();
        if(validator.checkValidateExit(number) == false) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(number);
    }

    public void printResult(int strikeCount, int ballCount) {
        if(strikeCount > 0 && ballCount > 0) {
            System.out.println(ballCount + BALL + " " + strikeCount + STRIKE);
        }
        if(strikeCount == 0 && ballCount > 0) {
            System.out.println(ballCount + BALL);
        }
        if(strikeCount > 0 && ballCount == 0) {
            System.out.println(strikeCount + STRIKE);
        }
        if(strikeCount == 0 && ballCount == 0) {
            System.out.println(NOTHING);
        }
    }
}
