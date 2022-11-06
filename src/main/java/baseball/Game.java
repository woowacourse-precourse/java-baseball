package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    Computer computer = new Computer();
    Player player = new Player();
    Strike strike = new Strike();
    Ball ball = new Ball();

    public void start() {
        System.out.println(Message.START_NOTIFICATION);
        repeatUntilAnswerCorrect();
        System.out.println(Message.END_NOTIFICATION);
        selectRestartOrEndGame();
    }

    public boolean isContainAnyNumber() {
        Player player = new Player();
        for (int i = 0; i < 3; i++) {
            if (computer.randomNumberListToString()
                    .contains(player.splitInputNumberToList().get(i))) {
                return true;
            }
        }
        return false;
    }

    public void repeatUntilAnswerCorrect() {
        boolean isThreeStrike = false;
        computer.pickThreeNumbersRandomly();

        while (!isThreeStrike) {
            player.inputNumbers();
            if (isContainAnyNumber()) {
                printStrikeBall();
            }
            if (!isContainAnyNumber()) {
                System.out.println(Message.NOTHING);
            }
            isThreeStrike = isThreeStrike();
        }
    }

    public void printStrikeBall() {
        int strikeCount = getStrikeCount();
        int ballCount = ball.compareCharacterDifferentLocationMatch(
                InputNumber.number,
                computer.randomNumberListToString());

        if (strikeCount == 0) {
            System.out.println(ballCount + Message.BALL);
        }
        if (ballCount == 0) {
            System.out.println(strikeCount + Message.STRIKE);
        }
        if (strikeCount != 0 && ballCount != 0) {
            System.out.println(ballCount + Message.BALL + " " + strikeCount + Message.STRIKE);
        }
    }

    private int getStrikeCount() {
        int strikeCount = strike.compareCharacterLocationMatch(
                InputNumber.number,
                computer.randomNumberListToString());
        return strikeCount;
    }

    public boolean isThreeStrike() {
        int strikeCount = getStrikeCount();
        if (strikeCount == 3) {
            return true;
        }
        return false;
    }

    public void selectRestartOrEndGame() {
        int input;
        System.out.println(Message.RESTART_NOTIFICATION);
        input = Integer.parseInt(Console.readLine());

        if (input == 1) {
            repeatUntilAnswerCorrect();
            System.out.println(Message.END_NOTIFICATION);
            selectRestartOrEndGame();
        }
        if (input == 2) {
            System.out.println(Message.REAL_END_NOTIFICATION);
            System.exit(0);
        }

        throw new IllegalArgumentException("잘못된 입력입니다.");
    }
}
