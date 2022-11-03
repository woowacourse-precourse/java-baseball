package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static List<Integer> answers;
    boolean isPlaying;

    Computer() {
        System.out.println(Message.START_GAME);
        answers = this.generateNumber();
    }

    private List<Integer> generateNumber() {
        List list = new ArrayList();
        while (list.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(number)) {
                list.add(number);
            }
        }
        return list;
    }

    public void checkAnswer(List<Integer> list) {
        int[] counts = new int[]{0, 0};

        for (int i = 0; i < list.size(); i++) {
            checkByBalls(i, list.get(i), counts);
        }
        printResult(counts);

        isPlaying = (counts[0] == User.NUMBER_DIGIT);
    }
    private void checkByBalls(int digit, int num, int[] counts) {
        if (answers.contains(num)) {
            if (answers.indexOf(num) == digit) {
                counts[0]++;
            } else {
                counts[1]++;
            }
        }
    }

    private void printResult(int[] counts) {
        StringBuilder sb = new StringBuilder();
        int strikeCount = counts[0];
        int ballCount = counts[1];


        if (ballCount != 0) {
            sb.append(ballCount).append(Message.BALL);
        }
        if (strikeCount != 0) {
            sb.append(strikeCount).append(Message.STRIKE).append(" ");
        }
        if (sb.length() == 0) {
            sb.append(Message.NOTHING);
        }
        System.out.println(sb);
    }
}
