package baseball.model;

import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player {

    private int input;

    public void checkException(String input){
        checkNotInputNumberOrOverSize(input);

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
