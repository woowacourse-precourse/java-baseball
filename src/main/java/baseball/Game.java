package baseball;

import java.util.LinkedList;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    private static final int RANDOM_START_RANGE = 1;
    private static final int RANDOM_END_RANGE = 9;
    static final int MAX_NUMBER = 3;
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String OUT = "낫싱";
    static int ballCount,strikeCount;

    Game() {
        LinkedList<Integer> answer = new LinkedList<>();
        answer = setComputerNumber();
        LinkedList<Integer> userAnswer = getUserAnswer();
        strikeBallCount(answer,userAnswer);
    }

    private void strikeBallCount(LinkedList<Integer> answer, LinkedList<Integer> userAnswer) {
        for(int num : userAnswer){
            if(answer.get(userAnswer.indexOf(num))==num) {
                strikeCount++;
                continue;
            }
            if(checkListContains(answer,num)){
                ballCount++;
            }
        }
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

    public static LinkedList<Integer> getUserAnswer() {
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
