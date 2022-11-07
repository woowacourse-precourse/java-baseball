package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGame extends Game {
    private final int NUMBER_LIMIT = 3;
    private final int RESTART_NUMBER = 1;
    private final int CLOSE_NUMBER = 2;
    private final String GREETING_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String CLOSE_MESSAGE = NUMBER_LIMIT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String NOTHING_MESSAGE = "낫싱";
    private final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final String RESTART_MESSAGE = "게임을 새로 시작하려면 " + RESTART_NUMBER + ", 종료하려면 " + CLOSE_NUMBER + "를 입력하세요.";

    private boolean isFirst = true;

    @Override
    protected void greet() {
        System.out.println(GREETING_MESSAGE);
    }

    @Override
    protected void play() {
        int answer = getRandomNumber();
        while (true) {
            System.out.print(INPUT_MESSAGE);
            String input = Console.readLine().replaceAll(" ", "");

            validateInputNumber(input);

            int target = Integer.parseInt(input);
            int strikeCount = getStrike(target, answer);
            int ballCount = getBall(target, answer) - strikeCount;

            if (strikeCount > 0 && ballCount > 0) System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            else if (strikeCount > 0) System.out.println(strikeCount + "스트라이크");
            else if (ballCount > 0) System.out.println(ballCount + "볼");
            else System.out.println(NOTHING_MESSAGE);

            if (strikeCount == NUMBER_LIMIT) break;
        }
    }

    @Override
    protected void close() {
        System.out.println(CLOSE_MESSAGE);
    }

    @Override
    protected boolean restart() {
        if (isFirst) {
            isFirst = false;
            return true;
        }
        System.out.println(RESTART_MESSAGE);
        String input = Console.readLine().replaceAll(" ", "");

        validateRestartNumber(input);
        return Integer.parseInt(input) == RESTART_NUMBER;
    }

    public int getStrike(int number, int target) {
        int strikeCount = 0;
        String targetStr = Integer.toString(target);
        String inputStr = Integer.toString(number);

        for (int i = 0; i < targetStr.length(); i++) {
            if (inputStr.charAt(i) == targetStr.charAt(i)) strikeCount++;
        }

        return strikeCount;
    }

    public int getBall(int number, int target) {
        int ballCount = 0;
        String targetStr = Integer.toString(target);
        String inputStr = Integer.toString(number);

        for (int i = 0; i < targetStr.length(); i++) {
            String now = String.valueOf(inputStr.charAt(i));
            if (targetStr.contains(now)) ballCount++;
        }

        return ballCount;
    }

    public int getRandomNumber() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < NUMBER_LIMIT) {
            int random = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(random)) answer.add(random);
        }

        return Integer.parseInt(answer.stream().map(String::valueOf).collect(Collectors.joining()));

    }

    public void validateInputNumber(String validateTarget) {
        String exceptionMessage = NUMBER_LIMIT + "자리의 서로 다른 숫자(1-9)를 입력하세요.";

        if (!validateTarget.matches("^[1-9]+$")) throw new IllegalArgumentException(exceptionMessage);
        if (validateTarget.length() != NUMBER_LIMIT) throw new IllegalArgumentException(exceptionMessage);

        int size = (new HashSet<>(List.of(validateTarget.split("")))).size();
        if (size != NUMBER_LIMIT) throw new IllegalArgumentException(exceptionMessage);
    }

    public void validateRestartNumber(String validateTarget) {
        if (!validateTarget.matches("^[1-9]+$")) throw new IllegalArgumentException(RESTART_MESSAGE);

        int answer = Integer.parseInt(validateTarget);
        if (!(answer == RESTART_NUMBER || answer == CLOSE_NUMBER)) throw new IllegalArgumentException(RESTART_MESSAGE);
    }
}
