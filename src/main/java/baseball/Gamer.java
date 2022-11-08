package baseball;

import static baseball.Constant.*;
import static baseball.Util.*;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Gamer {
    public List<Integer> gamerNumber = new ArrayList<>();

    public void checkException(String inputNumber) {
        isWeirdSize(inputNumber);
        isNumber(inputNumber);
        isSameEachNumber(inputNumber);
    }
    public void putInGamerNumber(int guessNumber) {
        gamerNumber.clear();
        gamerNumber.add(guessNumber / 100);
        gamerNumber.add((guessNumber % 100)/10);
        gamerNumber.add(guessNumber % 10);
    }
    public void inputNumber() {
        System.out.print(INPUT_NUMBER);
        String inputNumber = Console.readLine();
        checkException(inputNumber);
        int guessNumber = Integer.parseInt(inputNumber);
        putInGamerNumber(guessNumber);
    }
    public boolean inputRestartNumber() {
        String restartNumber = Console.readLine();
        if (restartNumber.equals(RESTART_BUTTON)) {
            return false;
        } else if (restartNumber.equals(FINISH_BUTTON)) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
