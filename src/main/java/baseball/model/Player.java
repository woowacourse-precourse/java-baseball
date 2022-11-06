package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player {

    private static final int BALL_LEN=3;
    private String input;

    private ArrayList<Integer> inputNumber = new ArrayList<>(BALL_LEN);
    public Player(String input){
        this.input = input;
    }

    public ArrayList<Integer> getInputNumber() {
        return inputNumber;
    }

    public void checkException(){
        checkNotInputNumberOrOverSize(this.input);
        checkInputDuplicatedNumber(this.input);

    }

    public void setInputNumber(){
        for (int inputIdx = 0; inputIdx < BALL_LEN; inputIdx++) {
            int inputInt= this.input.charAt(inputIdx) - '0';
            this.inputNumber.add(inputInt);
        }
    }

    private static void checkInputDuplicatedNumber(String input) {
        Set<Character> set = getCharacterInput(input);
        if(isDuplicatedNumber(input, set)){
            throw new IllegalArgumentException("야구 게임의 숫자가 중복입니다.");
        }
    }

    private static boolean isDuplicatedNumber(String input, Set<Character> set) {
        return set.size() != input.length();
    }

    private static Set<Character> getCharacterInput(String input) {
        Set<Character> set = new HashSet<>();
        for (int inputIdx = 0; inputIdx < input.length(); inputIdx++) {
            set.add(input.charAt(inputIdx));
        }
        return set;
    }

    private static void checkNotInputNumberOrOverSize(String input) {
        if(isNotInputNumberOrOverSize(input)){
            throw new IllegalArgumentException("야구 게임은 3자리의 숫자만 가능합니다.");
        }
    }

    private static boolean isNotInputNumberOrOverSize(String input) {

        boolean found=true;

        String regex = "^[0-9]{3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if(matcher.matches()){
            found = false;
        }
        return found;
    }
}
