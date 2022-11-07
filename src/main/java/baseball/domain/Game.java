package baseball.domain;

import baseball.validation.Validator;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static final int RESTART = 1;
    private static final int END = 2;
    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크 ";
    private static final String NOTHING = "낫싱";
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private Player player;
    private Computer computer;
    private Referee referee;

    public Game() {
        player = new Player();
        computer = new Computer();
        referee = new Referee();
    }

    public void start() {
        computer.createRandomNumber();
        System.out.println(START_MESSAGE);
        do {
            playGame();
            printScore();

        } while (!referee.countOut());
        System.out.println(CLEAR_MESSAGE);
        String restartOrEndInput = InputRestartOrEnd();
        if (Integer.parseInt(restartOrEndInput) == RESTART) {
            start();
        }
    }

    private void playGame() {
        System.out.print(INPUT_MESSAGE);
        String playerInput = Console.readLine();
        Validator.validatePlayerInput(playerInput);
        player.setPredictedValue(playerInput);
        referee.scoreStrikeAndBallCount(player.getPredictedValue(), computer.getAnswer());
    }

    private void printScore() {
        if (referee.getBall() == 0 && referee.getStrike() == 0) {
            System.out.println(NOTHING);
            return;
        }
        if (referee.getBall() > 0) {
            System.out.printf(referee.getBall() + BALL);
        }
        if (referee.getStrike() > 0) {
            System.out.printf(referee.getStrike() + STRIKE);
        }
        System.out.println();
    }

    private static String InputRestartOrEnd() {
        System.out.println(RESTART_OR_END_MESSAGE);
        String restartOrEndInput = Console.readLine();
        Validator.validateInputRestartOrEnd(restartOrEndInput);
        return restartOrEndInput;
    }
}
