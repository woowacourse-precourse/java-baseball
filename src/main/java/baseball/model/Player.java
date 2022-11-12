package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static baseball.constValue.Constants.BALL_LEN;
import static baseball.constValue.Constants.ExceptionMessage.INPUT_DUPLICATE_ERROR_MESSAGE;
import static baseball.constValue.Constants.ExceptionMessage.INPUT_NUM_OR_SIZE_ERROR_MESSAGE;

public class Player {

    private String input;

    private ArrayList<Integer> inputNumber = new ArrayList<>(BALL_LEN);
    public Player(String input){
        this.input = input;
    }

    public ArrayList<Integer> getInputNumber() {
        return inputNumber;
    }

    public void checkException(){
        checkNotInputNumberOrOverSize();
        checkInputDuplicatedNumber();

    }

    public void setInputNumber(){
        for (int inputIdx = 0; inputIdx < BALL_LEN; inputIdx++) {
            int inputInt= this.input.charAt(inputIdx) - '0';
            this.inputNumber.add(inputInt);
        }
    }

    public void checkInputDuplicatedNumber() {
        Set<Character> set = getCharacterInput(this.input);
        if(isDuplicatedNumber(this.input, set)){
            throw new IllegalArgumentException(INPUT_DUPLICATE_ERROR_MESSAGE);
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

    public void checkNotInputNumberOrOverSize() {
        if(isNotInputNumberOrOverSize(this.input)){
            throw new IllegalArgumentException(INPUT_NUM_OR_SIZE_ERROR_MESSAGE);
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
