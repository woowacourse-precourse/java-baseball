package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    static List<Integer> answers;

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

    public boolean checkAnswer(List<Integer> list) {
        int[] counts = new int[]{0, 0};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            checkByBalls(i, list.get(i), counts);
        }

        printResult(counts);

        return counts[0] == User.NUMBER_DIGIT;
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
}
