package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Number {
    private static final int GAME_NUMBER_SIZE = 3;

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    private static final String INPUT_USER_NUMBER_ANNOUNCE = "숫자를 입력해주세요 : ";
    private static final String REGAX = "^["+START_INCLUSIVE+"-"+END_INCLUSIVE+"]*$";
    
    private List<Integer> gameNumber;
    
    public Number() {}
    
    public List<Integer> getGameNumber() {
        return this.gameNumber;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
    
    public void createRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>();

        while (computerNumber.size() < GAME_NUMBER_SIZE) {
            int randomNumber = getRandomNumber();
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        this.gameNumber = computerNumber;
    }

    private boolean isValidString(String str) {
        if(!isPatternMatch(str) || !isRightLength(str) || !isNotDuplicate(str)) {
            return false;
        }
        return true;
    }

    private void setGameNumer(String input) {
        if(!isValidString(input)) {
            throw new IllegalArgumentException();
        }
        this.gameNumber =  Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void getUserNumber() {
        System.out.print(INPUT_USER_NUMBER_ANNOUNCE);
        String input = Console.readLine();
        setGameNumer(input);
    }

    private boolean isPatternMatch(String input) {
        return Pattern.compile(REGAX).matcher(input).matches();
    }

    private boolean isRightLength(String input) {
        return input.length() == GAME_NUMBER_SIZE;
    }

    private boolean isNotDuplicate(String input) {
        Set<Character> checkDuplication = new HashSet<>();
        for(char s: input.toCharArray()) {
            checkDuplication.add(s);
        }
        return input.length() == checkDuplication.size();
    }
}
