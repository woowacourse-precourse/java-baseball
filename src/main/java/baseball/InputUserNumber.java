package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class InputUserNumber {
    private static final int NUMBER = 3;
    private static final int MAXNumber = 9;
    private static final int MINNumber = 1;
    private int[] eachdigit;





    public static List<Integer> playerNumber(){
        ExcepetionCase exception = new ExcepetionCase();


        int playerNum = Integer.parseInt(Console.readLine());

        if (exception.ThreeNumberException(playerNum)){
            throw new IllegalArgumentException();
        }


        List<Integer> userNumber = new ArrayList<>();

        for (int i = 0; i < 3 ; i++) {
            userNumber.add(playerNum %10);
            playerNum /= 10;
        }

        return userNumber;
    }



    public void UserInputValue(String str) {
        setDigits(str);
    }
    public void UserInputValue() {
        String input = Console.readLine();
        setDigits(input);
    }






    private void setDigits(String input) {


        if(!isValidString(input)) {
            throw new IllegalArgumentException();
        }

        this.eachdigit = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }




    private boolean isValidString(String str) {
        if(!isRightLength(str) || !isMinToMax(str) || !isNotDuplicate(str)) {
            return false;
        }
        return true;
    }

    private boolean isRightLength(String input) {
        return input.length() == NUMBER;
    }

    private boolean isMinToMax(String input) {
        Pattern numberPattern = Pattern.compile(regax);
        return numberPattern.matcher(input).matches();
    }

    private boolean isNotDuplicate(String input) {
        Set<Character> set = new HashSet<>();
        for(char s: input.toCharArray()) {
            set.add(s);
        }
        return input.length() == set.size();
    }


}
