package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    public final static String START_NOTIFICATION = "숫자 야구 게임을 시작합니다.";
    public final static String END_NOTIFICATION = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public final static String RESTART_NOTIFICATION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public final static String BALL = "볼";
    public final static String STRIKE = "스트라이크";
    public final static String NOTHING = "낫싱";

    Computer computer = new Computer();
    Player player = new Player();
    Strike strike = new Strike();
    Ball ball = new Ball();

    public void start() {
        System.out.println(START_NOTIFICATION);
        repeatUntilAnswerCorrect();
        System.out.println(END_NOTIFICATION);
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
                System.out.println(NOTHING);
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
            System.out.println(ballCount + BALL);
        }
        if (ballCount == 0) {
            System.out.println(strikeCount + STRIKE);
        }
        if (strikeCount != 0 && ballCount != 0) {
            System.out.println(ballCount + BALL + " " + strikeCount + STRIKE);
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
        System.out.println(RESTART_NOTIFICATION);
        input = Integer.parseInt(Console.readLine());

        if (input == 1) {
            repeatUntilAnswerCorrect();
            System.out.println(END_NOTIFICATION);
            selectRestartOrEndGame();
        }
        if (input == 2) {
            System.out.println("게임 종료");
            System.exit(0);
        }

        throw new IllegalArgumentException("잘못된 입력입니다.");
    }
}
