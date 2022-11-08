package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Game {
    public static int ball;
    public static int strike;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;
    private static final int RESTART = 1;
    private static final int QUIT = 2;
    private static final int COUNT = 3;
    public static final String INIT_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String SUCCESS_MESSAGE = Game.COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 " + Game.RESTART + ", 종료하려면 " + Game.QUIT + "를 입력하세요.";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";

    static void initializeGame() {
        ball = 0;
        strike = 0;
        List<Integer> target = Game.RandomNumber();
        GameProcess(target);
    }

    static void GameProcess(List<Integer> target) {
        while (strike < 3) {
            ball = 0;
            strike = 0;
            List<Integer> answer = Game.UserInput();
            compareDigits(target, answer);
            displayResult();
        }
        if (strike == 3)
            displayResult();
    }

    public static void displayResult() {
        if (strike == 3) {
            System.out.println(strike + STRIKE_MESSAGE);
            System.out.println(SUCCESS_MESSAGE);
            System.out.println(RESTART_MESSAGE);
            restartGame();
        }
        else if (strike == 0 && ball == 0)
            System.out.println(NOTHING_MESSAGE);
        else if (strike == 0)
            System.out.println(ball + BALL_MESSAGE);
        else if (ball == 0)
            System.out.println(strike + STRIKE_MESSAGE);
        else
            System.out.println(ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE);
    }

    static void restartGame() {
        int temp = Integer.parseInt(Console.readLine());
        if (temp == 2)
            System.exit(0);
        initializeGame();
    }

    public static List<Integer> RandomNumber() {
        List<Integer> output = new ArrayList<>();
        while (output.size() < COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            if (!output.contains(randomNumber)) {
                output.add(randomNumber);
            }
        }
        return output;
    }

    public static boolean isRedundant(List<Integer> input) {
        if (input == null)
            return false;
        Set<Integer> set = new HashSet<>(input);
        return set.size() < input.size();
    }

    public static void isValid(List<Integer> input) {
        if (input.size() != COUNT)
            throw new IllegalArgumentException();
        if (input.contains(0))
            throw new IllegalArgumentException();
        if (isRedundant(input))
            throw new IllegalArgumentException();
    }

    public static List<Integer> UserInput() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String temp = Console.readLine();
        List<Integer> input = splitDigits(temp);
        isValid(input);
        return input;
    }

    public static List<Integer> splitDigits(final String input) {
        List<Integer> output = new ArrayList<>();
        for (Character c : input.toCharArray())
            output.add(Character.getNumericValue(c));
        return output;
    }

    public static void addStrikeCount() {
        strike++;
    }

    public static void addBallCount() {
        ball++;
    }

    public static void compareDigits(List<Integer> computer, List<Integer> user) {
        for (int i = 0; i < COUNT; i++) {
            if (user.get(i).equals(computer.get(i)))
                addStrikeCount();
            else if (user.contains(computer.get(i)))
                addBallCount();
        }
    }
}
