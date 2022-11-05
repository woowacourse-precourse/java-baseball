package baseball;

import java.util.LinkedList;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    private static final int RANDOM_START_RANGE = 1;
    private static final int RANDOM_END_RANGE = 9;
    static final int MAX_NUMBER_COUNT = 3;

    Game() {
        LinkedList<Integer> answer = new LinkedList<>();
        answer = setComputerNumber();
        LinkedList<Integer> UserAnswer = getUserAnswer();
    }

    public LinkedList<Integer> setComputerNumber() {
        int RandomNumber;
        LinkedList<Integer> result = new LinkedList<>();
        while (result.size() < MAX_NUMBER_COUNT) {
            RandomNumber = getRandomNumber();
            if (!checkListContains(result, RandomNumber))
                result.add(RandomNumber);
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

    public static LinkedList<Integer> getUserAnswer() {
        LinkedList<Integer> userAnswer = new LinkedList<>();
        System.out.println("숫자를 입력해주세요 : ");
        for (String str : readLine().split(""))
            userAnswer.add(Integer.valueOf(str));
        Game.checkInputValue(userAnswer);
        return userAnswer;
    }

    private static void checkInputValue(LinkedList<Integer> userAnswer) {
        if (userAnswer.size() != Game.MAX_NUMBER_COUNT) {
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
