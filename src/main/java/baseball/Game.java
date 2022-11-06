package baseball;

import java.util.LinkedList;

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

    public static void start(Game game) {
        int ballCount, strikeCount = 0;
        LinkedList<Integer> answer = game.setComputerNumber();
        while (strikeCount < MAX_NUMBER) {
            LinkedList<Integer> userAnswer = game.getUserAnswer();
            strikeCount = game.strikeCount(answer, userAnswer);
            ballCount = game.ballCount(answer, userAnswer);
            game.output(ballCount, strikeCount);
        }
        if (checkNewGame() == NEW_GAME) {
            start(new Game());
        }
    }

    private static int checkNewGame() {
        System.out.println(MAX_NUMBER + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 " + NEW_GAME + ", 종료하려면 " + QUIT_GAME + "를 입력하세요.");

        String restartNumber = readLine();
        return checkRestartNumber(restartNumber);
    }

    private static int checkRestartNumber(String restartNumber) {
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
        if (strikeCount != 0) result += strikeCount + STRIKE;
        if (result.equals("")) result = OUT;
        System.out.println(result);
    }

    private int strikeCount(LinkedList<Integer> answer, LinkedList<Integer> userAnswer) {
        int result = 0;
        for (int num : userAnswer) {
            if (answer.get(userAnswer.indexOf(num)) == num)
                result++;
        }
        return result;
    }

    private int ballCount(LinkedList<Integer> answer, LinkedList<Integer> userAnswer) {
        int result = 0;
        for (int num : userAnswer) {
            if (answer.get(userAnswer.indexOf(num)) == num);
             else if (checkListContains(answer, num))
                result++;
        }
        return result;
    }

    public LinkedList<Integer> setComputerNumber() {
        int randomNumber;
        LinkedList<Integer> result = new LinkedList<>();
        while (result.size() < MAX_NUMBER) {
            randomNumber = getRandomNumber();
            if (!checkListContains(result, randomNumber))
                result.add(randomNumber);
        }
        return result;
    }

    static boolean checkListContains(LinkedList<Integer> list, int num) {
        for (int value : list) {
            if (value == num) return true;
        }
        return false;
    }

    private int getRandomNumber() {
        return pickNumberInRange(Game.RANDOM_START_RANGE, Game.RANDOM_END_RANGE);
    }

    public LinkedList<Integer> getUserAnswer() {
        LinkedList<Integer> userAnswer = new LinkedList<>();
        System.out.println("숫자를 입력해주세요 : ");
        for (String str : readLine().split(""))
            userAnswer.add(Integer.valueOf(str));
        Game.checkInputValue(userAnswer);
        return userAnswer;
    }

    private static void checkInputValue(LinkedList<Integer> userAnswer) {
        if (userAnswer.size() != Game.MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
        if (userAnswer.contains(0)) {
            throw new IllegalArgumentException();
        }
        LinkedList<Integer> result = new LinkedList<>();
        for (int num : userAnswer) {
            if (!checkListContains(result, num))
                result.add(num);
            else
                throw new IllegalArgumentException();
        }
    }


}
