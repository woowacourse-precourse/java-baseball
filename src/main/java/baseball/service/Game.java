package baseball.service;

import baseball.domain.Menu;
import baseball.domain.Number;
import baseball.domain.Numbers;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    private static final StringBuilder RESULT = new StringBuilder();
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String BLANK = "";
    private static final String SPACING = " ";
    private static final int INITIALIZE = 0;
    private static final String THREE_STRIKE = "3스트라이크";
    private static final int EMPTY = 0;

    private Game() {
    }

    public static void start() {
        Numbers computer = new Numbers(getComputerInput());
        play(computer);
    }

    private static List<Number> getComputerInput() {
        return IntStream.range(0, 3)
                .map(n -> Randoms.pickNumberInRange(1, 9))
                .mapToObj(Number::new)
                .collect(Collectors.toList());
    }

    private static void play(Numbers computer) {
        RESULT.setLength(INITIALIZE);
        View.printInputRequest();
        Numbers player = new Numbers(getPlayerInput());
        compare(computer, player);
        View.printResult(RESULT.toString());
        if (isThreeStrike()) {
            end();
            return;
        }
        play(computer);
    }

    private static List<Number> getPlayerInput() {
        String input = Console.readLine();
        checkBlank(input);
        return IntStream.range(0, input.length())
                .mapToObj(n -> new Number(input.charAt(n)))
                .collect(Collectors.toList());
    }

    private static void checkBlank(String input) {
        if (input.equals(BLANK)) {
            throw new IllegalArgumentException("값이 입력되지 않았습니다.");
        }
    }

    private static void compare(Numbers computer, Numbers player) {
        checkBall(computer, player);
        checkStrike(computer, player);
        checkNothing();
    }

    private static void checkBall(Numbers computer, Numbers player) {
        int ballCount = player.getBallCount(computer);
        if (ballCount > EMPTY) {
            RESULT.append(ballCount).append(BALL).append(SPACING);
        }
    }

    private static void checkStrike(Numbers computer, Numbers player) {
        int strikeCount = player.getStrikeCount(computer);
        if (strikeCount > EMPTY) {
            RESULT.append(strikeCount).append(STRIKE);
        }
    }

    private static void checkNothing() {
        if (RESULT.length() == EMPTY) {
            RESULT.append(NOTHING);
        }
    }

    private static boolean isThreeStrike() {
        return THREE_STRIKE.equals(RESULT.toString());
    }

    private static void end() {
        View.printRight();
        View.printEnd();
        askToContinueGame();
    }

    private static void askToContinueGame() {
        View.printMenu();
        Menu menu = new Menu(Console.readLine());
        if (menu.chooseRestart()) {
            start();
        }
    }
}
