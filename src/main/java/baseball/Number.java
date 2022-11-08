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
    static String START_SENTENCE = "숫자를 입력해주세요 : ";
    static String REGEX1 = "(^[1-9]*$)";
    static String REGEX2 = "";
    private int[] numbers;
    public Number() {}
    public void setUserNumbers() {
        System.out.print(START_SENTENCE);
        String userInput = Console.readLine();
        setUserNumbers(userInput);
    }
    public int[] getNumbers() {
        return this.numbers;
    }
    public int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public void setComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < COUNT) {
            int randomNumber = getRandomNumber();
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.numbers = convertArrayListToArray(computer);
    }

    public int[] convertArrayListToArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public void setUserNumbers(String userInput) {
        if (!wrongString(userInput)) {
            throw new IllegalArgumentException();
        }
        this.numbers = convertArrayListToArray2(userInput);
    }

    public boolean wrongString(String userInput) {
        return checkOnlyInteger(userInput) && checkLength(userInput) && checkDuplicate(userInput);
    }

    public boolean checkOnlyInteger(String userInput) {
        Pattern pattern = Pattern.compile(REGEX1);
        Matcher matcher = pattern.matcher(userInput);
        return matcher.find();
    }

    public boolean checkLength(String userInput) {
        return userInput.length() == COUNT;
    }

    public boolean checkDuplicate(String userInput) {
        HashSet<Character> set = new HashSet<>();
        for (char x : userInput.toCharArray()) {
            set.add(x);
        }
        return userInput.length() == set.size();
    }
    public int[] convertArrayListToArray2(String userInput) {
        return Arrays.stream(userInput.split(REGEX2)).mapToInt(Integer::parseInt).toArray();
    }
}