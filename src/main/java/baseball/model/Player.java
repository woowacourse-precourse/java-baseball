package baseball.model;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player {

    private int input;


    public void checkException(String input){
        checkNotInputNumberOrOverSize(input);
        checkInputDuplicatedNumber(input);

    }

    private static void checkInputDuplicatedNumber(String input) {
        Set<Character> set = getCharacterInput(input);
        if(isDuplicatedNumber(input, set)){
            throw new IllegalArgumentException();
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
            throw new IllegalArgumentException();
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
