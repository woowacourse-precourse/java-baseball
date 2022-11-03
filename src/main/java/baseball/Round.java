package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Round {

    private final Computer computer;
    private Numbers numbers;

    public Round(Computer computer) {
        this.computer = computer;
    }

    public void startNewRound()  {
        Print.printRoundStart();
        String inputString = readNumber();
        inputNewNumbers(inputString);
    }

    private String readNumber() {
        String inputString;
        try {
            Constructor<Console> constructor = Console.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            Console console = constructor.newInstance();

            Method readLine = Console.class.getDeclaredMethod("readLine");
            readLine.setAccessible(true);
            inputString = (String) readLine.invoke(console);

            Field scannerField = Console.class.getDeclaredField("scanner");
            scannerField.setAccessible(true);
            Scanner scanner = (Scanner) scannerField.get(console);
            scannerField.set(console, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return inputString;
    }

    private void inputNewNumbers(String inputString) {
        int input = Integer.parseInt(inputString);
        numbers = new Numbers(input);
    }

    public void playRound() {
        HashMap<Hint, Integer> hintCountMap = new HashMap<>();
        for (int index = 0; index < 3; index++) {
            Hint hint = getHint(index);
            putHintCountMap(hint, hintCountMap);
        }
        Print.printRoundResult(hintCountMap);
    }

    private void putHintCountMap (Hint hint, HashMap<Hint, Integer> hintCountMap) {
        if (!hintCountMap.containsKey(hint)) {
            hintCountMap.put(hint, 0);
        }
        hintCountMap.put(hint, hintCountMap.get(hint) + 1);
    }

    private Hint getHint(int index) {
        if (isStrike(index)) {
            return Hint.STRIKE;
        }
        if (isBall(index)) {
            return Hint.BALL;
        }
        return Hint.NOTHING;
    }

    private boolean isBall(int index) {
        // 이전 인덱스 : 0 -> 2
        int prevIndex = (index + 2) % 3;
        // 이후 인덱스 : 2 -> 0
        int nextIndex = (index + 1) % 3;

        boolean isPrevBall = computer.findComputerNumber(prevIndex)
                .equals(numbers.findNumber(index));
        boolean isNextBall = computer.findComputerNumber(nextIndex)
                .equals(numbers.findNumber(index));

        return  isPrevBall || isNextBall;
    }

    private boolean isStrike(int index) {
        return computer.findComputerNumber(index)
                .equals(numbers.findNumber(index));
    }
}
