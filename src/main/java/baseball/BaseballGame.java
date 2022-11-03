package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public final static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public final static int NUMBER_COUNT_TO_CREATED = 3;


    private List<Integer> computerNumbers = new ArrayList<>();
    private int strikeCount;
    private int ballCount;
    private String message;

    public BaseballGame() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void start() {
        createComputerNumbers();
        while (true) {
            String input = Console.readLine();
            System.out.println("숫자를 입력해주세요 : " + input);
            isWrongInputValue(input);
            calculateBallCount(input);
            String msg = answerMessage();
            strikeCount = 0;
            ballCount = 0;
            if (msg.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
        checkToRestartGame();
    }

    private void checkToRestartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartGame = Console.readLine();

        if (restartGame.equals("1")) {
            computerNumbers.clear();
            start();
        }

        if (restartGame.equals("2")) {
            System.out.println("게임을 종료합니다.");
        }
    }

    private String answerMessage() {

        if (strikeCount != 0 && ballCount != 0) {
            message = ballCount + "볼 " + strikeCount + "스트라이크";
            System.out.println(message);
            return message;
        }

        if (strikeCount == 0 && ballCount != 0) {
            message = ballCount + "볼";
            System.out.println(message);
            return message;
        }

        if (strikeCount != 0 && ballCount == 0) {
            message = strikeCount + "스트라이크";
            System.out.println(message);
            return message;
        }

        message = "낫싱";
        System.out.println(message);
        return message;
    }

    private void calculateBallCount(String input) {
        for (int i = 0; i < computerNumbers.size(); i++) {
            String val = String.valueOf(computerNumbers.get(i));
            if (input.contains(val)) {
                if (val.equals(String.valueOf(input.charAt(i)))) {
                    strikeCount++;
                }
                if (!val.equals(String.valueOf(input.charAt(i)))) {
                    ballCount++;
                }
            }
        }
    }

    private void isWrongInputValue(String input) {
        if (input.length() != NUMBER_COUNT_TO_CREATED) {
            throw new IllegalArgumentException();
        }

        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }

        if (input.contains("0")) {
            throw new IllegalArgumentException();
        }

        if (input.length() != input.chars().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    private void createComputerNumbers() {
        while (computerNumbers.size() < NUMBER_COUNT_TO_CREATED) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }
}
