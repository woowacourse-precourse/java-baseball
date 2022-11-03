package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Game {
    private static final int _ball = 0;
    private static final int _strike = 1;
    private static final String _strike_str = "스트라이크";
    private static final String _ball_str = "볼";
    private static final String _no_correct = "낫싱";


    public boolean isGameEnd(List<Integer> result) {
        if (result.get(_strike) == 3) {
            return true;
        }
        return false;
    }

    public void printHint(List<Integer> result) {
        int ballCount = result.get(_ball);
        int strikeCount = result.get(_strike);

        if (ballCount > 0) {
            System.out.print(ballCount + _ball_str);
        }
        if (ballCount > 0 && strikeCount > 0) {
            System.out.print(" ");
        }
        if (strikeCount > 0) {
            System.out.print(strikeCount + _strike_str);
        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.print(_no_correct);
        }
        System.out.print("\n");
    }

    public List<Integer> getResult(List<Integer> input, List<Integer> comp) {
        List<Integer> result = new ArrayList<>();
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < 3; ++i) {
            if (comp.contains(input.get(i))) {
                ballCount += 1;
            }
        }
        for (int i = 0; i < 3; ++i) {
            if (comp.get(i) == input.get(i)) {
                strikeCount += 1;
                ballCount -= 1;
            }
        }
        result.add(ballCount);
        result.add(strikeCount);

        return result;
    }

    public List<Integer> splitDigits(int input) {
        List<Integer> digits = new ArrayList<>();
        int front = input / 100;
        int middle = (input % 100) / 10;
        int rear = input % 10;

        if (input == -1) {
            throw new IllegalArgumentException();
        }

        digits.add(front);
        digits.add(middle);
        digits.add(rear);

        return digits;
    }

    public int verifyInput(int input) {
        int front = input / 100;
        int middle = (input % 100) / 10;
        int rear = input % 10;

        if (input < 123 || input > 987 || front == middle || front == rear || middle == rear) {
            return -1;
        }
        return input;
    }

    public boolean isQuit(int input) {
        if (input == 2) {
            return true;
        } else if (input == 1) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    public List<Integer> generateRandomValue() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
