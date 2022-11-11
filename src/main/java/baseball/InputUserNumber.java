package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;


public class InputUserNumber {
    private static final int SIZE = 3;
    private static final int MAXNumber = 9;
    private static final int MINNumber = 1;
    private static final String INPUT_SENTENCE = "숫자를 입력해주세요 : ";
    private int[] eachdigit;
    private static String input;

    ExcepetionCase exception = new ExcepetionCase();



    private String UserInputValue() {
        System.out.print(INPUT_SENTENCE);
        String input = Console.readLine();
        return input;

    }

    public int[] getDigits() {

        return this.eachdigit;
    }





    public void setDigits() {

        this.input = UserInputValue();

        if(!exception.ThreeNumberException(input)) {
            throw new IllegalArgumentException();
        }

        this.eachdigit = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }





}
