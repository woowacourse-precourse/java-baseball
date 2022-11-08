package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameManager {
    private final String START_GAME_ALERT = "숫자 야구 게임을 시작합니다.";
    private final String PUT_INPUT_ALERT = "숫자를 입력해주세요 : ";
    private final String GAME_END_ALERT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String AFTER_GAME_END_ALERT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private GameNumber oppositeNumber;

    public void runGame() {
        do {
            printStartGameAlert();
            oppositeNumber = GameNumber.getRandomInstance();

            repeatGetInputAndCompare();
        } while(getAndProcessRestartInput());
    }

    private void repeatGetInputAndCompare() {
        BallStrikeResult result;
        do {
            GameNumber inputNumber = getAndProcessGameNumberInput();
            result = inputNumber.countBallStrike(oppositeNumber);
            printBallStrikeResult(result);
        } while(!result.doesWin());
        printGameEndAlert();
    }

    private GameNumber getAndProcessGameNumberInput() {
        printInputNumberAlert();
        String inputString = Console.readLine();

        return GameNumber.getInstance(inputString);
    }

    private boolean getAndProcessRestartInput() throws IllegalArgumentException {
        printAfterGameEndAlert();
        String input = Console.readLine();

        if(input.equals("1")) {
            return true;
        } else if(input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    private void printBallStrikeResult(BallStrikeResult result) {
        System.out.println(result.toString());
    }

    private void printStartGameAlert() {
        System.out.println(START_GAME_ALERT);
    }

    private void printAfterGameEndAlert() {
        System.out.println(AFTER_GAME_END_ALERT);
    }

    private void printGameEndAlert() {
        System.out.println(GAME_END_ALERT);
    }

    private void printInputNumberAlert() {
        System.out.print(PUT_INPUT_ALERT);
    }
}
