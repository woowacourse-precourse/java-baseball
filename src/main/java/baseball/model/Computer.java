package baseball.model;

import baseball.util.Util;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private int ballCount = 0;

    private int strikeCount = 0;

    private ArrayList<Integer> numberList;

    public void generateNumber() {
        numberList = new ArrayList<>();

        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (Util.isNotDuplicated(numberList, randomNumber)) {
                numberList.add(randomNumber);
            }
        }
    }

    public void compare(List<Integer> guessNumbers) {
        for (int i = 0; i < guessNumbers.size(); i++) {
            search(guessNumbers.get(i), i);
        }

        hintPrint();
    }

    private void hintPrint() {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        } else if (ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (strikeCount == 0) {
            System.out.println(ballCount + "볼");
        } else {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }

    public void resetHint() {
        ballCount = 0;
        strikeCount = 0;
    }

    private void search(int guessNumber, int index) {
        if (guessNumber == numberList.get(index)) {
            strikeCount++;
            return;
        }

        for (Integer integer : numberList) {
            if (guessNumber == integer) {
                ballCount++;
            }
        }
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public ArrayList<Integer> getNumberList() {
        return numberList;
    }
}
