package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Number {
    static int COUNT = 3;
    static int MIN_NUMBER = 1;
    static int MAX_NUMBER = 9;
    static String START_SENTENCE = "숫자를 입해주세요 : ";
    static String REGEX = "(^[1-9]*$)";
    private int[] numbers;
    public Number() {}
    public void UserAnswer() {
        System.out.print(START_SENTENCE);
        String start = Console.readLine();
        setNumbers(start);
    }
    public int[] getNumbers() {
        return this.numbers;
    }
    public int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public void ComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < COUNT) {
            int randomNumber = getRandomNumber();
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.numbers = ConvertArrayListToArray(computer);
    }

    public int[] ConvertArrayListToArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public void setNumbers(String start) {
        if (!WrongString(start)) {
            throw new IllegalArgumentException();
        }
        this.numbers = ConvertArrayListToArray2(start);
    }

    public boolean WrongString(String start) {
        return CheckOnlyInteger(start) && CheckLength(start) && CheckDuplicate(start);
    }

    public boolean CheckOnlyInteger(String start) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(start);
        return matcher.find();
    }

    public boolean CheckLength(String start) {
        return start.length() == COUNT;
    }

    public boolean CheckDuplicate(String start) {
        HashSet<Character> set = new HashSet<>();
        for (char x : start.toCharArray()) {
            set.add(x);
        }
        return start.length() == set.size();
    }
    public int[] ConvertArrayListToArray2(String start) {
        return Arrays.stream(start.split("")).mapToInt(Integer::parseInt).toArray();
    }
}