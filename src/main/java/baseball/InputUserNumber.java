package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class InputUserNumber {
    private static final String INPUT_SENTENCE = "숫자를 입력해주세요 : ";
    private List<Integer> eachdigit = new ArrayList<>();
    private static String input;

    ExcepetionCase exception = new ExcepetionCase();



    private String UserInputValue() {
        System.out.print(INPUT_SENTENCE);
        String input = Console.readLine();
        return input;

    }

    public List<Integer> getDigits() {

        return this.eachdigit;
    }





    public void setDigits() {

        this.input = UserInputValue();

        if(!exception.ThreeNumberException(input)) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i<input.length(); i ++){
            eachdigit.add((int) input.charAt(i));
        }

    }

    public void setDigits(String input) { //Test를 위해 메소드 추가

        this.input = "413";
        if(!exception.ThreeNumberException(input)) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i<input.length(); i ++){
            eachdigit.add(Character.getNumericValue(input.charAt(i)));
        }

    }




}
