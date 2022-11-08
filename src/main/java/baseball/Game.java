package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    private static final int RANDOM_START_RANGE = 1;
    private static final int RANDOM_END_RANGE = 9;
    static final int MAX_NUMBER = 3;
    private static final int NEW_GAME = 1;
    private static final int QUIT_GAME = 2;
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String OUT = "낫싱";

    Game() {
    }

    public void start() {
        int ballCount, strikeCount = 0;
        List<Integer> answer = getComputerNumber();
        while (strikeCount < MAX_NUMBER) {
            List<Integer> userAnswer = getUserAnswer();
            strikeCount = strikeCount(answer, userAnswer);
            ballCount = ballCount(answer, userAnswer);
            output(ballCount, strikeCount);
        }
    }

    public boolean checkNewGame() {
        System.out.println(MAX_NUMBER + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 " + NEW_GAME + ", 종료하려면 " + QUIT_GAME + "를 입력하세요.");
        String restartNumber = readLine();
        return checkRestartNumber(restartNumber) == 1;
    }

    private int checkRestartNumber(String restartNumber) {
        int num;
        try {
            num = Integer.parseInt(restartNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (num != 1 && num != 2) {
            throw new IllegalArgumentException();
        }
        return num;
    }

    private void output(int ballCount, int strikeCount) {
        String result = "";
        if (ballCount != 0) result += ballCount + BALL;
        if (ballCount != 0 && strikeCount != 0) result += " ";
        if (strikeCount != 0) result += strikeCount + STRIKE;
        if (result.equals("")) result = OUT;
        System.out.println(result);
    }

    private int strikeCount(List<Integer> answer, List<Integer> userAnswer) {
        int result = 0;
        for (int num : userAnswer) {
            if (answer.get(userAnswer.indexOf(num)) == num)
                result++;
        }
        return result;
    }

    private int ballCount(List<Integer> answer, List<Integer> userAnswer) {
        int result = 0;
        for (int i = 0; i < MAX_NUMBER; i++) {
            int number = answer.get(i);
            if (number != userAnswer.get(i) && userAnswer.contains(number)) {
                result++;
            }
        }
        return result;
    }

    private List<Integer> getComputerNumber() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < MAX_NUMBER) {
            numbers.add(getRandomNumber());
        }
        return new ArrayList<>(numbers);
    }

    private int getRandomNumber() {
        return pickNumberInRange(Game.RANDOM_START_RANGE, Game.RANDOM_END_RANGE);
    }

    private List<Integer> getUserAnswer() {
        List<Integer> userAnswer = new ArrayList<>();
        System.out.println("숫자를 입력해주세요 : ");
        for (String str : readLine().split(""))
            userAnswer.add(Integer.valueOf(str));
        inputValidate(userAnswer);
        return userAnswer;
    }

    private void inputValidate(List<Integer> userAnswer) {
        sizeValidate(userAnswer);
        containsZeroValidate(userAnswer);
        duplicateValidate(userAnswer);

    }

    private void duplicateValidate(List<Integer> userAnswer) {
        if (new HashSet<>(userAnswer).size() != MAX_NUMBER)
            throw new IllegalArgumentException();
    }

    private void containsZeroValidate(List<Integer> userAnswer) {
        if (userAnswer.contains(0)) {
            throw new IllegalArgumentException();
        }
    }

    private void sizeValidate(List<Integer> userAnswer) {
        if (userAnswer.size() != Game.MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }


}
