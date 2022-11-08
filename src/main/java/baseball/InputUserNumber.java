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


    ExcepetionCase exception = new ExcepetionCase();


    public void UserInputValue(String str) {
        setDigits(str);
    }
    public void UserInputValue() {
        String input = Console.readLine();
        setDigits(input);
    }






    private void setDigits(String input) {


        if(!exception.ThreeNumberException(input)) {
            throw new IllegalArgumentException();
        }

        this.eachdigit = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }





}
