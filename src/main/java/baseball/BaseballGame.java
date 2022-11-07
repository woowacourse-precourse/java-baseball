package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class BaseballGame {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final int NUMBER_OF_BALLS = 3;
    private static final int REPLAY = 1;
    private static final int OVER = 2;

    public void playGame() {
        System.out.println(GAME_START_MESSAGE);
    }

    public String inputNumber() throws IOException {
        System.out.print(INPUT_NUMBER_MESSAGE);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String number = bufferedReader.readLine();
        validate(number);
        return number;
    }


    private boolean isGameOver(Referee referee) {
        if (referee.getStrikeCount() == NUMBER_OF_BALLS) {
            System.out.println(NUMBER_OF_BALLS + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private boolean isReplaying() throws IOException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Integer number = Integer.valueOf(
                new BufferedReader(new InputStreamReader(System.in))
                .readLine());

        return number.equals(REPLAY);
    }

    private void printResult(Referee referee) {
        int ballCount = referee.getBallCount();
        int strikeCount = referee.getStrikeCount();

        printBallCount(ballCount);
        printStrikeCount(strikeCount);
        printNothing(ballCount, strikeCount);
        System.out.println();
    }

    private void printBallCount(int ballCount) {
        if (ballCount > 0) {
            System.out.print(ballCount + "볼 ");
        }
    }

    private void printStrikeCount(int strikeCount) {
        if (strikeCount > 0) {
            System.out.print(strikeCount + "스트라이크");
        }
    }

    private void printNothing(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.print("낫싱");
        }
    }

    private void validate(String number) {
        validateNumberLength(number);
        validateNumberRange(number);
        validateNumberDuplication(number);
    }

    private void validateNumberLength(String number) {
        if (number.length() != NUMBER_OF_BALLS) {
            throw new IllegalArgumentException(NUMBER_OF_BALLS + "자리 숫자만 입력 가능합니다.");
        }
    }

    private void validateNumberRange(String number) {
        if (number.matches("[^1-9]")) {
            throw new IllegalArgumentException("1과 9사이의 숫자만 입력 가능합니다.");
        }
    }

    private void validateNumberDuplication(String number) {
        if (IntStream.range(0, 10)
                .anyMatch(digit -> getDigitCount(number, digit) >= 2)) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    private long getDigitCount(String number, int digit) {
        return Arrays.stream(number.split(""))
                .filter(digitString -> digitString.equals(String.valueOf(digit)))
                .count();
    }
}
